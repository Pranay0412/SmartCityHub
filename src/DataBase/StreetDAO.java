package DataBase;

import Model.Street;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StreetDAO {
    private Connection connection = DataBaseManager.connection;

    public StreetDAO() {
        try {
            DataBaseManager.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean addStreet(Street street) {
        String query = "INSERT INTO Street (Id, StartAreaId, EndAreaId, Distance, IsOneWay) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, street.getId());
            stmt.setDouble(2, street.getStartAreaId());
            stmt.setDouble(3, street.getEndAreaId());
            stmt.setDouble(4, street.getDistance());
            stmt.setBoolean(5, street.isOneWay());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public Street getStreetById(int streetId) {
        String query = "SELECT * FROM Street WHERE Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, streetId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Street street = new Street();
                street.setId(rs.getInt(1));
                street.setStartAreaId(rs.getInt(2));
                street.setEndAreaId(rs.getInt(3));
                street.setDistance(rs.getDouble(4));
                street.setOneWay(rs.getBoolean(5));
                return street;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Street getStreetByAreaId(int startAreaId){
        String query = "SELECT * FROM Street WHERE areaId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, startAreaId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Street street = new Street();
                street.setId(rs.getInt(1));
                street.setStartAreaId(rs.getInt(2));
                street.setEndAreaId(rs.getInt(3));
                street.setDistance(rs.getDouble(4));
                street.setOneWay(rs.getBoolean(5));
                return street;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Street> getAllStreet() {
        List<Street> streets = new ArrayList<>();
        String query = "SELECT * FROM Street";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Street street = new Street();
                street.setId(rs.getInt(1));
                street.setStartAreaId(rs.getInt(2));
                street.setEndAreaId(rs.getInt(3));
                street.setDistance(rs.getDouble(4));
                street.setOneWay(rs.getBoolean(5));
                streets.add(street);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return streets;
    }
    public boolean updateStreet(Street street) {
        String query = "UPDATE Street SET StartAreaId = ?, EndAreaId = ?, IsOneWay = ? WHERE Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, street.getStartAreaId());
            stmt.setInt(2, street.getEndAreaId());
            stmt.setBoolean(3, street.isOneWay());
            stmt.setInt(4, street.getId());
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteStreet(int streetId) {
        String query = "DELETE FROM Street WHERE Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, streetId);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}
