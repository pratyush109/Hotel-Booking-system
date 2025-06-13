/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Pratyush
 */

   

import Model.PaymentMethod;

import View.PaymentInput;

import com.toedter.calendar.JDateChooser;
import dao.PaymentDao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class PaymentController {

    private PaymentInput view;
    private PaymentDao dao;

    public PaymentController(PaymentInput view) {
        this.view = view;
        this.dao = dao;

        // Add listeners to buttons and radio buttons
        this.view.addPayNowListener(new PayNowListener());
        this.view.addCancelListener(new CancelListener());
        this.view.addRadioCardListener(new CardRadioListener());
        this.view.addRadioCashListener(new CashRadioListener());
    }

    public void open() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Pay Now Button Listener
    class PayNowListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String cardNumber = view.getCardNumberField().getText().trim();
            String cvv = view.getCVVField().getText().trim();
            Date expiryDate = view.getExpiryDateChooser().getDate();

            String paymentMethod = view.getCardRadioButton().isSelected() ? "Card" : "Cash";

            // If Card is selected, validate fields
            if (paymentMethod.equals("Card")) {
                if (cardNumber.isEmpty() || cvv.isEmpty() || expiryDate == null) {
                    JOptionPane.showMessageDialog(view, "Please fill all card details.");
                    return;
                }
            } else {
                // Cash selected — ignore card fields
                cardNumber = "";
                cvv = "";
                expiryDate = null;
            }

            PaymentMethod data = new PaymentMethod(cardNumber, cvv, expiryDate, paymentMethod);

            if (dao.insertPayment(data)) {
                JOptionPane.showMessageDialog(view, "✅ Payment successful!");
            } else {
                JOptionPane.showMessageDialog(view, "❌ Payment failed. Try again.");
            }
        }
    }

    // Cancel Button Listener
    class CancelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Clear all fields
            view.getCardNumberField().setText("");
            view.getCVVField().setText("");
            view.getExpiryDateChooser().setDate(null);
            JOptionPane.showMessageDialog(view, "Payment canceled and fields cleared.");
        }
    }

    // Card Radio Button Listener
    class CardRadioListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Enable card input fields
            view.getCardNumberField().setEnabled(true);
            view.getCVVField().setEnabled(true);
            view.getExpiryDateChooser().setEnabled(true);
        }
    }

    // Cash Radio Button Listener
    class CashRadioListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Disable card input fields
            view.getCardNumberField().setEnabled(false);
            view.getCVVField().setEnabled(false);
            view.getExpiryDateChooser().setEnabled(false);
        }
    }
}

    

