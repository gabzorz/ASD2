/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.model;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Hamish Lamond
 */
public class Auction_Item {

    private int itemID;
    private int propertyID;
    private int staffUserID;
    private int sellerID;
    private int soldTo;
    private int keywordID;
    private int purchaseID;
    private int soldFor;
    private String dateVerified;
    private String startDate;
    private String startTime;
    private String endDate;
    private String endTime;
    private int reservePrice;
    private int startingPrice;
    private String status;

    public Auction_Item(int itemID, int propertyID, int staffUserID, int sellerID, int keywordID, String startDate, String startTime, String endDate, String endTime, int reservePrice, int startingPrice, String status) {
        this.itemID = itemID;
        this.propertyID = propertyID;
        this.staffUserID = staffUserID;
        this.sellerID = sellerID;
        this.keywordID = keywordID;
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
        this.reservePrice = reservePrice;
        this.startingPrice = startingPrice;
        this.status = status;
    }

    // For R1 Functionality
    public Auction_Item(int itemID, int propertyID, int staffUserID, int sellerID, String startDate, String startTime, String endDate, String endTime, int reservePrice, int startingPrice, String status) {
        this.itemID = itemID;
        this.propertyID = propertyID;
        this.staffUserID = staffUserID;
        this.sellerID = sellerID;
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
        this.reservePrice = reservePrice;
        this.startingPrice = startingPrice;
        this.status = status;
    }

    // For initial testing purposes only
    public Auction_Item(int itemId, String startDate, String startTime, String endDate, String endTime, int reservePrice, int startingPrice, String status) {
        this.itemID = itemId;
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
        this.reservePrice = reservePrice;
        this.startingPrice = startingPrice;
        this.status = status;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public int getStaffUserID() {
        return staffUserID;
    }

    public void setStaffUserID(int staffUserID) {
        this.staffUserID = staffUserID;
    }

    public int getSellerID() {
        return sellerID;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    public int getSoldTo() {
        return soldTo;
    }

    public void setSoldTo(int soldTo) {
        this.soldTo = soldTo;
    }

    public int getKeywordID() {
        return keywordID;
    }

    public void setKeywordID(int keywordID) {
        this.keywordID = keywordID;
    }

    public int getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(int purchaseID) {
        this.purchaseID = purchaseID;
        
    }

    public int getSoldFor() {
        return soldFor;
    }

    public void setSoldFor(int soldFor) {
        this.soldFor = soldFor;
    }

    public String getDateVerified() {
        return dateVerified;
    }

    public void setDateVerified(String dateVerified) {
        this.dateVerified = dateVerified;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(int reservePrice) {
        this.reservePrice = reservePrice;
    }

    public int getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(int startingPrice) {
        this.startingPrice = startingPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
