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
    private String subject;
    private String category;
    private Date datesent;
    private Date datecompleted;
    private String status;
    private int userId;
    private int staffId;
    private String response;
    
    public HelpTicket(int helpTicketId, String details, String subject, String category, Date datesent, 
            Date datecompleted, String status, int userId, int staffId, 
            String response) {
        this.helpTicketId = helpTicketId;
        this.details = details;
        this.subject = subject;
        this.category = category;
        this.datesent = datesent;
        this.datecompleted = datecompleted;
        this.status = status;
        this.userId = userId;
        this.staffId = staffId;
        this.response = response;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    

    public Date getDatesent() {
        return datesent;
    }

    public void setDatesent(Date datesent) {
        this.datesent = datesent;
    }

    public Date getDatecompleted() {
        return datecompleted;
    }

    public void setDatecompleted(Date datecompleted) {
        this.datecompleted = datecompleted;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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