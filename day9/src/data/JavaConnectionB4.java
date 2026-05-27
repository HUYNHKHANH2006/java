package data;

import java.sql.*;

public class JavaConnectionB4 {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL    = "jdbc:mysql://localhost:3306/qlthuvien?useSSL=false&serverTimezone=UTC";
    private static final String USER   = "root";
    private static final String PASS   = "Admin@123";

    public static Connection getConnection() throws SQLException {
        try { Class.forName(DRIVER); }
        catch (ClassNotFoundException e) { e.printStackTrace(); }
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static void close(AutoCloseable ac) {
        try { if (ac != null) ac.close(); } catch (Exception e) { e.printStackTrace(); }
    }
}
