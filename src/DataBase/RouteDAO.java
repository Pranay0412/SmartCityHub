package DataBase;

import Model.Route;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RouteDAO {
    private Connection connection = DataBaseManager.connection;

    public RouteDAO() {
        try {
            DataBaseManager.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Add a new Route.
     *
     * @param route Object of Route
     * @return true if Route is added
     */
    public boolean addRoute(Route route) {
        String query = "INSERT INTO Route (Name, IsBusRoute, IsMetroRoute) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, route.getName());
            stmt.setBoolean(2, route.isBusRoute());
            stmt.setBoolean(3, route.isMetroRoute());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Get Route by id.
     *
     * @param routeId Route id
     * @return Object of Route
     */
    public Route getRouteById(int routeId) {
        String query = "SELECT * FROM Route WHERE Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, routeId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Route route = new Route();
                route.setId(rs.getInt(1));
                route.setName(rs.getString(2));
                route.setBusRoute(rs.getBoolean(3));
                route.setMetroRoute(rs.getBoolean(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Get All the Route.
     *
     * @return list of all the Routes
     */
    public List<Route> getAllRoutes() {
        List<Route> routes = new ArrayList<>();
        String query = "SELECT * FROM Route";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Route route = new Route();
                route.setId(rs.getInt(1));
                route.setName(rs.getString(2));
                route.setBusRoute(rs.getBoolean(3));
                route.setMetroRoute(rs.getBoolean(4));
                routes.add(route);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return routes;
    }
}
