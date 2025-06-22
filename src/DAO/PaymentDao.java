package dao;

import Database.MySqlConnection;
import Model.PaymentMethod;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PaymentDao {

    private static final Logger logger = Logger.getLogger(PaymentDao.class.getName());
    private final MySqlConnection mysql = new MySqlConnection();

    // Insert payment into database
    public boolean insertPayment(PaymentMethod paymentData) {
        Connection conn = mysql.openConnection();
        if (conn == null) {
            logger.log(Level.SEVERE, "Failed to open database connection.");
            return false;
        }

        String sql = "INSERT INTO payments (card_number, cvv, expiry_date, payment_method) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, paymentData.getCardNumber());
            pstmt.setString(2, paymentData.getCvv());

            // Convert java.util.Date to java.sql.Date
            if (paymentData.getExpiryDate() != null) {
                pstmt.setDate(3, new Date(paymentData.getExpiryDate().getTime()));
            } else {
                pstmt.setDate(3, null);
            }

            pstmt.setString(4, paymentData.getPaymentMethod());

            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error inserting payment data", ex);
            return false;
        } finally {
            mysql.closeConnection(conn);
        }
    }
}
