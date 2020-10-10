package uts.asd.model;

import java.io.Serializable;

public class User implements Serializable {

    private int userId;
    private String fName;
    private String lName;
    private String address;
    private String dob;
    private String emailAddress;
    private String contactNumber;
    private String password;
    private int roleId;

    public User(int userId, String fName, String lName, String address, String dob, String emailAddress, String contactNumber, String password, int roleId) {

        this.userId = userId;
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.dob = dob;
        this.emailAddress = emailAddress;
        this.contactNumber = contactNumber;
        this.password = password;
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

}
