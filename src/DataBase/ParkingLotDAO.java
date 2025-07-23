package DataBase;

import Model.ParkingLot;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParkingLotDAO {
    private Connection connection = DataBaseManager.connection;

    public ParkingLotDAO() {
        try {
            DataBaseManager.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Add a new Parking Lot.
     *
     * @param lot Object of Parking Lot
     * @return true if lot is added
     */
    public boolean addParkingLot(ParkingLot lot) {
        String query = "INSERT INTO ParkingLot (Name, Capacity, CurrentOccupancy, AreaId) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, lot.getName());
            stmt.setInt(2, lot.getCapacity());
            stmt.setInt(3, lot.getCurrentOccupancy());
            stmt.setInt(4, lot.getAreaId());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Get Parking Lot by id.
     *
     * @param lotId Lot id
     * @return Object of Parking lot
     */
    public ParkingLot getParkingLotById(int lotId) {
        String query = "SELECT * FROM ParkingLot WHERE Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, lotId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                ParkingLot lot = new ParkingLot();
                lot.setId(rs.getInt(1));
                lot.setName(rs.getString(2));
                lot.setCapacity(rs.getInt(3));
                lot.setCurrentOccupancy(rs.getInt(4));
                lot.setAreaId(rs.getInt(5));
                return lot;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Get all the Parking Lots.
     *
     * @return list of Parking lots
     */
    public List<ParkingLot> getAllParkingLots() {
        List<ParkingLot> lots = new ArrayList<>();
        String query = "SELECT * FROM ParkingLot";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                ParkingLot lot = new ParkingLot();
                lot.setId(rs.getInt(1));
                lot.setName(rs.getString(2));
                lot.setCapacity(rs.getInt(3));
                lot.setCurrentOccupancy(rs.getInt(4));
                lot.setAreaId(rs.getInt(5));
                lots.add(lot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lots;
    }

    /**
     * Update Parking occupancy by id.
     *
     * @param lotId        Lot id
     * @param newOccupancy Updated occupancy
     * @return true if Parking Lot is Updated
     */
    public boolean updateParkingOccupancy(int lotId, int newOccupancy) {
        String query = "UPDATE ParkingLot SET CurrentOccupancy = ? WHERE Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, newOccupancy);
            stmt.setInt(2, lotId);
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Get all the Parking Lots which have slots to Park.
     *
     * @return list of Parking Lots
     */
    public List<ParkingLot> getAvailableParkingLots() {
        List<ParkingLot> availableLots = new ArrayList<>();
        String query = "SELECT * FROM ParkingLot WHERE CurrentOccupancy < Capacity";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                ParkingLot lot = new ParkingLot();
                lot.setId(rs.getInt(1));
                lot.setName(rs.getString(2));
                lot.setCapacity(rs.getInt(3));
                lot.setCurrentOccupancy(rs.getInt(4));
                lot.setAreaId(rs.getInt(5));
                availableLots.add(lot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return availableLots;
    }
}
