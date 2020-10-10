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
            String bathroom, String bedroom, String garage, String email) throws SQLException {
        st.executeUpdate("INSERT INTO ASDREAMS.PROPERTY (SUBURB, ADDRESS, POSTCODE, STATE, DESCR, BATHROOM, BEDROOM, GARAGE, EMAIL, STATUS) "
                + "VALUES ('" + suburb + "','" + address + "','" + postcode + "','" + state + "','" + desc + "','" + bathroom + "','" + bedroom + "','" + garage + "','" + email + "','pending')");
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
        String fetch = "SELECT * FROM ASDREAMS.USER_ACCOUNT where EMAILADDRESS = '" + email + "'";
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
                String userEmail = rs.getString(10);
                return new Property(id, suburb, address, state, desc, userEmail, postcodeInt, bathroomInt, bedroomInt, garageInt);
        }
        return null;
    }

        public HashMap<Integer, Property> getProperties() throws SQLException {
        
            HashMap<Integer, Property> properties = new HashMap<Integer, Property>();
            Property property;
            String fetch = "select * from ASDREAMS.PROPERTY where STATUS = 'pending'";
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
                String userEmail = rs.getString(10);
                property = new Property(id, suburb, address, state, desc, userEmail, postcodeInt, bathroomInt, bedroomInt, garageInt);
                properties.put(property.getId(), property);
        }
        return properties;
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

    public void deleteProperty(String email) throws SQLException {
                st.executeUpdate("DELETE FROM ASDREAMS.PROPERTY WHERE EMAIL='"
                + email + "'");
    }

    public void updateProperty(Property p) throws SQLException {
        int id = p.getId();
        String suburb = p.getSuburb();
        String address = p.getAddress();
        String state = p.getState();
        String postcode = Integer.toString(p.getPostcode());
        String desc = p.getDesc();
        String email = p.getUserEmail();
        String bathroom = Integer.toString(p.getNumOfBathrooms()); 
        String bedroom = Integer.toString(p.getNumOfBedrooms()); 
        String garage = Integer.toString(p.getNumOfGarages()); 

        
        st.executeUpdate("UPDATE ASDREAMS.PROPERTY SET SUBURB='"+ suburb +"', ADDRESS='"+ address +"', POSTCODE='"+ postcode +"',"
        + " STATE='"+state+"', DESCR='"+ desc +"', BATHROOM='"+ bathroom +"', BEDROOM='"+ bedroom +"', GARAGE='"+ garage +"' "
        + "WHERE PROPERTYID ="+ id +"");
    }
}
