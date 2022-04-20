package cs411.flightbooking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DBConn - a class for connecting between Java classes and database
 */
public class DBConn {

    private static final String MYSQL_URL = "jdbc:mysql://localhost:3306/";

    private static final String MYSQL_CONF_STRING
            = "?allowPublicKeyRetrieval=true&useSSL=false";

    private static final String MYSQL_USERNAME = "cs411";

    private static final String MYSQL_PASSWORD = "12345";

    public static Connection createConnection(String dbName)
            throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                MYSQL_URL + dbName + MYSQL_CONF_STRING,
                MYSQL_USERNAME,
                MYSQL_PASSWORD);

        return conn;
    }

    public static Connection defaultConnection()
            throws ClassNotFoundException, SQLException {
        return createConnection("cs411");
    }
}
