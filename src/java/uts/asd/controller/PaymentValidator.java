/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.controller;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

/**
 *
 * @author CristinaFidelino
 */
public class PaymentValidator implements Serializable {
    
    //First letter of names have to be Upper Case
    private String namePattern = "[A-Z][a-z]*";
    //Length of numbers must be between 8 (Account Number) and 6 (BSB)
    private String numberPattern = "[0-9]{8,6}";

    public PaymentValidator() {
    }

    public boolean validate(String pattern, String input) {
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(input);

        return match.matches();
    }

    //Function to validate the text fields when updating a profile
    public boolean checkUpdateIsEmpty(String firstName, String lastName,
            String accountNumber, String bsb) {
        return firstName.isEmpty() || lastName.isEmpty() || accountNumber.isEmpty()
                || bsb.isEmpty();
    }

    //Function to check if the text fields in payment.jsp are empty
    public boolean checkRegisterIsEmpty(String firstName, String lastName,
            String accountNumber, String bsb) {
        return firstName.isEmpty() || lastName.isEmpty() || accountNumber.isEmpty()
                || bsb.isEmpty();
    }

    //Function to check if name format is valid
    public boolean validateName(String name) {
        return validate(namePattern, name);
    }

    //Function to check if number format is valid
    public boolean validateNumber(String number) {
        return validate(numberPattern, number);
    }

    //Function to clear errors when page is refreshed
    public void clear(HttpSession session) {
        session.setAttribute("existErr", "");
        session.setAttribute("firstNameErr", "");
        session.setAttribute("lastNameErr", "");
        session.setAttribute("accountNumErr", "");
        session.setAttribute("bsbErr", "");

    }
    
}
