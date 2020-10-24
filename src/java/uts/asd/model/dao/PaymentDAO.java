/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.model.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import uts.asd.model.Payment;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author CristinaFidelino
 */
public class PaymentDAO {
    private Statement st;
    private Connection conn;
    
    public PaymentDAO(Connection conn) throws SQLException{
        st = conn.createStatement();
        this.conn = conn;
    }
    
    
    
    public void editPayments(int accNumber, int BSB, int paymentID) throws SQLException {
        st.executeUpdate("UPDATE ASDREAMS.Payment SET ACCOUNTNUMBER=" + accNumber + ", BSB = " + BSB + " WHERE PAYMENTID= " + paymentID + "");
    }
   
        //function to search for payments under one account
    public Payment searchPayments(int searchID) throws SQLException {
        String search = "Select * from ASDREAMS.Payment where USERID=" + searchID + "";
        ResultSet rs = st.executeQuery(search);
        
        while (rs.next()){
            int paymentID = rs.getInt(1);
            int userId = rs.getInt(2);
            String firstName = rs.getString(3);
            String lastName = rs.getString(4);
            int accountNumber = rs.getInt(5);
            int bsb = rs.getInt(6);        
            return new Payment(paymentID, userId, firstName, lastName, accountNumber,bsb);
        }
        return null;
    }
    
    //function to search for payments
    public ArrayList<Payment> searchPaymentsArray(int searchID) throws SQLException {
        ArrayList<Payment> searchPayments = new ArrayList();
        String search = "Select * from ASDREAMS.Payment where PAYMENTID=" + searchID + "";
        ResultSet rs = st.executeQuery(search);
        
        while (rs.next()){
            int paymentID = rs.getInt(1);
            int userId = rs.getInt(2);
            String firstName = rs.getString(3);
            String lastName = rs.getString(4);
            int accountNumber = rs.getInt(5);
            int bsb = rs.getInt(6);
            searchPayments.add(new Payment(paymentID, userId, firstName, lastName, accountNumber, bsb));
        }
        if(searchPayments.size() > 0){
            return searchPayments;
        }
        else{
            return null;
        }
    }
    
    //function to add payment information to database
    public void addPayment(int userId, String firstName, String lastName, int accountNumber, int bsb) throws SQLException{
        String update = "INSERT INTO ASDREAMS.Payment(userId, firstName, lastName, accountNumber, bsb) VALUES(?, ?, ?, ?, ? )";
        PreparedStatement st = conn.prepareStatement(update);
        st.setInt(1, userId);
        st.setString(2, firstName);
        st.setString(3, lastName);
        st.setInt(4, accountNumber);
        st.setInt(5, bsb);
        st.execute();
    }
    
    //function to update payment information
    public void updatePayment(int paymentID, String firstName, String lastName, int accountNumber, int bsb) throws SQLException{
        st.executeUpdate("UPDATE ASDREAMS.Payment SET FIRSTNAME ='" + firstName + "', LASTNAME='" + lastName + "', ACCOUNTNUMBER=" + accountNumber + ", BSB = " + bsb + " WHERE PAYMENTID= " + paymentID + "");
    }

    //function to delete payment information from database
    public void deletePayment(int paymentID) throws SQLException {
        st.executeUpdate("DELETE FROM ASDREAMS.Payment WHERE PAYMENTID= " + paymentID + "");
    }
    
    //function to return payments within the database
    public ArrayList<Payment> fetchPayments() throws SQLException {
        ArrayList<Payment> payments = new ArrayList();
        String fetch = "Select * from ASDREAMS.Payment";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()){
            int paymentID = rs.getInt(1);
            int userId = rs.getInt(2);
            String firstName = rs.getString(3);
            String lastName = rs.getString(4);
            int accountNumber = rs.getInt(5);
            int bsb = rs.getInt(6);
            payments.add(new Payment(paymentID, userId, firstName, lastName, accountNumber, bsb));
        }
        return payments;
    }
    
    //function to check paymentID in the database
    public boolean checkPayment(int paymentID) throws SQLException{
       String fetch = "select * from ASDREAMS.Payment where PAYMENTID = " + paymentID + " ";
       ResultSet rs = st.executeQuery(fetch);
       
       while(rs.next()) {
           int userPayment = rs.getInt(1);
           if (userPayment == paymentID) {
               return true;
           }
       }
       return false;
   }
}
