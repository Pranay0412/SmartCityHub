package DataBase;

import Model.Ticket;

import java.sql.*;
import java.io.*;

public class TicketDAO {
    private Connection connection = DataBaseManager.connection;

    public TicketDAO() {
        try {
            DataBaseManager.getConnection();
            connection.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Add a new Ticket.
     *
     * @param ticket Object of Ticket
     * @return true if new ticket is added
     */
    public boolean addTicket(Ticket ticket) {
        String query = "INSERT INTO ticket (UserID, RouteId, IsBusTransport, IsMetroTransport, Time, TotalBill, Distance) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, ticket.getUserId());
            stmt.setInt(2, ticket.getRouteId());
            stmt.setBoolean(3, ticket.isBusTransport());
            stmt.setBoolean(4, ticket.isMetroTransport());
            stmt.setTime(5, ticket.getTime());
            stmt.setDouble(6, ticket.getTotalBill());
            stmt.setDouble(7, ticket.getDistance());

            System.out.println("Ticket pending confirmation: " + ticket.getId());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * To confirm Ticket by User.
     *
     * @param ticketId ticket id
     * @throws SQLException for connection
     * @throws IOException  for generate bill
     */
    void commitTicket(int ticketId) throws SQLException, IOException {
        connection.commit();
        generateBill(ticketId);
        System.out.println("Ticket confirmed and saved: " + ticketId);
    }

    /**
     * To cancel Ticket by User.
     *
     * @param ticketId ticket id
     * @throws SQLException for connection
     */
    void rollbackTicket(int ticketId) throws SQLException {
        connection.rollback();
        System.out.println("Transaction rolled back, ticket cancelled: " + ticketId);
    }

    /**
     * To generate bill in text file
     *
     * @param ticketId Ticket id
     * @throws SQLException for connection
     * @throws IOException  for Buffered Writer
     */
    public void generateBill(int ticketId) throws SQLException, IOException {
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM ticket WHERE Id = ?");
        stmt.setInt(1, ticketId);
        ResultSet rs = stmt.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();

        StringBuilder bill = new StringBuilder("=== TICKET BILL ===\n");
        while (rs.next()) {
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                bill.append(rsmd.getColumnName(i)).append(": ").append(rs.getString(i)).append("\n");
            }
        }

        String filename = "bill_" + ticketId + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(bill.toString());
        }

        System.out.println("Bill generated: " + filename);
    }

    /**
     * To search Ticket by route and user.
     *
     * @param routeId route id
     * @param userId  user id
     * @throws SQLException for connection
     */
    public void searchTickets(int routeId, int userId) throws SQLException {
        String sql = "SELECT * FROM ticket WHERE RouteId = ? OR UserId = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, routeId);
        stmt.setInt(2, userId);

        ResultSet rs = stmt.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();

        boolean found = false;
        while (rs.next()) {
            found = true;
            System.out.println("---- TICKET FOUND ----");
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.println(rsmd.getColumnName(i) + ": " + rs.getString(i));
            }
        }

        if (!found) {
            System.out.println("No tickets found for route '" + routeId + "' or user '" + userId + "'.");
        }
    }
}
