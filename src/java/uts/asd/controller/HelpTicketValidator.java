package uts.asd.controller;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

public class HelpTicketValidator implements Serializable {
    
    public HelpTicketValidator() {
    }

    public boolean validate(String pattern, String input) {
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(input);
        return match.matches();
    }

    //Function to validate the textfields when updating a profile
    public boolean checkIsEmpty(String subject, String detail) {
        return subject.isEmpty() || detail.isEmpty();
    }
    
    //Function to validate the textfields when updating a profile
    public boolean checkIsEmpty2(String detail) {
        return detail.isEmpty();
    }

    //function to clear errors when page is refreshed
    public void clear(HttpSession session) {
        session.setAttribute("ticketdetailsErr", "");
    }
}
