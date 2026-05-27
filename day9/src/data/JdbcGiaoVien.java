package data;

import domain.GiaoVien;
import java.sql.*;
import java.util.*;

public class JdbcGiaoVien {
    private final String SQL_INSERT =
        "INSERT INTO GIAOVIEN(MAGV,HOTEN,HOCVI,HOCHAM,GIOITINH,HESO,MUCLUONG,MAKHOA) VALUES(?,?,?,?,?,?,?,?)";
    private final String SQL_UPDATE =
        "UPDATE GIAOVIEN SET HOTEN=?,HOCVI=?,HOCHAM=?,GIOITINH=?,HESO=?,MUCLUONG=?,MAKHOA=? WHERE MAGV=?";
    private final String SQL_DELETE  = "DELETE FROM GIAOVIEN WHERE MAGV=?";
    private final String SQL_SELECT  = "SELECT * FROM GIAOVIEN ORDER BY MAGV";
    private final String SQL_NAM_CNTT =
        "SELECT * FROM GIAOVIEN WHERE GIOITINH='Nam' AND MAKHOA='CNTT'";

    public int insert(GiaoVien gv) {
        Connection conn = null; PreparedStatement stmt = null; int rows = 0;
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, gv.getMaGV());
            stmt.setString(2, gv.getHoTen());
            stmt.setString(3, gv.getHocVi());
            stmt.setString(4, gv.getHocHam());
            stmt.setString(5, gv.getGioiTinh());
            stmt.setDouble(6, gv.getHeSo());
            stmt.setDouble(7, gv.getMucLuong());
            stmt.setString(8, gv.getMaKhoa());
            rows = stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
        finally { JavaConnection.close(stmt); JavaConnection.close(conn); }
        return rows;
    }

    public int update(GiaoVien gv) {
        Connection conn = null; PreparedStatement stmt = null; int rows = 0;
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, gv.getHoTen());
            stmt.setString(2, gv.getHocVi());
            stmt.setString(3, gv.getHocHam());
            stmt.setString(4, gv.getGioiTinh());
            stmt.setDouble(5, gv.getHeSo());
            stmt.setDouble(6, gv.getMucLuong());
            stmt.setString(7, gv.getMaKhoa());
            stmt.setString(8, gv.getMaGV());
            rows = stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
        finally { JavaConnection.close(stmt); JavaConnection.close(conn); }
        return rows;
    }

    public int delete(String maGV) {
        Connection conn = null; PreparedStatement stmt = null; int rows = 0;
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, maGV);
            rows = stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
        finally { JavaConnection.close(stmt); JavaConnection.close(conn); }
        return rows;
    }

    public List<GiaoVien> select()         { return queryList(SQL_SELECT); }
    public List<GiaoVien> selectNamCNTT()  { return queryList(SQL_NAM_CNTT); }

    private List<GiaoVien> queryList(String sql) {
        List<GiaoVien> list = new ArrayList<>();
        Connection conn = null; PreparedStatement stmt = null; ResultSet rs = null;
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                GiaoVien gv = new GiaoVien();
                gv.setMaGV(rs.getString("MAGV"));
                gv.setHoTen(rs.getString("HOTEN"));
                gv.setHocVi(rs.getString("HOCVI"));
                gv.setHocHam(rs.getString("HOCHAM"));
                gv.setGioiTinh(rs.getString("GIOITINH"));
                gv.setHeSo(rs.getDouble("HESO"));
                gv.setMucLuong(rs.getDouble("MUCLUONG"));
                gv.setMaKhoa(rs.getString("MAKHOA"));
                list.add(gv);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        finally { JavaConnection.close(rs); JavaConnection.close(stmt); JavaConnection.close(conn); }
        return list;
    }
}
