package databases;

import java.sql.*;
import java.time.LocalDateTime;

public class user {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/user";
    private static final String USER = "user_login";
    private static final String PASSWORD = "user_password";
    private static Connection conn;

    public static void createUserTable() throws SQLException {
        conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        String sql = "CREATE TABLE IF NOT EXISTS user (" +
                "id SERIAL PRIMARY KEY," +
                "username VARCHAR(255) UNIQUE NOT NULL," +
                "password VARCHAR(255) NOT NULL," +
                "role VARCHAR(50) NOT NULL CHECK (role IN ('customer', 'chef', 'manager'))," +
                "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP()" +
                "updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP()" +
                ")";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.execute();
        }
    }

    public static void insertUser(int id, String username, String password, String role, Date created_at, Date updated_at) throws SQLException {
        String sql = "INSERT INTO user (id, username, password, role, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, username);
            stmt.setString(3, password);
            stmt.setString(4, role);
            stmt.setDate(5, created_at);
            stmt.setDate(6, updated_at);
            stmt.executeUpdate();
        }
    }
}
