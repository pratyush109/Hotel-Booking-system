/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Dell
 */
public class MySqlConnection implements Database {

    @Override
    public Connection openConnection() {
        try {
       
     
        String username = "root";
        String password = "satyam123";
        String database = "auraadmin";
        String url = "jdbc:mysql://127.0.0.1:3306/"+database;
        
        Connection connection = DriverManager.getConnection(url,username,password);
        if(connection == null) {
            System.out.println("Database connection failed");
        } else {
            System.out.println("Database connection successful");    
        }
        return connection;
        } 
        
        catch (SQLException e) {
            System.out.println(e);
            return null;
        }
       
    }

    @Override
    public Connection closeConnection(Connection connection) {
        try { 
            if(connection != null && !connection.isClosed()) {
                connection.close();
            }
         } catch(SQLException e) {
             System.out.println(e);
         }
        return null;
    
    }

    @Override
    public ResultSet executeQuery(Connection connection, String query) {
        try {
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(query);
        
        return result;
        } catch(SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public int executeUpdate(Connection connection, String query) {
        try {
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(query);
            return result;
            
        } catch(SQLException e) {
            System.out.println(e);
            return -1;
        }
    }
    
}
