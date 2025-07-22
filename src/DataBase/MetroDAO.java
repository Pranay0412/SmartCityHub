package DataBase;

import Model.Metro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MetroDAO {
        private Connection connection = DataBaseManager.connection;

        public MetroDAO() {
            try {
                DataBaseManager.getConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public boolean addMetro(Metro metro) {
        String query = "INSERT INTO Metro (Id, TrainName, Capacity, CurrentRouteID, CurrentAreaID) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, metro.getId());
            stmt.setString(2, metro.getTrainName());
            stmt.setInt(3, metro.getCapacity());
            stmt.setInt(4, metro.getCurrentRouteID());
            stmt.setInt(5, metro.getCurrentAreaID());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Metro getMetroByID(int metroId) {
        String query = "SELECT * FROM Metro WHERE Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, metroId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Metro metro = new Metro();
                metro.setId(rs.getInt(1));
                metro.setTrainName(rs.getString(2));
                metro.setCapacity(rs.getInt(3));
                metro.setCurrentRouteID(rs.getInt(4));
                metro.setCurrentAreaID(rs.getInt(5));
                return metro;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Metro> getAllMetros() {
        List<Metro> metros = new ArrayList<>();
        String query = "SELECT * FROM Metro";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Metro metro = new Metro();
                metro.setId(rs.getInt(1));
                metro.setTrainName(rs.getString(2));
                metro.setCapacity(rs.getInt(3));
                metro.setCurrentRouteID(rs.getInt(4));
                metro.setCurrentAreaID(rs.getInt(5));
                metros.add(metro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return metros;
    }

    public boolean updateMetroLocation(int metroId, int areaID) {
        String query = "UPDATE Metro SET CurrentAreaID = ? WHERE Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, areaID);
            stmt.setInt(2, metroId);
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateMetroRoute(int metroId, int routeId) {
        String query = "UPDATE Bus SET CurrentRouteId = ? WHERE Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, routeId);
            stmt.setInt(2, metroId);
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
