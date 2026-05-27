package data;

import domain.SinhVien;
import java.sql.*;
import java.util.*;

public class JdbcSinhVien {
    private final String SQL_INSERT =
        "INSERT INTO SINHVIEN(MASV,HOTEN,NGAYSINH,DIEMTB,MALOP) VALUES(?,?,?,?,?)";
    private final String SQL_UPDATE =
        "UPDATE SINHVIEN SET HOTEN=?,NGAYSINH=?,DIEMTB=?,MALOP=? WHERE MASV=?";
    private final String SQL_DELETE  = "DELETE FROM SINHVIEN WHERE MASV=?";
    private final String SQL_SELECT  = "SELECT * FROM SINHVIEN ORDER BY MASV";
    private final String SQL_GIOI    = "SELECT * FROM SINHVIEN WHERE DIEMTB >= 8.0 ORDER BY DIEMTB DESC";
    private final String SQL_BY_LOP  = "SELECT * FROM SINHVIEN WHERE MALOP=? ORDER BY HOTEN";

    public int insert(SinhVien sv) {
        Connection conn = null; PreparedStatement stmt = null; int rows = 0;
        try {
            conn = JavaConnectionB3.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, sv.getMaSV());
            stmt.setString(2, sv.getHoTen());
            stmt.setString(3, sv.getNgaySinh());
            stmt.setDouble(4, sv.getDiemTB());
            stmt.setString(5, sv.getMaLop());
            rows = stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
        finally { JavaConnectionB3.close(stmt); JavaConnectionB3.close(conn); }
        return rows;
    }

    public int update(SinhVien sv) {
        Connection conn = null; PreparedStatement stmt = null; int rows = 0;
        try {
            conn = JavaConnectionB3.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, sv.getHoTen());
            stmt.setString(2, sv.getNgaySinh());
            stmt.setDouble(3, sv.getDiemTB());
            stmt.setString(4, sv.getMaLop());
            stmt.setString(5, sv.getMaSV());
            rows = stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
        finally { JavaConnectionB3.close(stmt); JavaConnectionB3.close(conn); }
        return rows;
    }

    public int delete(String maSV) {
        Connection conn = null; PreparedStatement stmt = null; int rows = 0;
        try {
            conn = JavaConnectionB3.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, maSV);
            rows = stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
        finally { JavaConnectionB3.close(stmt); JavaConnectionB3.close(conn); }
        return rows;
    }

    public List<SinhVien> select()        { return queryList(SQL_SELECT, null); }
    public List<SinhVien> selectGioi()    { return queryList(SQL_GIOI, null); }
    public List<SinhVien> selectByLop(String maLop) { return queryList(SQL_BY_LOP, maLop); }

    private List<SinhVien> queryList(String sql, String param) {
        List<SinhVien> list = new ArrayList<>();
        Connection conn = null; PreparedStatement stmt = null; ResultSet rs = null;
        try {
            conn = JavaConnectionB3.getConnection();
            stmt = conn.prepareStatement(sql);
            if (param != null) stmt.setString(1, param);
            rs = stmt.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien();
                sv.setMaSV(rs.getString("MASV"));
                sv.setHoTen(rs.getString("HOTEN"));
                sv.setNgaySinh(rs.getString("NGAYSINH"));
                sv.setDiemTB(rs.getDouble("DIEMTB"));
                sv.setMaLop(rs.getString("MALOP"));
                list.add(sv);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        finally { JavaConnectionB3.close(rs); JavaConnectionB3.close(stmt); JavaConnectionB3.close(conn); }
        return list;
    }
}
