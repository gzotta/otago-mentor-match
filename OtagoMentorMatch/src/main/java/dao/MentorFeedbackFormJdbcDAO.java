package dao;

import domain.MentorFeedbackForm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author James Pettitt
 */
public class MentorFeedbackFormJdbcDAO {

    private String databaseURI = DbConnection.getDefaultConnectionUri();

    // default constructor.
    public MentorFeedbackFormJdbcDAO() {}

    // constructor that intialises the URI.
    public MentorFeedbackFormJdbcDAO(String databaseURI) {
        this.databaseURI = databaseURI;
    }

    // method to save Feedback Form.
    public void saveMentorFeedbackForm(MentorFeedbackForm feedbackForm) {
        String sql = "INSERT INTO mentor_feedback_form (finding_omm, enough_time_to_establish_relationship, describe_sessions, active_listening_rating, feedback_rating, trust_rating, achieve_goal_rating, developing_strategies_rating, motivation_rating, working_goals_rating, suitable_match,  recommendation, potential_improvements, time_contributed,  continue_relationship, join_next_intake,  testimonial, takeaways, mentor_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (
                // get connection to database.
                Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement.
                PreparedStatement stmt = dbCon.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

                // copy the data from the MentorFeedbackForm domain object into the SQL parameters.
                stmt.setString(1, feedbackForm.getFindingOMM());
                stmt.setString(2, feedbackForm.getEnoughTimeToEstablishRelationship());
                stmt.setString(3, feedbackForm.getDescribeSessions());
                stmt.setString(4, feedbackForm.getActiveListeningRating());
	            stmt.setString(5, feedbackForm.getFeedbackRating());
	            stmt.setString(6, feedbackForm.getTrustRating());
	            stmt.setString(7, feedbackForm.getAchieveGoalRating());
	            stmt.setString(8, feedbackForm.getDevelopingStrategiesRating());
	            stmt.setString(9, feedbackForm.getMotivationRating());
	            stmt.setString(10, feedbackForm.getWorkingGoalsRating());
	            stmt.setString(11, feedbackForm.getSuitableMatch());
	            stmt.setBoolean(12, feedbackForm.getRecommendation());
	            stmt.setString(13, feedbackForm.getPotentialImprovements());
                stmt.setString(14, feedbackForm.getTimeContributed());
                stmt.setBoolean(15, feedbackForm.getContinueRelationship());
                stmt.setString(16, feedbackForm.getJoinNextIntake());
                stmt.setBoolean(17, feedbackForm.getTestimonial());
                stmt.setString(18, feedbackForm.getTakeaways());
                
	            stmt.setInt(19, feedbackForm.getMentorId());
	            stmt.executeUpdate(); // execute the statement.
            

	            // getting generated keys and adding it to domain.
                Integer id = null;
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    id = rs.getInt(1);
                } else {
                    throw new DAOException("Problem getting generated MentorFeedbackForm ID");
                }

                feedbackForm.setMentorFeedbackFormId(id);
            
            } catch (SQLException ex) {  // we are forced to catch SQLException.
                // don't let the SQLException leak from our DAO encapsulation.
                throw new DAOException(ex.getMessage(), ex);
            }
        }//end of method saveMentorFeedbackForm.


    // method to get MentorFeeback by formId.
    // support method only - used by validateCredentials() below.
    public MentorFeedbackForm getFormById(Integer formId) {
        String sql = "SELECT * FROM mentor_feedback_form WHERE mentor_feedback_form_id = ?";

        try (
            // get a connection to the database.
            Connection dbCon = DbConnection.getConnection(databaseURI);
            // create the statement.
            PreparedStatement stmt = dbCon.prepareStatement(sql);) {
                // copy the data from the Mentor domain object into the SQL parameters.
                stmt.setInt(1, formId);
                // execute the query.
                ResultSet rs = stmt.executeQuery();
            
                if (rs.next()) {
                    // get the data out of the query.
                    Integer mentorFeedbackFormId = rs.getInt("mentor_feedback_form_id");
                    String findingOMM = rs.getString("finding_omm");
                    String enoughTimeToEstablishRelationship = rs.getString("enough_time_to_establish_relationship");
                    String describeSessions = rs.getString("describe_sessions");
                    String activeListeningRating = rs.getString("active_listening_rating");
                    String feedbackRating = rs.getString("feedback_rating");
                    String trustRating  = rs.getString("trust_rating");
                    String achieveGoalRating = rs.getString("achieve_goal_rating");
                    String developingStrategiesRating = rs.getString("developing_strategies_rating");
                    String motivationRating = rs.getString("motivation_rating");
                    String workingGoalsRating = rs.getString("working_goals_rating");
                    String suitableMatch = rs.getString("suitable_match");
                    boolean recommendation = rs.getBoolean("recommendation");
                    String potentialImprovements = rs.getString("potential_improvements");
                    String timeContributed = rs.getString("time_contributed");
                    boolean continueRelationship = rs.getBoolean("continue_relationship");
                    String joinNextIntake = rs.getString("join_next_intake");
                    boolean testimonial = rs.getBoolean("testimonial");
                    String takeaways = rs.getString("takeaways");
                    Integer mentorId = rs.getInt("mentor_id");
                    
                    // use the data to create a MentorFeedbackForm object.
                    MentorFeedbackForm feedbackForm = new MentorFeedbackForm();
                    feedbackForm.setMentorFeedbackFormId(mentorFeedbackFormId);
                    feedbackForm.setFindingOMM(findingOMM);
                    feedbackForm.setEnoughTimeToEstablishRelationship(enoughTimeToEstablishRelationship);
                    feedbackForm.setDescribeSessions(describeSessions);
                    feedbackForm.setActiveListeningRating(activeListeningRating);
                    feedbackForm.setFeedbackRating(feedbackRating);
                    feedbackForm.setTrustRating(trustRating);
                    feedbackForm.setAchieveGoalRating(achieveGoalRating);
                    feedbackForm.setDevelopingStrategiesRating(developingStrategiesRating);
                    feedbackForm.setMotivationRating(motivationRating);
                    feedbackForm.setWorkingGoalsRating(workingGoalsRating);
                    feedbackForm.setSuitableMatch(suitableMatch);
                    feedbackForm.setRecommendation(recommendation);
                    feedbackForm.setPotentialImprovements(potentialImprovements);
                    feedbackForm.setTimeContributed(timeContributed);
                    feedbackForm.setContinueRelationship(continueRelationship);
                    feedbackForm.setJoinNextIntake(joinNextIntake);
                    feedbackForm.setTestimonial(testimonial);
                    feedbackForm.setTakeaways(takeaways);
                    feedbackForm.setMentorId(mentorId);
                    
                    return feedbackForm;
                } else {
                    return null;
                }
            } catch (SQLException ex) {  // we are forced to catch SQLException.
                // don't let the SQLException leak from our DAO encapsulation.
                throw new DAOException(ex.getMessage(), ex);
            }
        }// end of method getFormById.
        //Get All mentor Feedback
        public Collection<MentorFeedbackForm> getMentorFeedbackForms() {

            String sql = "SELECT * FROM mentor_feedback_form";
            try (
                    // get connection to database.
                    Connection dbCon = DbConnection.getConnection(databaseURI);
                    // create the statement.
                    PreparedStatement stmt = dbCon.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
                ResultSet rs = stmt.executeQuery(); // execute the query
        
                List<MentorFeedbackForm> feedbackForms = new ArrayList<>(); // using list to preserve data order
        
                // iterate through query results
                while (rs.next()) {
        
                    Integer mentorFeedbackFormId = rs.getInt("mentor_feedback_form_id");
                    String findingOMM = rs.getString("finding_omm");
                    String enoughTimeToEstablishRelationship = rs.getString("enough_time_to_establish_relationship");
                    String describeSessions = rs.getString("describe_sessions");
                    String activeListeningRating = rs.getString("active_listening_rating");
                    String feedbackRating = rs.getString("feedback_rating");
                    String trustRating  = rs.getString("trust_rating");
                    String achieveGoalRating = rs.getString("achieve_goal_rating");
                    String developingStrategiesRating = rs.getString("developing_strategies_rating");
                    String motivationRating = rs.getString("motivation_rating");
                    String workingGoalsRating = rs.getString("working_goals_rating");
                    String suitableMatch = rs.getString("suitable_match");
                    boolean recommendation = rs.getBoolean("recommendation");
                    String potentialImprovements = rs.getString("potential_improvements");
                    String timeContributed = rs.getString("time_contributed");
                    boolean continueRelationship = rs.getBoolean("continue_relationship");
                    String joinNextIntake = rs.getString("join_next_intake");
                    boolean testimonial = rs.getBoolean("testimonial");
                    String takeaways = rs.getString("takeaways");
                    Integer mentorId = rs.getInt("mentor_id");
                    
                    // use the data to create a MentorFeedbackForm object.
                    MentorFeedbackForm feedbackForm = new MentorFeedbackForm();
                    feedbackForm.setMentorFeedbackFormId(mentorFeedbackFormId);
                    feedbackForm.setFindingOMM(findingOMM);
                    feedbackForm.setEnoughTimeToEstablishRelationship(enoughTimeToEstablishRelationship);
                    feedbackForm.setDescribeSessions(describeSessions);
                    feedbackForm.setActiveListeningRating(activeListeningRating);
                    feedbackForm.setFeedbackRating(feedbackRating);
                    feedbackForm.setTrustRating(trustRating);
                    feedbackForm.setAchieveGoalRating(achieveGoalRating);
                    feedbackForm.setDevelopingStrategiesRating(developingStrategiesRating);
                    feedbackForm.setMotivationRating(motivationRating);
                    feedbackForm.setWorkingGoalsRating(workingGoalsRating);
                    feedbackForm.setSuitableMatch(suitableMatch);
                    feedbackForm.setRecommendation(recommendation);
                    feedbackForm.setPotentialImprovements(potentialImprovements);
                    feedbackForm.setTimeContributed(timeContributed);
                    feedbackForm.setContinueRelationship(continueRelationship);
                    feedbackForm.setJoinNextIntake(joinNextIntake);
                    feedbackForm.setTestimonial(testimonial);
                    feedbackForm.setTakeaways(takeaways);
                    feedbackForm.setMentorId(mentorId);
                    
        
                    feedbackForms.add(feedbackForm); // put it in the collection
                }
        
                return feedbackForms;
        
            } catch (SQLException ex) {
                throw new DAOException(ex.getMessage(), ex);
            }
        }
    
    // method to delete MentorFeedbackForm.
    public void removeMentorFeedbackForm(MentorFeedbackForm feedbackForm) {
        String sql = "DELETE FROM mentor_feedback_form WHERE mentor_feedback_form_id = ?";
        
        try (
            // get connection to database.
            Connection dbCon = DbConnection.getConnection(databaseURI);
            // create the statement.
            PreparedStatement stmt = dbCon.prepareStatement(sql);) {
                // copy the data from the Mentor domain object into the SQL parameters.
                stmt.setInt(1, feedbackForm.getMentorFeedbackFormId());
                stmt.executeUpdate(); // execute the statement
            
            } catch (SQLException ex) {  // we are forced to catch SQLException
                // don't let the SQLException leak from our DAO encapsulation
                throw new DAOException(ex.getMessage(), ex);
            }
        }// end of method removeMentorFeedbackForm.

}// end of MentorFeedbackFormJdbcDAO class.