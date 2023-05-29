package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class order {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/order";
    private static final String USER = "order_login";
    private static final String PASSWORD = "order_password";
    private static Connection conn;

    public static void createOrderTable() throws SQLException {
        conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        String sql = "CREATE TABLE IF NOT EXISTS \"order\" (" +
                "id SERIAL PRIMARY KEY," +
                "user_id INT NOT NULL," +
                "status VARCHAR(50) NOT NULL," +
                "special_requests TEXT," +
                "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                "updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP," +
                ")";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.execute();
        }
    }

    public static void insertOrder(int id, int userId, String status, String specialRequests) throws SQLException {
        String sql = "INSERT INTO \"order\" (id, user_id, status, special_requests) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setInt(2, userId);
            stmt.setString(3, status);
            stmt.setString(4, specialRequests);
            stmt.executeUpdate();
        }
    }
}
