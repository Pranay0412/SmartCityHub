package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class DataBaseManager {
    Connection connection;
    public void getInstance() throws ClassNotFoundException {
        String driverManager = "com.mysql.cj.jdbc.Driver";
        Class.forName(driverManager);
        System.out.println("Driver Registered.");
    }
    public void getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/SmartCityHub";
        String user = "root";
        String password = "";

        connection = DriverManager.getConnection(url, user, password);
        if(connection != null) {
            System.out.println("Connected");
        } else {
            System.out.println("Failed.");
        }
    }
    public void closeConnectin(Connection con) throws SQLException {
        con.close();
    }

}
