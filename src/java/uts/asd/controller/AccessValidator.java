package uts.asd.controller;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

public class AccessValidator implements Serializable {

    //Email has to have a mail server and a domain name
    private String emailPattern
            = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})"
            + "((([.])[a-z]{0,2})*)";
    //First letter of the name has to be uppercase
    private String namePattern = "[A-Z][a-z]*";
    //password is combination of  lower and upper case letters 
    //and numbers, 4 characters minimum
    private String passwordPattern = "[a-z0-9]{4,}";
    //number length must be between 8 (landline) and 10 (mobile)
    private String numberPattern = "[0-9]{8,10}";

    public AccessValidator() {
    }

    public boolean validate(String pattern, String input) {
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(input);

        return match.matches();
    }

    //Function to validate the textfields when updating a profile
    public boolean checkUpdateIsEmpty(String fname, String lname,
            String address, String number, String password) {
        return fname.isEmpty() || lname.isEmpty() || address.isEmpty()
                || number.isEmpty() || password.isEmpty();
    }

    //Function to check if the textfields in the register.jsp is empty
    public boolean checkRegisterIsEmpty(String fname, String lname,
            String dob, String address, String email,
            String number, String password) {
        return fname.isEmpty() || lname.isEmpty() || dob.isEmpty()
                || address.isEmpty() || email.isEmpty() || number.isEmpty()
                || password.isEmpty();
    }

    //Function to check for empty textfield in the login.jsp
    public boolean checkEmpty(String email, String password) {
        return email.isEmpty() || password.isEmpty();
    }

    //function to check if email format is valid
    public boolean validateEmail(String email) {
        return validate(emailPattern, email);
    }

    //function to check if name format is valid
    public boolean validateName(String name) {
        return validate(namePattern, name);
    }

    //function to check if password format is valid
    public boolean validatePassword(String password) {
        return validate(passwordPattern, password);
    }

    //function to check if number format is valid
    public boolean validateNumber(String number) {
        return validate(numberPattern, number);
    }

    //function to clear errors when page is refreshed
    public void clear(HttpSession session) {
        session.setAttribute("emailErr", "");
        session.setAttribute("passErr", "");
        session.setAttribute("existErr", "");
        session.setAttribute("fnameErr", "");
        session.setAttribute("lnameErr", "");
        session.setAttribute("numErr", "");
        session.setAttribute("empErr", "");

    }
}
