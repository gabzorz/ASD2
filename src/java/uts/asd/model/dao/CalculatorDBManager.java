package uts.asd.model.dao;

import uts.asd.model.*;
import java.sql.*;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CalculatorDBManager {

    private Statement st;

    public CalculatorDBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }

    public Calculator findValues(int priceCat) throws SQLException {
        String fetch = "SELECT * FROM ASDREAMS.STAMP_DUTY WHERE PRICECAT = " + priceCat;
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            int priceCategory = rs.getInt(1);
            if (priceCategory == priceCat) {
                int variablePrice = rs.getInt(2);
                double variableIncrease = rs.getDouble(3);
                int duitableValue = rs.getInt(4);
                return new Calculator(priceCat, variablePrice, variableIncrease, duitableValue);
            }
        }

        return null;
    }

}
