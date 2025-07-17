package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class DataBaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/SmartCityHub";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    static Connection connection;

    public void getInstance() throws ClassNotFoundException {
        String driverManager = "com.mysql.cj.jdbc.Driver";
        Class.forName(driverManager);
        System.out.println("Driver Registered.");
    }

    public static void getConnection() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        if (connection != null) {
            System.out.println("Connected");
        } else {
            System.out.println("Failed.");
        }
    }

    public void closeConnectin(Connection con) throws SQLException {
        con.close();
    }

}
