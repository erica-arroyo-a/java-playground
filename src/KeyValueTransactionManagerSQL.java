import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class DatabaseUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/key_value_db";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}


class KeyValueTransactionManagerSQL {

    private Connection connection;
    private boolean autoCommit;

    public KeyValueTransactionManagerSQL(boolean autoCommit) throws SQLException {
        this.connection = DatabaseUtil.getConnection();
        this.connection.setAutoCommit(autoCommit);
        this.autoCommit = autoCommit;
    }

    // Insert key-value pair
    public void insert(String key, String value) throws SQLException {
        String sql = "INSERT INTO key_value_store (`key`, `value`) VALUES (?, ?) ON DUPLICATE KEY UPDATE value = VALUES(value)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, key);
            stmt.setString(2, value);
            stmt.executeUpdate();
        }
    }

    // Retrieve value by key
    public String get(String key) throws SQLException {
        String sql = "SELECT value FROM key_value_store WHERE `key` = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, key);
            ResultSet rs = stmt.executeQuery();
            return rs.next() ? rs.getString("value") : null;
        }
    }

    // Delete a key
    public void delete(String key) throws SQLException {
        String sql = "DELETE FROM key_value_store WHERE `key` = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, key);
            stmt.executeUpdate();
        }
    }

    // Commit transaction
    public void commit() throws SQLException {
        if (!autoCommit) {
            connection.commit();
        }
    }

    // Rollback transaction
    public void rollback() throws SQLException {
        if (!autoCommit) {
            connection.rollback();
        }
    }

    // Close connection
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}

class TestMain {
    public static void main(String[] args) {
        try {
            // Transactional Mode
            System.out.println("Starting Transaction...");
            KeyValueTransactionManagerSQL txManager = new KeyValueTransactionManagerSQL(false);
            try {
                txManager.insert("username", "john_doe");
                txManager.insert("email", "john@example.com");

                // Simulating an error (uncomment to test rollback)
                // int error = 1 / 0;

                txManager.commit();
                System.out.println("Transaction Committed!");
            } catch (Exception e) {
                txManager.rollback();
                System.out.println("Transaction Rolled Back!");
            } finally {
                txManager.close();
            }

            // Non-Transactional Mode
            System.out.println("\nPerforming Non-Transactional Update...");
            KeyValueTransactionManagerSQL nonTxManager = new KeyValueTransactionManagerSQL(true);
            nonTxManager.insert("phone", "1234567890"); // Auto-committed
            nonTxManager.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

