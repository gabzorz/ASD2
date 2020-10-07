package uts.asd.controller;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

public class CalculatorValidator implements Serializable {

    public CalculatorValidator() {
    }

    public Boolean equityEmptyInput(String price, String loan) {
        return price.isEmpty() || loan.isEmpty();
    }

    public Boolean equityPositive(String price, String loan) {
        double price1 = Double.parseDouble(price);
        double loan1 = Double.parseDouble(loan);
        return price1 < 0 || loan1 < 0;
    }

    public Boolean equityValidate(String price, String loan) {
        double price1 = Double.parseDouble(price);
        double loan1 = Double.parseDouble(loan);
        return loan1 > price1;
    }

    public void clear(HttpSession session) {
        session.setAttribute("inputErr", "");

    }

}
