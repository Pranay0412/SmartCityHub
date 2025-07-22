package DataBase;

import Model.Schedule;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAO {
    private Connection connection = DataBaseManager.connection;

    public ScheduleDAO() {
            try {
                DataBaseManager.getConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    public boolean addSchedule(Schedule schedule) {
        String query = "INSERT INTO Schedule (RouteId, DepartureTime) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, schedule.getRouteID());
            stmt.setTime(2, schedule.getDepartureTime());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public Schedule getScheduleByRouteId(int routeId){
        String query = "SELECT * FROM Schedule WHERE RouteId = ? ";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, routeId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(rs.getInt(1));
                schedule.setRouteID(rs.getInt(2));
                schedule.setDepartureTime(rs.getTime(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
