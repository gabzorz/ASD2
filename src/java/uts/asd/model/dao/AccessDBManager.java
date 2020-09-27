package uts.asd.model.dao;

import uts.asd.model.*;
import java.sql.*;
import java.lang.String;

public class AccessDBManager {

    private Statement st;

    public AccessDBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
//suburb,street,address,postcode,state,desc,bathroom,bedroom,garage,email
    //Function to create a new Customer
    public void addProperty(String suburb, String address, String postcode, String state, String desc,
            String bathroom, String bedroom, String garage, String email) throws SQLException {
        st.executeUpdate("INSERT INTO ASDREAMS.PROPERTY (SUBURB, ADDRESS, POSTCODE, STATE, DESCR, BATHROOM, BEDROOM, GARAGE, EMAIL) "
                + "VALUES ('" + suburb + "','" + address + "','" + postcode + "','" + state + "','" + desc + "','" + bathroom + "','" + bedroom + "','" + garage + "','" + email + "')");
    }

        //Function to create a new Customer
    public void createCustomer(String fName, String lName, String address,
            String dob, String emailAddress, String contactNumber,
            String password, int roleId) throws SQLException {
        st.executeUpdate("INSERT INTO ASDREAMS.USER_ACCOUNT (FNAME, LNAME, ADDRESS, "
                + "DATEOFBIRTH, EMAILADDRESS, CONTACTNUMBER, PASSWORD, "
                + "ROLEID) "
                + "VALUES ('" + fName + "','" + lName + "','" + address
                + "','" + dob + "','"
                + emailAddress + "','" + contactNumber
                + "','" + password + "'," + roleId + ")");
    }
    
    //Function to find a customer using an email and password pair
    public User findCustomer(String email, String password) throws SQLException {
        String fetch = "select * from ASDREAMS.USER_ACCOUNT where EMAILADDRESS = '"
                + email + "'AND PASSWORD='" + password + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String customerEmail = rs.getString(6);
            if (customerEmail.equals(email)) {
                Integer customerID = rs.getInt(1);
                String fName = rs.getString(2);
                String lName = rs.getString(3);
                String address = rs.getString(4);
                String dob = rs.getString(5);
                String contactNumber = rs.getString(7);
                Integer roleId = rs.getInt(9);
                return new User(fName, lName, address, dob, customerEmail,
                        contactNumber, password, roleId);
            }
        }
        return null;
    }

    //Function to find a user using email
    public User findEmail(String email) throws SQLException {
        String fetch = "select * from ASDREAMS.USER_ACCOUNT where EMAILADDRESS = "
                + "'" + email + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String customerEmail = rs.getString(6);
            if (customerEmail.equals(email)) {
                String fName = rs.getString(2);
                String lName = rs.getString(3);
                String address = rs.getString(4);
                String dob = rs.getString(5);
                String contactNumber = rs.getString(7);
                String password = rs.getString(7);
                Integer roleId = rs.getInt(9);
                return new User(fName, lName, address, dob, customerEmail,
                        contactNumber, password, roleId);
            }
        }
        return null;
    }

        public Property getProperty(String email) throws SQLException {
        String fetch = "select * from ASDREAMS.PROPERTY where EMAIL = "
                + "'" + email + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String customerEmail = rs.getString(6);
            if (customerEmail.equals(email)) {
                int id = 0;
                String suburb = rs.getString(2);
                String address = rs.getString(3);
                String postcode = rs.getString(4);
                int postcodeInt = Integer.parseInt(postcode);
                String state = rs.getString(5);
                String desc = rs.getString(6);
                String bathroom = rs.getString(7);
                int bathroomInt = Integer.parseInt(bathroom);
                String bedroom = rs.getString(8);
                int bedroomInt = Integer.parseInt(bedroom);
                String garage = rs.getString(9);
                int garageInt = Integer.parseInt(garage);
                String userEmail = rs.getString(10);
                return new Property(id, suburb, address, state, desc, userEmail, postcodeInt, bathroomInt, bedroomInt, garageInt);
            }
        }
        return null;
    }
    
    //Function to update the customer profile
    public void updateCustomer(String fName, String lName, String address,
            String contactNumber, String password, String email)
            throws SQLException {
        st.executeUpdate("UPDATE ASDREAMS.USER_ACCOUNT SET FNAME='" + fName
                + "', LNAME='" + lName + "', ADDRESS='" + address
                + "', CONTACTNUMBER='" + contactNumber + "', PASSWORD='"
                + password + "' WHERE EMAILADDRESS='" + email + "'");
    }

    //Function to check if a an email is used
    public boolean checkEmail(String email) throws SQLException {
        String fetch = "select * from ASDREAMS.USER_ACCOUNT where EMAILADDRESS='"
                + email + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String customerEmail = rs.getString(6);
            if (customerEmail.equals(email)) {
                return true;
            }
        }
        return false;
    }

    //Function to delete a user
    public void deleteUser(String email) throws SQLException {
        st.executeUpdate("DELETE FROM ASDREAMS.USER_ACCOUNT WHERE EMAILADDRESS='"
                + email + "'");
    }

    //Function to check a user's role
    public int checkRole(String email) throws SQLException {
        String fetch = "select * from ASDREAMS.USER_ACCOUNT where EMAILADDRESS='"
                + email + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String customerEmail = rs.getString(6);
            int userRole = rs.getInt(9);
            if (customerEmail.equals(email)) {
                return userRole;
            }
        }
        return 0;
    }
    
    public void createBid(int itemId, int userId, int amount) throws SQLException {
        st.executeUpdate("INSERT INTO ASDREAMS.BID (ITEMID, USERID, AMOUNT) "
                + "VALUES (" + itemId + ", " + userId + ", " + amount + ")");
    }
    
    public void createAuctionItem(int propertyId, int staffUserId, int sellerId, int keywordId, Date startDate, Time startTime, 
            Date endDate, Time endTime, int reservePrice, int startingPrice) throws SQLException {
        st.executeUpdate("INSERT INTO ASDREAMS.AUCTION_ITEM (PROPERTYID, STAFFUSERID, SELLERID, KEYWORDID, STARTDATE, STARTTIME, " +
                "ENDDATE, ENDTIME, RESERVEPRICE, STARTINGPRICE) VALUES (" + propertyId + ", " + staffUserId + ", " + sellerId + ", "
                + keywordId + ", " + startDate + ", " + startTime + ", " + endDate + ", " + endTime + ", " + reservePrice + ", " 
                + startingPrice + ")");
    }
}
