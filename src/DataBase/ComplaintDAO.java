package DataBase;

import DataStructure.CustomQueue;
import Model.Complaint;

import java.sql.*;

public class ComplaintDAO {
    private CustomQueue<Complaint> complaintQueue = new CustomQueue<>();
    private Connection connection = DataBaseManager.connection;

    public ComplaintDAO() {
        try {
            DataBaseManager.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * To Register Complaint.
     *
     * @param c Object of Complaint
     * @return true if complaint is filed
     */
    public boolean fileComplaint(Complaint c) {
        String query = "INSERT INTO complaint (Department, UserId, Issue, Status) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            complaintQueue.enqueue(c);
            stmt.setString(1, c.getDepartment());
            stmt.setInt(2, c.getUserId());
            stmt.setString(3, c.getIssue());
            stmt.setBoolean(4, c.getStatus());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * To solve complaint.
     */
    public void resolveNextComplaint() {
        if (!complaintQueue.isEmpty()) {
            Complaint c = complaintQueue.dequeue();
            System.out.println("Resolving complaint:");
            System.out.println("Department: " + c.getDepartment());
            System.out.println("User: " + c.getUserId());
            System.out.println("Issue: " + c.getIssue());
            c.setStatus(true);
        } else {
            System.out.println("No complaints to resolve.");
        }
    }
}
