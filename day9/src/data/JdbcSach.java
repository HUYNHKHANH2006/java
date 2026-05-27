package data;

import domain.Sach;
import java.sql.*;
import java.util.*;

public class JdbcSach {
    private final String SQL_INSERT =
        "INSERT INTO SACH(MASACH,TENSACH,TACGIA,THELOAI,NAMXB,SOLUONG,GIABAN) VALUES(?,?,?,?,?,?,?)";
    private final String SQL_UPDATE =
        "UPDATE SACH SET TENSACH=?,TACGIA=?,THELOAI=?,NAMXB=?,SOLUONG=?,GIABAN=? WHERE MASACH=?";
    private final String SQL_DELETE     = "DELETE FROM SACH WHERE MASACH=?";
    private final String SQL_SELECT     = "SELECT * FROM SACH ORDER BY MASACH";
    private final String SQL_BY_THELOAI = "SELECT * FROM SACH WHERE THELOAI=? ORDER BY TENSACH";
    private final String SQL_HET        = "SELECT * FROM SACH WHERE SOLUONG = 0";

    public int insert(Sach s) {
        Connection conn = null; PreparedStatement stmt = null; int rows = 0;
        try {
            conn = JavaConnectionB4.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, s.getMaSach());
            stmt.setString(2, s.getTenSach());
            stmt.setString(3, s.getTacGia());
            stmt.setString(4, s.getTheLoai());
            stmt.setInt(5, s.getNamXB());
            stmt.setInt(6, s.getSoLuong());
            stmt.setDouble(7, s.getGiaBan());
            rows = stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
        finally { JavaConnectionB4.close(stmt); JavaConnectionB4.close(conn); }
        return rows;
    }

    public int update(Sach s) {
        Connection conn = null; PreparedStatement stmt = null; int rows = 0;
        try {
            conn = JavaConnectionB4.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, s.getTenSach());
            stmt.setString(2, s.getTacGia());
            stmt.setString(3, s.getTheLoai());
            stmt.setInt(4, s.getNamXB());
            stmt.setInt(5, s.getSoLuong());
            stmt.setDouble(6, s.getGiaBan());
            stmt.setString(7, s.getMaSach());
            rows = stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
        finally { JavaConnectionB4.close(stmt); JavaConnectionB4.close(conn); }
        return rows;
    }

    public int delete(String maSach) {
        Connection conn = null; PreparedStatement stmt = null; int rows = 0;
        try {
            conn = JavaConnectionB4.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, maSach);
            rows = stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
        finally { JavaConnectionB4.close(stmt); JavaConnectionB4.close(conn); }
        return rows;
    }

    public List<Sach> select()                  { return queryList(SQL_SELECT, null); }
    public List<Sach> selectHetSach()           { return queryList(SQL_HET, null); }
    public List<Sach> selectByTheLoai(String t) { return queryList(SQL_BY_THELOAI, t); }

    private List<Sach> queryList(String sql, String param) {
        List<Sach> list = new ArrayList<>();
        Connection conn = null; PreparedStatement stmt = null; ResultSet rs = null;
        try {
            conn = JavaConnectionB4.getConnection();
            stmt = conn.prepareStatement(sql);
            if (param != null) stmt.setString(1, param);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Sach s = new Sach();
                s.setMaSach(rs.getString("MASACH"));
                s.setTenSach(rs.getString("TENSACH"));
                s.setTacGia(rs.getString("TACGIA"));
                s.setTheLoai(rs.getString("THELOAI"));
                s.setNamXB(rs.getInt("NAMXB"));
                s.setSoLuong(rs.getInt("SOLUONG"));
                s.setGiaBan(rs.getDouble("GIABAN"));
                list.add(s);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        finally { JavaConnectionB4.close(rs); JavaConnectionB4.close(stmt); JavaConnectionB4.close(conn); }
        return list;
    }
}
