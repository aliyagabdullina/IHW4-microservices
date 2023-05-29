package databases;

import java.sql.*;

public class dish {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/dish";
    private static final String USER = "dish_login";
    private static final String PASSWORD = "dish_password";
    private static Connection conn;

    public static void createDishTable() throws SQLException {
        conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        String sql = "CREATE TABLE dish (" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(100) NOT NULL," +
                "description TEXT," +
                "price DECIMAL(10, 2) NOT NULL," +
                "quantity INT NOT NULL," +
                "is_available BOOLEAN NOT NULL," +
                "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                "updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.execute();
        }
    }

    public static void insertDish(int id, String name, String description, int price, int quantity, boolean isAvailable, Date created_at, Date updated_at) throws SQLException {
        String sql = "INSERT INTO dish (id, name, description, price, quantity, is_available, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, description);
            stmt.setInt(4, price);
            stmt.setInt(5, quantity);
            stmt.setBoolean(6, isAvailable);
            stmt.setDate(7, created_at);
            stmt.setDate(8, updated_at);
            stmt.executeUpdate();
        }
    }
}
