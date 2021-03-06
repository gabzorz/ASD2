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
    private String startTime;
    private String endTime;
    private String status;

    public Open_Day_Booking(int bookingID, int staffID, int propertyID, String date, String startTime, String endTime, String status) {
        this.bookingID = bookingID;
        this.staffID = staffID;
        this.propertyID = propertyID;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    public Open_Day_Booking(int bookingID, int staffID, int userID, int propertyID, String date, String startTime, String endTime, String status) {
        this.bookingID = bookingID;
        this.staffID = staffID;
        this.userID = userID;
        this.propertyID = propertyID;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
