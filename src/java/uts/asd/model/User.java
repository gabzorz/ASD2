package uts.asd.model;

import java.io.Serializable;

public class User implements Serializable{
    
    private String userId;
    private String sysAdminId;
    private String fname;
    private String lname;
    private String address;
    private String dob;
    private String emailAddress;
    private String number;
    private String password;
    
    public User (){}
    
    public User(String userId, String sysAdminId, String fname, String lname, String address, String dob, String emailAddress, String number, String password) {
        this.userId = userId;
        this.sysAdminId = sysAdminId;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.dob = dob;
        this.emailAddress = emailAddress;
        this.number = number;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSysAdminId() {
        return sysAdminId;
    }

    public void setSysAdminId(String sysAdminId) {
        this.sysAdminId = sysAdminId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
   
    
    
    
    
    
    
    
    
}
