/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;



/**
 *
 * @author DELL
 */

import Database.MySqlConnection;
import Model.loginrequest;
import java.sql.*;

public class LoginDao {
    private final MySqlConnection dbConnection;

    public LoginDao() {
        this.dbConnection = new MySqlConnection();
    }

    /**
     * Authenticates user credentials against the database
     * @param request Contains username and password
     * @return true if authentication succeeds, false otherwise
     */
    public boolean authenticateUser(loginrequest request) {
        // Input validation
        if (request == null || isEmpty(request.getUsername()) || isEmpty(request.getPassword())) {
            System.err.println("Empty credentials provided");
            return false;
        }

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 1. Establish connection
            conn = dbConnection.openConnection();
            if (conn == null) {
                System.err.println("Failed to establish database connection");
                return false;
            }
            
            // Verify database is selected
            String dbName = conn.getCatalog();
            if (dbName == null || dbName.isEmpty()) {
                System.err.println("No database selected - check connection URL");
                return false;
            }
            System.out.println("Connected to database: " + dbName);

            // 2. Prepare and execute query
            String query = "SELECT username FROM users WHERE username = ? AND password = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, request.getUsername());
            pstmt.setString(2, request.getPassword());

            // 3. Process results
            rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("Login successful for user: " + request.getUsername());
                return true;
            } else {
                System.out.println("Invalid credentials for user: " + request.getUsername());
                return false;
            }

        } catch (SQLException e) {
            System.err.println("Database error during authentication: " + e.getMessage());
            return false;
        } finally {
            // 4. Clean up resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) dbConnection.closeConnection(conn);
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
    }

    // Helper method to check for empty strings
    private boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    /**
     * Test method - run this to verify your setup
     */
    public static void testAuthentication() {
        LoginDao dao = new LoginDao();
        
        // Test with admin credentials
        loginrequest adminRequest = new loginrequest("admin", "admin123");
        boolean adminResult = dao.authenticateUser(adminRequest);
        System.out.println("Admin login test: " + (adminResult ? "SUCCESS" : "FAILED"));
        
        // Test with invalid credentials
        loginrequest invalidRequest = new loginrequest("wrong", "credentials");
        boolean invalidResult = dao.authenticateUser(invalidRequest);
        System.out.println("Invalid login test: " + (!invalidResult ? "PASSED" : "FAILED"));
    }
}