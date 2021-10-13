package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLConnect {

    private static String url = "jdbc:mysql://localhost/world";


    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        // Class.forName("com.mysql.jdbc.Driver"); --- Deprecated
        Class.forName("com.mysql.cj.jdbc.Driver");
        Properties props = new Properties();
        props.setProperty("user","root");
        props.setProperty("password","password");
        props.setProperty("ssl","true");


        try{
            Connection conn = DriverManager.getConnection(url, props);
            return conn;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }
}
