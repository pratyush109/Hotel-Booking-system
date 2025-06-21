/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;
    import java.sql.*;

/**
 *
 * @author renisa
 */
 
public class mysqlconnection implements database {
    @Override
    public Connection openConnection() {
        try {
            String username = "root";
            String password = "password";
            String database = "HotelManagmentSystem";
Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection;
            connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/" + database, username, password
            );
            if (connection == null) {
                System.out.println("Database connection fail");
            } else {
                System.out.println("Database connection success");
            }
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return null;
        }
    }
 
    @Override
    public void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Connection close");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
 
    @Override
    public ResultSet runQuery(Connection conn, String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            return result;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
 
    @Override
    public int executeUpdate(Connection conn, String query) {
        try {
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate(query);
            return result;
        } catch (SQLException e) {
            System.out.println(e);
            return -1;
        }
    }

}
