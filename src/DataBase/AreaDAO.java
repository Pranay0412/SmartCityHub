package DataBase;

import Model.Area;

import java.sql.*;
import java.util.ArrayList;
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

    /**
     * Add a new Area.
     *
     * @param area Object of Area
     * @return true if area is added
     */
    public boolean addArea(Area area) {
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

    /**
     * Get Area by id.
     *
     * @param areaId area id
     * @return Object of Area
     */
    public Area getAreaById(int areaId) {
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
                area.setEmergencyPoint(rs.getBoolean(5));
                return area;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Get All the Areas in the city.
     *
     * @return list of all the area
     */
    public List<Area> getAllArea() {
        List<Area> areas = new ArrayList<>();
        String query = "SELECT * FROM Area";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Area area = new Area();
                area.setId(rs.getInt(1));
                area.setName(rs.getString(2));
                area.setLatitude(rs.getDouble(3));
                area.setLongitude(rs.getDouble(4));
                area.setEmergencyPoint(rs.getBoolean(5));
                areas.add(area);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return areas;
    }

    /**
     * Update area name and Emergency point.
     *
     * @param area Object of Area
     * @return true if Area is updated
     */
    public boolean updateArea(Area area) {
        String query = "UPDATE Area SET name = ?, isEmergencyPoint = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, area.getName());
            stmt.setBoolean(2, area.isEmergencyPoint());
            stmt.setInt(3, area.getAreaId());
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * To Delete Area by id.
     *
     * @param areaId area id
     * @return true if Area is Deleted
     */
    public boolean deleteArea(int areaId) {
        String query = "DELETE FROM Area WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, areaId);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Get list of Areas inside Area given by user in the city.
     *
     * @param minLat Minimum Latitude
     * @param maxLat Maximum Latitude
     * @param minLon Minimum Longitude
     * @param maxLon Maximum Longitude
     * @return list of Area inside the area
     */
    public List<Area> getAreaInArea(double minLat, double maxLat, double minLon, double maxLon) {
        List<Area> areas = new ArrayList<>();
        String query = "SELECT * FROM Area WHERE Latitude between " + minLat + " and " + maxLat + " AND Longitude between " + minLon + " and " + maxLon + " ORDER BY Id";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Area area = new Area();
                area.setId(rs.getInt(1));
                area.setName(rs.getString(2));
                area.setLatitude(rs.getDouble(3));
                area.setLongitude(rs.getDouble(4));
                area.setEmergencyPoint(rs.getBoolean(5));
                areas.add(area);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return areas;
    }
}
