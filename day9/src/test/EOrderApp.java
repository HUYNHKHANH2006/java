package test;

import data.JavaConnectionB2;
import java.sql.*;
import java.util.*;

public class EOrderApp {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n====== HỆ THỐNG E-ORDER ======");
            System.out.println("1. Xem menu");
            System.out.println("2. Tạo order mới");
            System.out.println("3. Xem các order hôm nay");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            int choice = Integer.parseInt(sc.nextLine().trim());
            switch (choice) {
                case 1: showMenu();    break;
                case 2: createOrder(); break;
                case 3: showOrders();  break;
                case 0: running = false; break;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    /** Hiển thị danh sách món ăn */
    static void showMenu() {
        System.out.println("\n--- MENU ---");
        Connection conn = null; PreparedStatement stmt = null; ResultSet rs = null;
        try {
            conn = JavaConnectionB2.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM MonAn ORDER BY MaMon");
            rs = stmt.executeQuery();
            System.out.printf("%-8s %-25s %10s%n", "Mã", "Tên món", "Đơn giá");
            System.out.println("-".repeat(45));
            while (rs.next())
                System.out.printf("%-8s %-25s %,10.0f%n",
                    rs.getString("MaMon"), rs.getString("TenMon"), rs.getDouble("DonGia"));
        } catch (SQLException e) { e.printStackTrace(); }
        finally { JavaConnectionB2.close(rs); JavaConnectionB2.close(stmt); JavaConnectionB2.close(conn); }
    }

    /** Tạo order mới */
    static void createOrder() {
        System.out.print("Nhập số bàn: ");
        int soBan = Integer.parseInt(sc.nextLine().trim());

        Map<String, Integer> cart = new LinkedHashMap<>();
        boolean ordering = true;
        while (ordering) {
            System.out.print("Nhập mã món (hoặc 'done' để kết thúc): ");
            String maM = sc.nextLine().trim();
            if (maM.equalsIgnoreCase("done")) { ordering = false; continue; }
            System.out.print("Số lượng: ");
            int sl = Integer.parseInt(sc.nextLine().trim());
            cart.put(maM, cart.getOrDefault(maM, 0) + sl);
        }
        if (cart.isEmpty()) { System.out.println("Order trống!"); return; }

        Connection conn = null;
        try {
            conn = JavaConnectionB2.getConnection();
            conn.setAutoCommit(false);

            // Tạo hóa đơn
            PreparedStatement psHD = conn.prepareStatement(
                "INSERT INTO HoaDon(SoBan) VALUES(?)", Statement.RETURN_GENERATED_KEYS);
            psHD.setInt(1, soBan);
            psHD.executeUpdate();
            ResultSet genKeys = psHD.getGeneratedKeys();
            int maHD = 0;
            if (genKeys.next()) maHD = genKeys.getInt(1);
            genKeys.close();
            psHD.close();

            // Thêm chi tiết order
            PreparedStatement psCT = conn.prepareStatement(
                "INSERT INTO ChiTietOrder(MaHD,MaMon,SoLuong) VALUES(?,?,?)");
            for (Map.Entry<String, Integer> e : cart.entrySet()) {
                psCT.setInt(1, maHD);
                psCT.setString(2, e.getKey());
                psCT.setInt(3, e.getValue());
                psCT.addBatch();
            }
            psCT.executeBatch();
            psCT.close();

            conn.commit();
            System.out.println("✔ Order #" + maHD + " cho bàn " + soBan + " đã gửi xuống bếp!");
        } catch (SQLException e) {
            e.printStackTrace();
            try { if (conn != null) conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
        } finally { JavaConnectionB2.close(conn); }
    }

    /** Xem các order hôm nay */
    static void showOrders() {
        System.out.println("\n--- ORDER HÔM NAY ---");
        Connection conn = null; PreparedStatement stmt = null; ResultSet rs = null;
        try {
            conn = JavaConnectionB2.getConnection();
            String sql =
                "SELECT h.MaHD, h.SoBan, h.ThoiGian, m.TenMon, c.SoLuong, " +
                "       (m.DonGia * c.SoLuong) AS ThanhTien " +
                "FROM HoaDon h " +
                "JOIN ChiTietOrder c ON h.MaHD = c.MaHD " +
                "JOIN MonAn m ON c.MaMon = m.MaMon " +
                "WHERE DATE(h.ThoiGian) = CURDATE() " +
                "ORDER BY h.MaHD, m.TenMon";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            System.out.printf("%-6s %-5s %-20s %-20s %5s %12s%n",
                "MaHD", "Bàn", "Thời gian", "Món", "SL", "Thành tiền");
            System.out.println("-".repeat(75));
            while (rs.next())
                System.out.printf("%-6d %-5d %-20s %-20s %5d %,12.0f%n",
                    rs.getInt("MaHD"), rs.getInt("SoBan"),
                    rs.getString("ThoiGian"), rs.getString("TenMon"),
                    rs.getInt("SoLuong"), rs.getDouble("ThanhTien"));
        } catch (SQLException e) { e.printStackTrace(); }
        finally { JavaConnectionB2.close(rs); JavaConnectionB2.close(stmt); JavaConnectionB2.close(conn); }
    }
}
