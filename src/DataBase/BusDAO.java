package DataBase;

import Model.Bus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BusDAO {
    private Connection connection = DataBaseManager.connection;

    public BusDAO() {
        try {
            DataBaseManager.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Add a new Bus.
     *
     * @param bus Object of Bus
     * @return true if Bus is added
     */
    public boolean addBus(Bus bus) {
        String query = "INSERT INTO Bus (LicensePlate, Capacity, CurrentRouteID, CurrentAreaID) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, bus.getLicensePlate());
            stmt.setInt(2, bus.getCapacity());
            stmt.setInt(3, bus.getCurrentRouteId());
            stmt.setInt(4, bus.getCurrentAreaID());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Get Bus by id.
     *
     * @param busId Bus id
     * @return Object of Bus
     */
    public Bus getBusByID(int busId) {
        String query = "SELECT * FROM Bus WHERE Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, busId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Bus bus = new Bus();
                bus.setId(rs.getInt(1));
                bus.setLicensePlate(rs.getString(2));
                bus.setCapacity(rs.getInt(3));
                bus.setCurrentRouteId(rs.getInt(4));
                bus.setCurrentAreaID(rs.getInt(5));
                return bus;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Get all The Buses.
     *
     * @return list of Buses
     */
    public List<Bus> getAllBuses() {
        List<Bus> buses = new ArrayList<>();
        String query = "SELECT * FROM Bus";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Bus bus = new Bus();
                bus.setId(rs.getInt(1));
                bus.setLicensePlate(rs.getString(2));
                bus.setCapacity(rs.getInt(3));
                bus.setCurrentRouteId(rs.getInt(4));
                bus.setCurrentAreaID(rs.getInt(5));
                buses.add(bus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buses;
    }

    /**
     * Update Bus current Location.
     *
     * @param busId  Bus is
     * @param areaID current Area id
     * @return true if Bus is Updated
     */
    public boolean updateBusLocation(int busId, int areaID) {
        String query = "UPDATE Bus SET CurrentAreaID = ? WHERE Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, areaID);
            stmt.setInt(2, busId);
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Update Bus Current Route.
     *
     * @param busId   Bus id
     * @param routeId current Route id
     * @return true if Bus is Updated
     */
    public boolean updateBusRoute(int busId, int routeId) {
        String query = "UPDATE Bus SET CurrentRouteId = ? WHERE Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, routeId);
            stmt.setInt(2, busId);
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
