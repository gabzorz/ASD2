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
public class Auction_Item {
    
    private String itemID;
    private String propertyID;
    private String staffUserID;
    private String sellerID;
    private String soldTo;
    private String keywordID;
    private String purchaseID;
    private int soldFor;
    private String dateVerified;
    private String startDate;
    private String startTime;
    private String endDate;
    private String endTime;
    private int reservePrice;
    private int startingPrice;
    private String status;

    public Auction_Item(String itemID, String propertyID, String staffUserID, String sellerID, String keywordID, String startDate, String startTime, String endDate, String endTime, int reservePrice, int startingPrice) {
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
        this.status = "ongoing";
    }

    // For initial testing purposes only
    public Auction_Item(String startDate, String startTime, String endDate, String endTime, int reservePrice, int startingPrice) {
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
        this.reservePrice = reservePrice;
        this.startingPrice = startingPrice;
        this.status = "ongoing";
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(String propertyID) {
        this.propertyID = propertyID;
    }

    public String getStaffUserID() {
        return staffUserID;
    }

    public void setStaffUserID(String staffUserID) {
        this.staffUserID = staffUserID;
    }

    public String getSellerID() {
        return sellerID;
    }

    public void setSellerID(String sellerID) {
        this.sellerID = sellerID;
    }

    public String getSoldTo() {
        return soldTo;
    }

    public void setSoldTo(String soldTo) {
        this.soldTo = soldTo;
    }

    public String getKeywordID() {
        return keywordID;
    }

    public void setKeywordID(String keywordID) {
        this.keywordID = keywordID;
    }

    public String getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(String purchaseID) {
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
