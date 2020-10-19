package uts.asd.model.dao;

import uts.asd.model.*;
import java.sql.*;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AccessDBManager {

    private Statement st;

    public AccessDBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
//suburb,street,address,postcode,state,desc,bathroom,bedroom,garage,email
    //Function to create a new Customer

    public void addProperty(String suburb, String address, String postcode, String state, String desc,
            String bathroom, String bedroom, String garage, int userID) throws SQLException {
        st.executeUpdate("INSERT INTO ASDREAMS.PROPERTY (SUBURB, ADDRESS, POSTCODE, STATE, DESCR, BATHROOM, BEDROOM, GARAGE, USERID, STATUS) "
                + "VALUES ('" + suburb + "','" + address + "','" + postcode + "','" + state + "','" + desc + "','" + bathroom + "','" + bedroom + "','" + garage + "'," + userID + ",'pending')");
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
    
    public Calculator findValues(int priceCat) throws SQLException {
        String fetch = "SELECT * FROM ASDREAMS.STAMP_DUTY WHERE PRICECAT = " + priceCat;
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            int priceCategory = rs.getInt(1);
            if (priceCategory == priceCat) {
                int variablePrice = rs.getInt(2);
                float variableIncrease = rs.getFloat(3);
                int duitableValue = rs.getInt(4);
                return new Calculator(priceCat, variablePrice, variableIncrease, duitableValue);
            }
        }

        return null;
    }
    
    

    // Returns the highest userId (i.e. the latest created userId)
    public int readHighestCustomerId() throws SQLException {
        String fetch = "SELECT MAX(USERID) FROM ASDREAMS.USER_ACCOUNT";
        ResultSet rs = st.executeQuery(fetch);
        int highestId = 0;
        while (rs.next()) {
            highestId = rs.getInt(1);
        }
        return highestId;
    }

    // Returns the highest userId (i.e. the latest created userId)
    public int readHighestPropertyId() throws SQLException {
        String fetch = "SELECT MAX(PROPERTYID) FROM ASDREAMS.PROPERTY";
        ResultSet rs = st.executeQuery(fetch);
        int highestId = 0;
        while (rs.next()) {
            highestId = rs.getInt(1);
        }
        return highestId;
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
                return new User(customerID, fName, lName, address, dob, customerEmail,
                        contactNumber, password, roleId);
            }
        }
        return null;
    }

    public User findCustomerById(int userId) throws SQLException {
        String fetch = "select * from ASDREAMS.USER_ACOUNT WHERE USERID=" + userId;
        ResultSet rs = st.executeQuery(fetch);
        while (rs.next()) {
            String fName = rs.getString(2);
            String lName = rs.getString(3);
            String address = rs.getString(4);
            String dob = rs.getString(5);
            String customerEmail = rs.getString(6);
            String contactNumber = rs.getString(7);
            String password = rs.getString(8);
            Integer roleId = rs.getInt(9);
            return new User(userId, fName, lName, address, dob, customerEmail,
                    contactNumber, password, roleId);
        }
        return null;
    }

    //Function to find a user using email
    public User findEmail(String email) throws SQLException {
        String fetch = "SELECT * FROM ASDREAMS.USER_ACCOUNT where EMAILADDRESS = '" + email + "'";
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
                String password = rs.getString(7);
                Integer roleId = rs.getInt(9);
                return new User(customerID, fName, lName, address, dob, customerEmail,
                        contactNumber, password, roleId);
            }
        }
        return null;
    }

    public Property getProperty(int UserID) throws SQLException {
      String fetch = "select * from ASDREAMS.PROPERTY where USERID = "+ UserID +""; // AND STATUS <> 'pending'
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            int id = rs.getInt(1);
            //int idInt = Integer.parseInt(id);
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
            int userID = rs.getInt(10);
            return new Property(id, suburb, address, state, desc, userID, postcodeInt, bathroomInt, bedroomInt, garageInt);
            
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
    
    public void updateValues(int priceCat, int variablePrice, float variableIncrease, int duitableVariable) throws SQLException{
        st.executeUpdate("UPDATE ASDREAMS.STAMP_DUTY SET VARIABLEPRICE = " + variablePrice + ", VARIABLEINCREASE = " + variableIncrease + ", DUITABLEVALUE = " + duitableVariable + " WHERE PRICECAT = " + priceCat);
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

    // Creates a bid database entry
    public void createBid(int itemId, int userId, int amount) throws SQLException {
        st.executeUpdate("INSERT INTO ASDREAMS.BID (ITEMID, USERID, AMOUNT) "
                + "VALUES (" + itemId + ", " + userId + ", " + amount + ")");
    }

    // Returns the highest bid that has been placed for an auction based on itemId
    public int readHighestBid(int itemId) throws SQLException {
        String fetch = "select MAX(AMOUNT) from ASDREAMS.BID WHERE ITEMID=" + itemId;
        ResultSet rs = st.executeQuery(fetch);
        int highestBid = 0;
        while (rs.next()) {
            highestBid = rs.getInt(1);
        }
        return highestBid;
    }

    // Creates a new Auction Item with Keyword
    public void createAuctionItem(int propertyId, int staffUserId, int sellerId, int keywordId, String startDate, String startTime,
            String endDate, String endTime, int reservePrice, int startingPrice) throws SQLException {
        st.executeUpdate("INSERT INTO ASDREAMS.AUCTION_ITEM (PROPERTYID, STAFFUSERID, SELLERID, KEYWORDID, STARTDATE, STARTTIME, "
                + "ENDDATE, ENDTIME, RESERVEPRICE, STARTINGPRICE, STATUS) VALUES (" + propertyId + ", " + staffUserId + ", " + sellerId + ", "
                + keywordId + ", '" + startDate + "', '" + startTime + "', '" + endDate + "', '" + endTime + "', " + reservePrice + ", "
                + startingPrice + ", 'Ongoing')");
    }

    // Creates a new Auction Item without Keyword
    public void createAuctionItem(int propertyId, int staffUserId, int sellerId, String startDate, String startTime,
            String endDate, String endTime, int reservePrice, int startingPrice) throws SQLException {
        st.executeUpdate("INSERT INTO ASDREAMS.AUCTION_ITEM (PROPERTYID, STAFFUSERID, SELLERID, STARTDATE, STARTTIME, "
                + "ENDDATE, ENDTIME, RESERVEPRICE, STARTINGPRICE, STATUS) VALUES (" + propertyId + ", " + staffUserId + ", " + sellerId + ", '"
                + startDate + "', '" + startTime + "', '" + endDate + "', '" + endTime + "', " + reservePrice + ", "
                + startingPrice + ", 'Ongoing')");
    }

    // Updates an AuctionItem database entry
    public void updateAuctionItem(int itemId, Date startDate, Time startTime, Date endDate, Time endTime, int reservePrice,
            int startingPrice) throws SQLException {
        st.execute("UPDATE ASDREAMS.AUCTION_ITEM SET STARTDATE='" + startDate + "', STARTTIME='"
                + startTime + "', ENDDATE='" + endDate + "', ENDTIME='" + endTime + "', RESERVEPRICE="
                + reservePrice + ", STARTINGPRICE=" + startingPrice + " WHERE ITEMID=" + itemId);
    }

    // Returns the Auction with the highest itemId (i.e. the latest created auction)
    public int readHighestAuctionId() throws SQLException {
        String fetch = "SELECT MAX(ITEMID) FROM ASDREAMS.AUCTION_ITEM";
        ResultSet rs = st.executeQuery(fetch);
        int highestId = 0;
        while (rs.next()) {
            highestId = rs.getInt(1);
        }
        return highestId;
    }

    // Updates the status of the provided Auction Item
    public void updateAuctionStatus(int itemId, String status) throws SQLException {
        st.execute("UPDATE ASDREAMS.AUCTION_ITEM SET STATUS='" + status
                + "' WHERE ITEMID=" + itemId);
    }

    // Deletes the Auction Item with itemId
    public void deleteAuctionItem(int itemId) throws SQLException {
        st.execute("DELETE FROM ASDREAMS.AUCTION_ITEM WHERE ITEMID=" + itemId);
    }

    // Returns the start date of the Auction Item with itemId
    public Date readAuctionStartDate(int itemId) throws SQLException {
        String fetch = "select STARTDATE from ASDREAMS.AUCTION_ITEM WHERE ITEMID=" + itemId;
        ResultSet rs = st.executeQuery(fetch);
        Date startDate = null;
        while (rs.next()) {
            startDate = rs.getDate(1);
        }
        return startDate;
    }

    // Returns the end date of the Auction Item with itemId
    public Date readAuctionEndDate(int itemId) throws SQLException {
        String fetch = "select ENDDATE from ASDREAMS.AUCTION_ITEM WHERE ITEMID=" + itemId;
        ResultSet rs = st.executeQuery(fetch);
        Date endDate = null;
        while (rs.next()) {
            endDate = rs.getDate(1);
        }
        return endDate;
    }

    // Returns the start time of the Auction Item with itemId
    public Time readAuctionStartTime(int itemId) throws SQLException {
        String fetch = "select STARTTIME from ASDREAMS.AUCTION_ITEM WHERE ITEMID=" + itemId;
        ResultSet rs = st.executeQuery(fetch);
        Time startTime = null;
        while (rs.next()) {
            startTime = rs.getTime(1);
        }
        return startTime;
    }

    // Returns the end time of the Auction Item with itemId
    public Time readAuctionEndTime(int itemId) throws SQLException {
        String fetch = "select ENDTIME from ASDREAMS.AUCTION_ITEM WHERE ITEMID=" + itemId;
        ResultSet rs = st.executeQuery(fetch);
        Time endTime = null;
        while (rs.next()) {
            endTime = rs.getTime(1);
        }
        return endTime;
    }

    // Returns the Auction Item with itemId
    public Auction_Item getAuctionItem(int itemId) throws SQLException {
        String fetch = "select * from ASDREAMS.AUCTION_ITEM WHERE ITEMID=" + itemId;
        ResultSet rs = st.executeQuery(fetch);
        while (rs.next()) {
            int propertyId = rs.getInt(2);
            int staffUserId = rs.getInt(3);
            int sellerId = rs.getInt(4);
            String startDate = rs.getDate(9).toString();
            String startTime = rs.getTime(10).toString();
            String endDate = rs.getDate(11).toString();
            String endTime = rs.getTime(12).toString();
            int reservePrice = rs.getInt(13);
            int startingPrice = rs.getInt(14);
            String status = rs.getString(15);
            return new Auction_Item(itemId, propertyId, staffUserId, sellerId,
                    startDate, startTime, endDate, endTime, reservePrice, startingPrice,
                    status);
        }
        return null;
    }

    public boolean doesAuctionExist(int propertyId) throws SQLException {
        String fetch = "SELECT * FROM ASDREAMS.AUCTION_ITEM WHERE PROPERTYID=" + propertyId;
        ResultSet rs = st.executeQuery(fetch);
        if (!rs.next()) {
            return false;
        } else {
            return true;
        }
    }
    
    public int getAuctionId(int propertyId) throws SQLException {
        String fetch = "SELECT MAX(ITEMID) FROM ASDREAMS.AUCTION_ITEM WHERE PROPERTYID=" + propertyId;
        ResultSet rs = st.executeQuery(fetch);
        int highestId = -1;
        while (rs.next()) {
            highestId = rs.getInt(1);
        }
        return highestId;
    }

    public void deleteProperty(int UserID) throws SQLException {
        st.executeUpdate("DELETE FROM ASDREAMS.PROPERTY WHERE UserID="
                + UserID + "");
    }

    public void updateProperty(Property p) throws SQLException {
        int id = p.getId();
        String suburb = p.getSuburb();
        String address = p.getAddress();
        String state = p.getState();
        String postcode = Integer.toString(p.getPostcode());
        String desc = p.getDesc();
        int userID = p.getUserID();
        String bathroom = Integer.toString(p.getNumOfBathrooms());
        String bedroom = Integer.toString(p.getNumOfBedrooms());
        String garage = Integer.toString(p.getNumOfGarages());

        st.executeUpdate("UPDATE ASDREAMS.PROPERTY SET SUBURB='" + suburb + "', ADDRESS='" + address + "', POSTCODE='" + postcode + "',"
                + " STATE='" + state + "', DESCR='" + desc + "', BATHROOM='" + bathroom + "', BEDROOM='" + bedroom + "', GARAGE='" + garage + "' "
                + "WHERE PROPERTYID =" + id + "");
    }
    
    public void updatePropertyStatus(int propertyId, String status) throws SQLException{
        st.executeUpdate("UPDATE ASDREAMS.PROPERTY SET STATUS='" + status + "' WHERE PROPERTYID =" + propertyId);
    }

    public void createOpenDayListing(int staffId, int propertyId, String date, String startTime, String endTime) throws SQLException {
        st.executeUpdate("INSERT INTO ASDREAMS.OPEN_DAY_BOOKING (STAFFID, PROPERTYID, DATE, STARTTIME, ENDTIME, STATUS) VALUES (" + staffId + ", "
                + propertyId + ", '" + date + "', '" + startTime + "', '" + endTime + "', 'Available)");
    }

    public int getOpenDayListingId(int propertyId, String date, String startTime) throws SQLException {
        String fetch = "SELECT BOOKINGID FROM ASDREAMS.OPEN_DAY_BOOKING WHERE PROPERTYID=" + propertyId + " AND DATE='" + date
                + "' AND startTime='" + startTime;
        ResultSet rs = st.executeQuery(fetch);
        int listingId = -1;
        while (rs.next()) {
            listingId = rs.getInt(1);
        }
        return listingId;
    }

    public void updateOpenDayListing(int listingId, String date, String startTime, String endTime) throws SQLException {
        st.executeUpdate("UPDATE ASDREAMS.OPEN_DAY_BOOKING SET DATE='" + date + "', STARTTIME='" + startTime + "', ENDTIME='"
                + endTime + "' WHERE LISTINGID=" + listingId);
    }

    public void updateOpenDayListingBooked(int listingId, int userId) throws SQLException {
        st.executeUpdate("UPDATE ASDREAMS.OPEN_DAY_BOOKING SET USERID=" + userId + " WHERE LISTINGID=" + listingId);
    }

    public void deleteOpenDayListing(int listingId) throws SQLException {
        st.executeUpdate("DELETE FROM ASDREAMS.OPEN_DAY_BOOKING WHERE LISTINGID=" + listingId);
    }

    public ArrayList<Open_Day_Booking> getAllPropertyOpenDays(int propertyId) throws SQLException {
        String fetch = "SELECT * FROM ASDREAMS.OPEN_DAY_BOOKING WHERE PROPERTYID=" + propertyId + " ORDER BY DATE, STARTTIME";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Open_Day_Booking> openDayBookings = new ArrayList<Open_Day_Booking>();
        Open_Day_Booking currentBooking;
        while (rs.next()) {
            int bookingId = rs.getInt(1);
            int staffId = rs.getInt(2);
            int userId = rs.getInt(3);
            String date = rs.getDate(5).toString();
            String startTime = rs.getTime(6).toString();
            String endTime = rs.getTime(7).toString();
            String status = rs.getString(8);
            if (userId != 0) {
                currentBooking = new Open_Day_Booking(bookingId, staffId, userId, propertyId,
                        date, startTime, endTime, status);
            } else {
                currentBooking = new Open_Day_Booking(bookingId, staffId, propertyId,
                        date, startTime, endTime, status);
            }
            openDayBookings.add(currentBooking);
        }
        return openDayBookings;
    }
}