package DataBase;

import Model.Station;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StationDAO {
    private Connection connection = DataBaseManager.connection;

    public StationDAO() {
        try {
            DataBaseManager.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean addStation(Station station) {
        String query = "INSERT INTO Station (Name, AreaId, IsBusStation, IsMetroStation) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, station.getName());
            stmt.setInt(2, station.getAreaId());
            stmt.setBoolean(3, station.isBusStation());
            stmt.setBoolean(4, station.isMetroStation());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Station getStationById(int stationID) {
        String query = "SELECT * FROM Station WHERE Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, stationID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Station station = new Station();
                station.setId(rs.getInt(1));
                station.setName(rs.getString(2));
                station.setAreaId(rs.getInt(3));
                station.setBusStation(rs.getBoolean(4));
                station.setMetroStation(rs.getBoolean(5));
                return station;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Station> getAllStops() {
        List<Station> stations = new ArrayList<>();
        String query = "SELECT * FROM Station";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Station station = new Station();
                station.setId(rs.getInt(1));
                station.setName(rs.getString(2));
                station.setAreaId(rs.getInt(3));
                station.setBusStation(rs.getBoolean(4));
                station.setMetroStation(rs.getBoolean(5));
                stations.add(station);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stations;
    }

    public List<Station> getStopsByAreaId(int areaId) {
        List<Station> stations = new ArrayList<>();
        String query = "SELECT * FROM Station WHERE AreaId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, areaId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Station station = new Station();
                station.setId(rs.getInt(1));
                station.setName(rs.getString(2));
                station.setAreaId(rs.getInt(3));
                station.setBusStation(rs.getBoolean(4));
                station.setMetroStation(rs.getBoolean(5));
                stations.add(station);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stations;
    }
}
