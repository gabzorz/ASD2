/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Sean
 */
public class HelpTicket {
    private int helpTicketId;
    private String details;
    private String category;
    private Date sent;
    private String assigned;
    private String completed;
    private int userId;
    private int staffId;
    
    public HelpTicket(int helpTicketId, String details, String category, Date sent, String assigned, String completed, int userId, int staffId) {
        this.helpTicketId = helpTicketId;
        this.details = details;
        this.category = category;
        this.sent = sent;
        this.assigned = assigned;
        this.completed = completed;
        this.userId = userId;
        this.staffId = staffId;
    }

    public int getHelpTicketId() {
        return helpTicketId;
    }

    public void setHelpTicketId(int helpTicketId) {
        this.helpTicketId = helpTicketId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getDate() {
        return sent;
    }

    public void setDate(Date sent) {
        this.sent = sent;
    }

    public String getAssigned() {
        return assigned;
    }

    public void setAssigned(String assigned) {
        this.assigned = assigned;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    
}