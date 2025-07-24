package DataBase;

import Model.Feedback;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAO {
    private Connection connection = DataBaseManager.connection;

    public FeedbackDAO() {
        try {
            DataBaseManager.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * To Submit Feedback on database.
     *
     * @param fb Object of feedback
     * @return true if feedback is added
     */
    public boolean submitFeedback(Feedback fb) {
        String query = "INSERT INTO feedback (UserId, PlaceName, Comments, Rating) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, fb.getUserId());
            stmt.setString(2, fb.getPlaceName());
            stmt.setString(3, fb.getComments());
            stmt.setInt(4, fb.getRating());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * For Reviewing Latest 10 Feedbacks
     *
     * @return list of feedbacks
     */
    public List<Feedback> reviewLatestFeedback() {
        List<Feedback> feedbacks = new ArrayList<>();
        String query = "SELECT * FROM Feedback LIMIT 10";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Feedback fb = new Feedback();
                fb.setId(rs.getInt(1));
                fb.setUserId(rs.getInt(2));
                fb.setPlaceName(rs.getString(3));
                fb.setComments(rs.getString(4));
                fb.setRating(rs.getInt(5));
                feedbacks.add(fb);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedbacks;
    }
}
