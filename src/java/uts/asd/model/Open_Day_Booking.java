/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.model;

/**
 *
 * @author Hamish Lamond
 */
public class Open_Day_Booking {
    
    private int bookingID;
    private int staffID;
    private int userID;
    private int propertyID;
    private String date;
    private String time;

    public Open_Day_Booking(int bookingID, int staffID, int userID, int propertyID, String date, String time) {
        this.bookingID = bookingID;
        this.staffID = staffID;
        this.userID = userID;
        this.propertyID = propertyID;
        this.date = date;
        this.time = time;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    
    
}
