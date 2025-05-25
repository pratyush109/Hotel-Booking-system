/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author DELL
 */
import java.sql.*;

public class MySqlConnection implements Database {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hotelmanagementlogin";
    private static final String USER = "root";
    private static final String PASSWORD = "sulav@2727";

    @Override
    public Connection openConnection() {
        try {
            // 1. Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 2. Establish connection with explicit database
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            
            // 3. Verify connection
            if (connection != null && !connection.isClosed()) {
                System.out.println("Successfully connected to database: " 
                    + connection.getCatalog());
                return connection;
            }
            
            System.err.println("Connection failed - no error thrown but connection is null");
            return null;
            
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.err.println("Database connection failed:");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Message: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Connection closed successfully");
            }
        } catch (SQLException e) {
            System.err.println("Failed to close connection: " + e.getMessage());
        }
    }

    @Override
    public ResultSet runQuery(Connection conn, String query) {
        if (conn == null) {
            System.err.println("Cannot run query - connection is null");
            return null;
        }
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Query execution failed:");
            System.err.println("Query: " + query);
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    @Override
    public int executeUpdate(Connection conn, String query) {
        if (conn == null) {
            System.err.println("Cannot execute update - connection is null");
            return -1;
        }
        
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            return stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Update execution failed:");
            System.err.println("Query: " + query);
            System.err.println("Error: " + e.getMessage());
            return -1;
        }
    }
    
    // Test method
    public static void main(String[] args) {
        MySqlConnection db = new MySqlConnection();
        try (Connection conn = db.openConnection()) {
            if (conn != null) {
                System.out.println("Database metadata: " + conn.getMetaData().getDatabaseProductName());
                
                // Test query
                ResultSet rs = db.runQuery(conn, "SELECT * FROM users");
                if (rs != null) {
                    System.out.println("Users table exists with columns:");
                    ResultSetMetaData meta = rs.getMetaData();
                    for (int i = 1; i <= meta.getColumnCount(); i++) {
                        System.out.println("- " + meta.getColumnName(i));
                    }
                }
            }
        } catch (SQLException e) {
        }
    }
}