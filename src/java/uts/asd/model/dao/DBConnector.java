package uts.asd.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector extends DB {
    //create a connection to the database
    public DBConnector() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        super.conn = DriverManager.getConnection(URL + db, dbuser, dbpass);
    }

    public Connection openConnection() {
        return super.conn;
    }

    public void closeConnection() throws SQLException {
        super.conn.close();
    }
}
