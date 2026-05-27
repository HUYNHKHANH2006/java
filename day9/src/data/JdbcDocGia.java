package data;

import domain.DocGia;
import java.sql.*;
import java.util.*;

public class JdbcDocGia {
    private final String SQL_INSERT =
        "INSERT INTO DOCGIA(MADOCGIA,HOTEN,DIACHI,SODIENTHOAI,NGAYDANGKY) VALUES(?,?,?,?,?)";
    private final String SQL_UPDATE =
        "UPDATE DOCGIA SET HOTEN=?,DIACHI=?,SODIENTHOAI=? WHERE MADOCGIA=?";
    private final String SQL_DELETE = "DELETE FROM DOCGIA WHERE MADOCGIA=?";
    private final String SQL_SELECT = "SELECT * FROM DOCGIA ORDER BY MADOCGIA";

    /** Mượn sách: thêm bản ghi vào MUONSACH */
    private final String SQL_MUON =
        "INSERT INTO MUONSACH(MADOCGIA,MASACH,NGAYMUON,NGAYTRA_DU_KIEN) VALUES(?,?,CURDATE(),?)";

    /** Trả sách: cập nhật ngày trả thực tế */
    private final String SQL_TRA =
        "UPDATE MUONSACH SET NGAYTRA_THUC_TE=CURDATE() WHERE MADOCGIA=? AND MASACH=? AND NGAYTRA_THUC_TE IS NULL";

    public int insert(DocGia dg) {
        Connection conn = null; PreparedStatement stmt = null; int rows = 0;
        try {
            conn = JavaConnectionB4.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, dg.getMaDocGia());
            stmt.setString(2, dg.getHoTen());
            stmt.setString(3, dg.getDiaChi());
            stmt.setString(4, dg.getSoDienThoai());
            stmt.setString(5, dg.getNgayDangKy());
            rows = stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
        finally { JavaConnectionB4.close(stmt); JavaConnectionB4.close(conn); }
        return rows;
    }

    public int update(DocGia dg) {
        Connection conn = null; PreparedStatement stmt = null; int rows = 0;
        try {
            conn = JavaConnectionB4.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, dg.getHoTen());
            stmt.setString(2, dg.getDiaChi());
            stmt.setString(3, dg.getSoDienThoai());
            stmt.setString(4, dg.getMaDocGia());
            rows = stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
        finally { JavaConnectionB4.close(stmt); JavaConnectionB4.close(conn); }
        return rows;
    }

    public int delete(String maDG) {
        Connection conn = null; PreparedStatement stmt = null; int rows = 0;
        try {
            conn = JavaConnectionB4.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, maDG);
            rows = stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
        finally { JavaConnectionB4.close(stmt); JavaConnectionB4.close(conn); }
        return rows;
    }

    public List<DocGia> select() {
        List<DocGia> list = new ArrayList<>();
        Connection conn = null; PreparedStatement stmt = null; ResultSet rs = null;
        try {
            conn = JavaConnectionB4.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                DocGia dg = new DocGia();
                dg.setMaDocGia(rs.getString("MADOCGIA"));
                dg.setHoTen(rs.getString("HOTEN"));
                dg.setDiaChi(rs.getString("DIACHI"));
                dg.setSoDienThoai(rs.getString("SODIENTHOAI"));
                dg.setNgayDangKy(rs.getString("NGAYDANGKY"));
                list.add(dg);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        finally { JavaConnectionB4.close(rs); JavaConnectionB4.close(stmt); JavaConnectionB4.close(conn); }
        return list;
    }

    /** Đăng ký mượn sách */
    public int muonSach(String maDocGia, String maSach, String ngayTraDuKien) {
        Connection conn = null; PreparedStatement stmt = null; int rows = 0;
        try {
            conn = JavaConnectionB4.getConnection();
            stmt = conn.prepareStatement(SQL_MUON);
            stmt.setString(1, maDocGia);
            stmt.setString(2, maSach);
            stmt.setString(3, ngayTraDuKien);
            rows = stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
        finally { JavaConnectionB4.close(stmt); JavaConnectionB4.close(conn); }
        return rows;
    }

    /** Xác nhận trả sách */
    public int traSach(String maDocGia, String maSach) {
        Connection conn = null; PreparedStatement stmt = null; int rows = 0;
        try {
            conn = JavaConnectionB4.getConnection();
            stmt = conn.prepareStatement(SQL_TRA);
            stmt.setString(1, maDocGia);
            stmt.setString(2, maSach);
            rows = stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
        finally { JavaConnectionB4.close(stmt); JavaConnectionB4.close(conn); }
        return rows;
    }

    /** Liệt kê sách đang mượn của một độc giả */
    public void listSachDangMuon(String maDocGia) {
        Connection conn = null; PreparedStatement stmt = null; ResultSet rs = null;
        try {
            conn = JavaConnectionB4.getConnection();
            String sql = "SELECT s.MASACH, s.TENSACH, m.NGAYMUON, m.NGAYTRA_DU_KIEN " +
                         "FROM MUONSACH m JOIN SACH s ON m.MASACH = s.MASACH " +
                         "WHERE m.MADOCGIA=? AND m.NGAYTRA_THUC_TE IS NULL ORDER BY m.NGAYMUON";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, maDocGia);
            rs = stmt.executeQuery();
            System.out.printf("%-8s %-30s %-12s %-12s%n","MaSach","Tên sách","Ngày mượn","Hạn trả");
            System.out.println("-".repeat(65));
            while (rs.next())
                System.out.printf("%-8s %-30s %-12s %-12s%n",
                    rs.getString("MASACH"), rs.getString("TENSACH"),
                    rs.getString("NGAYMUON"), rs.getString("NGAYTRA_DU_KIEN"));
        } catch (SQLException e) { e.printStackTrace(); }
        finally { JavaConnectionB4.close(rs); JavaConnectionB4.close(stmt); JavaConnectionB4.close(conn); }
    }
}
