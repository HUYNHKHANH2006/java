package data;

import java.sql.*;

public class JavaConnection {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL    = "jdbc:mysql://localhost:3306/qlgiaovien?useSSL=false&serverTimezone=UTC";
    private static final String USER   = "root";   // đổi theo máy bạn
    private static final String PASS   = "Admin@123";

    public static Connection getConnection() throws SQLException {
        try { Class.forName(DRIVER); }
        catch (ClassNotFoundException e) { e.printStackTrace(); }
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static void close(ResultSet rs) {
        try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
    }

    public static void close(PreparedStatement stmt) {
        try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
    }

    public static void close(Connection conn) {
        try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
    }
}
