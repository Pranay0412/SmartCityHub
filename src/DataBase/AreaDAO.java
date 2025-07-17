package DataBase;

import Model.Area;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AreaDAO {
    private Connection connection = DataBaseManager.connection;

    public AreaDAO() {
        try {
            DataBaseManager.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean addArea(Area area){
        String query = "INSERT INTO Area (Id, Name, Latitude, Longitude, IsEmergencyPoint) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, area.getAreaId());
            stmt.setString(2, area.getName());
            stmt.setDouble(3, area.getLatitude());
            stmt.setDouble(4, area.getLongitude());
            stmt.setBoolean(5, area.isEmergencyPoint());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public Area getAreaById(int areaId){
        String query = "SELECT * FROM Area WHERE Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, areaId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Area area = new Area();
                area.setId(rs.getInt(1));
                area.setName(rs.getString(2));
                area.setLatitude(rs.getDouble(3));
                area.setLongitude(rs.getDouble(4));
                return area;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Area> getAllArea() {

    }
    public void updateArea(Area area){

    }
    public void deleteArea(int areaId){

    }
    public List<Area> getAreaInArea(double minLat, double maxLat, double minLon, double maxLon) {

    }
}
