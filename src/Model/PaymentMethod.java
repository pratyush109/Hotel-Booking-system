/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Pratyush
 */
import java.util.Date;



public class PaymentMethod{
    private String cardNumber;
    private String cvv;
    private Date expiryDate;
    private String paymentMethod;
    
    public PaymentMethod(String cardNumber,String  cvv,Date expiryDate,String paymentMethod){
        this.cardNumber = cardNumber;
        this.cvv=cvv;
        this.expiryDate = expiryDate;
        this.paymentMethod = paymentMethod;
    }
public String  getCardNumber(){
 return cardNumber;


}

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber ;
    }
    
    public String getCvv(){
     return cvv;   
    }
    public void setCvv(String cvv){
        this.cvv = cvv;
    }
    public Date getExpiryDate(){
        
    return expiryDate;   
    }
    public void setExpiryDate(Date expiryDate){
        this.expiryDate= expiryDate;
        
    }
    public String getPaymentMethod(){
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod){
        this.paymentMethod=paymentMethod;
        
    }
    



}