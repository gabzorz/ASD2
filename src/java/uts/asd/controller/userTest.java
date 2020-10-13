package uts.asd.controller;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import uts.asd.model.*;
import uts.asd.model.dao.DBConnector;
import uts.asd.model.dao.*;

public class userTest {

    private static Scanner in = new Scanner(System.in);
    private DBConnector connector;
    private Connection conn;
    private AccessDBManager db;
    private CalculatorDBManager db1;

    public static void main(String[] args) throws SQLException {
        (new userTest()).runQueries();

    }

    public userTest() {
        try {
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new AccessDBManager(conn);
            db1 = new CalculatorDBManager(conn);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(userTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private char readChoice() {
        System.out.print("Operation CRUDS or * to exit: ");
        return in.nextLine().charAt(0);
    }

    private void runQueries() throws SQLException {
        char c;

        while ((c = readChoice()) != '*') {
            switch (c) {
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
                case 'P':
                    testCat();
                    break;
                default:
                    System.out.println("Unknown Command");

            }

        }
    }
    
    private void testCat(){
        System.out.println("Enter category number");
        int cat = in.nextInt();
        
        try {
//            Calculator value = db1.findValues(cat);
//            System.out.println(value.getVariablePrice());
//            System.out.println(value.getVariableIncrease());
//            System.out.println(value.getDuitableValue());
                int price = db1.findPrice(cat);
                float increase = db1.findIncrease(cat);
                int duitable = db1.findValue(cat);
                System.out.println(price);
                System.out.println(increase);
                System.out.println(duitable);
        } catch (SQLException ex) {
            Logger.getLogger(userTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Customer is added to the database.");
        
    }

    private void testAdd() {

        System.out.print("Enter first name: ");
        String fname = in.nextLine();
        System.out.print("Enter last name: ");
        String lname = in.nextLine();
        System.out.print("Enter address: ");
        String address = in.nextLine();
        System.out.print("Enter dob: ");
        String dob = in.nextLine();
        System.out.print("Enter email: ");
        String email = in.nextLine();
        System.out.print("Enter number: ");
        String number = in.nextLine();
        System.out.print("Enter password");
        String password = in.nextLine();

        try {
            db.createCustomer(fname, lname, address, dob, email, number, password, 3);
        } catch (SQLException ex) {
            Logger.getLogger(userTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Customer is added to the database.");
    }

    private void testRead() throws SQLException {
        System.out.print("Enter email: ");
        String email = in.nextLine();
        System.out.print("Enter password: ");
        String password = in.nextLine();

        User customer = db.findCustomer(email, password);

        if (customer != null) {
            System.out.println("Customer " + customer.getfName() + customer.getlName() + " exists in the database.");
        } else {
            System.out.println("Customer does not exist in the database");
        }
    }

    private void testUpdate() {
        System.out.print("Enter email: ");
        String email = in.nextLine();

        try {
            if (db.checkEmail(email)) {
                System.out.print("Enter first name: ");
                String fname = in.nextLine();
                System.out.print("Enter last name: ");
                String lname = in.nextLine();
                System.out.print("Enter address: ");
                String address = in.nextLine();
                System.out.print("Enter number: ");
                String number = in.nextLine();
                System.out.print("Enter password: ");
                String password = in.nextLine();

                db.updateCustomer(fname, lname, address, number, password, email);

            } else {
                System.out.println("Customer does not exist");
            }

        } catch (SQLException ex) {
            Logger.getLogger(userTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void testDelete() {
        System.out.print("Enter email: ");
        String email = in.nextLine();

        try {
            if (db.checkEmail(email)) {
                db.deleteUser(email);
            } else {
                System.out.println("Customer does not exist");
            }
        } catch (SQLException ex) {
            Logger.getLogger(userTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void testRole(){
        System.out.print("Enter email: ");
        String email = in.nextLine();
        
        try{
            if(db.checkEmail(email)){
                int role = db.checkRole(email);
                System.out.print("Role number is: " + role);
            } else {
                System.out.println("Customer does not exist");
            }
        } catch (SQLException ex) {
            Logger.getLogger(userTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
