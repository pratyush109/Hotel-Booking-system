/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author Lenovo
 */
import java.sql.*;

public class Mysqlconnection implements Database {

    @Override
    public Connection openConnection() {
        try {
            String username = "root";
            String password =" puyjvlg2r"; // Replace with your actual MySQL password
            String database = "HotelManagement";
// connection
            // Use correct driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Proper JDBC URL
            String url = "jdbc:mysql://127.0.0.1:3306/?user=root" + database;

            Connection connection = DriverManager.getConnection(url, username, password);

            if (connection == null) {
                System.out.println("Database connection failed");
            } else {
                System.out.println("Database connection successful");
            }

            return connection;

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Connection closed");
            }
        } catch (SQLException e) {
            System.out.println("Close error: " + e.getMessage());
        }
    }

    @Override
    public ResultSet runQuery(Connection conn, String query) {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Query error: " + e.getMessage());
            return null;
        }
    }

    @Override
    public int executeUpdate(Connection conn, String query) {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Update error: " + e.getMessage());
            return -1;
        }
    }
}