package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class session {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/session";
    private static final String USER = "session_login";
    private static final String PASSWORD = "session_password";
    private static Connection conn;

    public static void createSessionTable() throws SQLException {
        conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        String sql = "CREATE TABLE IF NOT EXISTS user (" +
                "id SERIAL PRIMARY KEY," +
                "user_id INT NOT NULL," +
                "session_token VARCHAR(255) NOT NULL," +
                "expires_at TIMESTAMP NOT NULL," +
                ")";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.execute();
        }
    }

    public static void insertSession(int id, int user_id, String session_token, String expires_at) throws SQLException {
        String sql = "INSERT INTO user (id, user_id, session_token, expires_at, created_at, updated_at) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setInt(2, user_id);
            stmt.setString(3, session_token);
            stmt.setString(4, expires_at);
            stmt.executeUpdate();
        }
    }
}

