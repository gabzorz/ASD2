package uts.asd.model.dao;

import java.sql.Connection;

public abstract class DB {

    //Database properties
    protected String URL = "jdbc:derby://localhost:1527/";
    protected String db = "asdtest";
    protected String dbuser = "asd";
    protected String dbpass = "asd";
    protected String driver = "org.apache.derby.jdbc.ClientDriver";
    protected Connection conn;
}
