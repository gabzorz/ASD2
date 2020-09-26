/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.controller;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import uts.asd.model.dao.DBConnector;
import uts.asd.model.dao.AccessDBManager;
import uts.asd.model.dao.PaymentDAO;
import uts.asd.model.Payment;

/**
 **
 * @author CristinaFidelino
 */
public class TestPaymentDB {
    private static Scanner in = new Scanner(System.in);
    private DBConnector connector;
    private Connection conn;
    private AccessDBManager db;
    private PaymentDAO pyd;

    public static void main(String[] args) throws SQLException {
        (new TestPaymentDB()).runQueries();
    }
    
    public TestPaymentDB(){
    try {
        connector = new DBConnector();
        conn = connector.openConnection();
        db = new AccessDBManager(conn);
        pyd = new PaymentDAO(conn);
    }
    catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(userTest.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    private char readChoice(){
        System.out.print("Operation CRUDS or * to exit: ");
        return in.nextLine().charAt(0);
    }

private void runQueries() throws SQLException {
    char c;
    
    while ((c = readChoice()) != '*'){
        switch(c){
            case 'C':
                testAdd();
                break;
            case 'R':
                testRead();
                break;
            case 'U':
                testUpdate();
                break;
            case 'D':
                testDelete();
                break;
            case 'S':
                testShow();
                break;
            default:
                System.out.println("Unknown Command");
        }
    }
}

private void testAdd(){
        System.out.print("First Name: ");
        String firstName = in.nextLine();
        
        System.out.print("Last Name: ");
        String lastName = in.nextLine();
        
        System.out.print("Account Number: ");
        int accountNumber = in.nextInt();
        in.nextLine();
        
        System.out.print("BSB: ");
        int bsb = in.nextInt();
        in.nextLine();
    
        try {
            pyd.addPayment(firstName, lastName, accountNumber,bsb);
        } catch (SQLException ex) {
            Logger.getLogger(userTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Payment is added to the database.");
} 

    private void testRead() throws SQLException {
        System.out.print("Payment ID: ");
        int paymentID = in.nextInt();
        in.nextLine();
        
        ArrayList<Payment> payment = pyd.searchPayment(paymentID);
        
        if (payment != null){
            for(Payment p: payment){
                System.out.println("Paymanet ID exists in database");
                System.out.println(p.getPaymentID());
            }
        }
        else {
            System.out.println("Payment does not exist");
        }  
    }
    
    private void testUpdate() throws SQLException {
        System.out.print("Payment ID: ");
        int paymentID = in.nextInt();
        in.nextLine();
        
        try{
            if(pyd.checkPayment(paymentID)) {
                System.out.print("First Name: ");
                String firstName = in.nextLine();
                
                System.out.print("Last Name: ");
                String lastName = in.nextLine();
                
                System.out.print("Account Number: ");
                int accountNumber = in.nextInt();
                in.nextLine();
                
                System.out.print("BSB: ");
                int bsb = in.nextInt();
                in.nextLine();
                
                pyd.updatePayment(paymentID, firstName, lastName, accountNumber, bsb);
            } else {
                System.out.println("Payment ID does not exist");
            }
        } catch (SQLException ex) {
            Logger.getLogger(userTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void testDelete() throws SQLException {
        System.out.print("Payment ID: ");
        int paymentID = in.nextInt();
        
        try{
            if(pyd.checkPayment(paymentID)) {
                pyd.deletePayment(paymentID);
            } else {
                System.out.println("Payment does not exist");
            }
        } catch (SQLException ex) {
            Logger.getLogger(userTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void testShow() throws SQLException {
        try{
            ArrayList<Payment> payments = pyd.fetchPayments();
            System.out.println("PAYMENT TABLE: ");
            payments.stream().forEach((payment) -> {
                System.out.printf("%-20s %-30s %-20s %10s \n", payment.getPaymentID(), payment.getFirstName(), payment.getLastName(), payment.getAccountNumber(), payment.getBsb());
            });
            System.out.println();
        } catch (SQLException ex) {
            Logger.getLogger(userTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
