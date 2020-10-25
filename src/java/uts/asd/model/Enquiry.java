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
public class Enquiry {
    private int EnquiryId;
    private int UserIdSender;
    private int UserIdReceiver;
    private String SentMessage;
    private String Reply;
    
    public Enquiry(int EnquiryId, int UserIdSender, String SentMessage, String Reply ){
        this.EnquiryId = EnquiryId;
        this.UserIdSender = UserIdSender;
        this.UserIdReceiver = UserIdReceiver;
        this.SentMessage = SentMessage;
        this.Reply = Reply;
    }

    public int getEnquiryId() {
        return EnquiryId;
    }

    public void setEnquiryId(int EnquiryId) {
        this.EnquiryId = EnquiryId;
    }

    public int getUserIdSender() {
        return UserIdSender;
    }

    public void setUserIdSender(int UserIdSender) {
        this.UserIdSender = UserIdSender;
    }

    public int getUserIdReceiver() {
        return UserIdReceiver;
    }

    public void setUserIdReceiver(int UserIdReceiver) {
        this.UserIdReceiver = UserIdReceiver;
    }

    public String getSentMessage() {
        return SentMessage;
    }

    public void setSentMessage(String SentMessage) {
        this.SentMessage = SentMessage;
    }

    public String getReply() {
        return Reply;
    }

    public void setReply(String Reply) {
        this.Reply = Reply;
    }
    
}