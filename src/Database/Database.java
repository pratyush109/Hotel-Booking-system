/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;
import java.sql.*;

/**
 *
 * @author Dell
 */
public interface Database {
    Connection openConnection();
    Connection closeConnection(Connection connection);
    ResultSet executeQuery(Connection connection, String query);
    int executeUpdate(Connection connection, String query);
    /
}
