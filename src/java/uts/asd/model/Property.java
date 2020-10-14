/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.model;

import java.io.Serializable;

/**
 *
 * @author Corey
 */

public class Property implements Serializable {
    private int id;
    private String suburb, address, state, desc;
    private int userID, postcode, numOfBathrooms, numOfBedrooms, numOfGarages;
    private String status;

    public Property(int id, String suburb, String address, String state, String desc, int userID, int postcode, int numOfBathrooms, int numOfBedrooms, int numOfGarages) {
        this.id = id;
        this.suburb = suburb;
        this.address = address;
        this.state = state;
        this.desc = desc;
        this.userID = userID;
        this.postcode = postcode;
        this.numOfBathrooms = numOfBathrooms;
        this.numOfBedrooms = numOfBedrooms;
        this.numOfGarages = numOfGarages;
        this.status = "pending";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public int getNumOfBathrooms() {
        return numOfBathrooms;
    }

    public void setNumOfBathrooms(int numOfBathrooms) {
        this.numOfBathrooms = numOfBathrooms;
    }

    public int getNumOfBedrooms() {
        return numOfBedrooms;
    }

    public void setNumOfBedrooms(int numOfBedrooms) {
        this.numOfBedrooms = numOfBedrooms;
    }

    public int getNumOfGarages() {
        return numOfGarages;
    }

    public void setNumOfGarages(int numOfGarages) {
        this.numOfGarages = numOfGarages;
    }
    
    
    /**private Status status;
     * 
    public enum Status{
        PENDING,
        APPROVED,
        REJECTED
    } 
    **/
    
    
    
}
