package data;

import domain.Khoa;
import java.sql.*;
import java.util.*;

public class JdbcKhoa {
    private final String SQL_INSERT = "INSERT INTO KHOA(MAKHOA,TENKHOA,NGTLAP,TRGKHOA) VALUES(?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE KHOA SET TENKHOA=?,NGTLAP=?,TRGKHOA=? WHERE MAKHOA=?";
    private final String SQL_DELETE = "DELETE FROM KHOA WHERE MAKHOA=?";
    private final String SQL_SELECT = "SELECT * FROM KHOA ORDER BY MAKHOA";

    public int insert(Khoa k) {
        Connection conn = null; PreparedStatement stmt = null; int rows = 0;
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, k.getMaKhoa());
            stmt.setString(2, k.getTenKhoa());
            stmt.setString(3, k.getNgtLap());
            stmt.setString(4, k.getTrgKhoa());
            rows = stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
        finally { JavaConnection.close(stmt); JavaConnection.close(conn); }
        return rows;
    }

    public int update(Khoa k) {
        Connection conn = null; PreparedStatement stmt = null; int rows = 0;
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, k.getTenKhoa());
            stmt.setString(2, k.getNgtLap());
            stmt.setString(3, k.getTrgKhoa());
            stmt.setString(4, k.getMaKhoa());
            rows = stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
        finally { JavaConnection.close(stmt); JavaConnection.close(conn); }
        return rows;
    }

    public int delete(String maKhoa) {
        Connection conn = null; PreparedStatement stmt = null; int rows = 0;
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, maKhoa);
            rows = stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
        finally { JavaConnection.close(stmt); JavaConnection.close(conn); }
        return rows;
    }

    public List<Khoa> select() {
        List<Khoa> list = new ArrayList<>();
        Connection conn = null; PreparedStatement stmt = null; ResultSet rs = null;
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs   = stmt.executeQuery();
            while (rs.next())
                list.add(new Khoa(rs.getString(1), rs.getString(2),
                                  rs.getString(3), rs.getString(4)));
        } catch (SQLException e) { e.printStackTrace(); }
        finally { JavaConnection.close(rs); JavaConnection.close(stmt); JavaConnection.close(conn); }
        return list;
    }
}
