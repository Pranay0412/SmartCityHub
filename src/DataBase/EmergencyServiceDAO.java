package DataBase;

import Model.EmergencyService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmergencyServiceDAO {
    private Connection connection = DataBaseManager.connection;

    public EmergencyServiceDAO() {
        try {
            DataBaseManager.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean addEmergencyService(EmergencyService service) {
        String query = "INSERT INTO EmergencyService (Name, Type, AreaId, ContactNumber) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, service.getName());
            stmt.setString(2, service.getType());
            stmt.setInt(3, service.getAreaId());
            stmt.setLong(4, service.getContactNumber());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public EmergencyService getEmergencyServiceByID(int serviceId) {
        String query = "SELECT * FROM EmergencyService WHERE Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, serviceId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                EmergencyService service = new EmergencyService();
                service.setId(rs.getInt(1));
                service.setName(rs.getString(2));
                service.setType(rs.getString(3));
                service.setAreaId(rs.getInt(4));
                service.setContactNumber(rs.getLong(5));
                return service;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public EmergencyService getEmergencyServiceByType(String type) {
        String query = "SELECT * FROM EmergencyService WHERE Type = ? LIMIT 1";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, type);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                EmergencyService service = new EmergencyService();
                service.setId(rs.getInt(1));
                service.setName(rs.getString(2));
                service.setType(rs.getString(3));
                service.setAreaId(rs.getInt(4));
                service.setContactNumber(rs.getLong(5));
                return service;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<EmergencyService> getAllEmergencyService() {
        List<EmergencyService> services = new ArrayList<>();
        String query = "SELECT * FROM EmergencyService";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                EmergencyService service = new EmergencyService();
                service.setId(rs.getInt(1));
                service.setName(rs.getString(2));
                service.setType(rs.getString(3));
                service.setAreaId(rs.getInt(4));
                service.setContactNumber(rs.getLong(5));
                services.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }
}
