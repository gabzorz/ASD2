/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.model;

import java.sql.*;

/**
 *
 * @author Hamish Lamond
 */
public class Bid {

    private int itemId;
    private int userId;
    private Date date;
    private Time time;
    private int amount;

    public Bid(int itemId, int userId, Date date, Time time, int amount) {
        this.itemId = itemId;
        this.userId = userId;
        this.date = date;
        this.time = time;
        this.amount = amount;
    }

    public Bid(int itemId, int userId, int amount) {
        this.itemId = itemId;
        this.userId = userId;
        this.amount = amount;
    }
    
    

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
