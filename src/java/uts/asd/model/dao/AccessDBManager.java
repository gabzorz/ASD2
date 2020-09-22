package uts.asd.model.dao;

import uts.asd.model.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.lang.String;

public class AccessDBManager {
    
    private Statement st;
    
    public AccessDBManager (Connection conn) throws SQLException{
        st = conn.createStatement();
    }
    
    public void addCustomer(String fName, String lName, String address, 
            String dob, String emailAddress, String contactNumber, 
            String password, int roleId) throws SQLException{
        st.executeUpdate("INSERT INTO ASD.USER_ACCOUNT (FNAME, LNAME, ADDRESS, "
                + "DATEOFBIRTH, EMAILADDRESS, CONTACTNUMBER, PASSWORD, "
                + "ROLEID) "
                + "VALUES ('" + fName + "','"+ lName + "','" + address 
                + "','" + dob + "','" 
                + emailAddress + "','" + contactNumber
                + "','" + password + "'," + roleId + ")");
    }
    
    public User findCustomer (String email, String password) throws SQLException{
        String fetch = "select * from ASD.USER_ACCOUNT where EMAILADDRESS = '" + email + "'AND PASSWORD='"+password+"'";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()){
            String customerEmail = rs.getString(6);
            if(customerEmail.equals(email)){
                Integer customerID = rs.getInt(1);
                String fName = rs.getString(2);
                String lName = rs.getString(3);
                String address = rs.getString(4);
                String dob = rs.getString(5);
                String contactNumber = rs.getString(7);
                Integer roleId = rs.getInt(9);
                return new User(fName, lName, address, dob, customerEmail, contactNumber, password, roleId);
            }
        }
        
        return null;
    }
    public User findCustomerProfile (String email) throws SQLException{
        String fetch = "select * from ASD.USER_ACCOUNT where EMAILADDRESS = '" + email + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()){
            String customerEmail = rs.getString(6);
            if(customerEmail.equals(email)){
                String fName = rs.getString(2);
                String lName = rs.getString(3);
                String address = rs.getString(4);
                String dob = rs.getString(5);
                String contactNumber = rs.getString(7);
                String password = rs.getString(7);
                Integer roleId = rs.getInt(9);
                return new User(fName, lName, address, dob, customerEmail, contactNumber, password, roleId);
            }
        }
        
        return null;
    }
    
    public void updateCustomer (String fName, String lName, String address, 
            String contactNumber, String password, String email) throws SQLException{
        st.executeUpdate("UPDATE ASD.USER_ACCOUNT SET FNAME='" + fName + "', LNAME='" + lName + "', ADDRESS='" + address 
                + "', CONTACTNUMBER='"+ contactNumber + "', PASSWORD='"+ password + "' WHERE EMAILADDRESS='" + email + "'");
    }
    
    public boolean checkCustomer(String email) throws SQLException{
        String fetch = "select * from ASD.USER_ACCOUNT where EMAILADDRESS='" + email + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while(rs.next()){
            String customerEmail = rs.getString(6);
            if(customerEmail.equals(email)){
                return true;
            }
        }
        
        return false;
    }
    
    public void deleteCustomer (String email) throws SQLException{
        st.executeUpdate("DELETE FROM ASD.USER_ACCOUNT WHERE EMAILADDRESS='"+email+"'");
    }
    
    public int checkRole (String email) throws SQLException{
        String fetch = "select * from ASD.USER_ACCOUNT where EMAILADDRESS='" + email + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while(rs.next()){
            String customerEmail = rs.getString(6);
            int userRole = rs.getInt(9);
            if(customerEmail.equals(email)){
                return userRole;
            }
        }
        return 0;
    }
    
}
