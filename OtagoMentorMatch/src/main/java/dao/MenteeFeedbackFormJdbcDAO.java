package dao;

import domain.MenteeFeedbackForm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author George Zotta
 */
public class MenteeFeedbackFormJdbcDAO {

    private String databaseURI = DbConnection.getDefaultConnectionUri();

    // default constructor.
    public MenteeFeedbackFormJdbcDAO() {
    }

    // constructor that intialises the URI.
    public MenteeFeedbackFormJdbcDAO(String databaseURI) {
        this.databaseURI = databaseURI;
    }

    // method to save Feedback Form.
    public void saveMenteeFeedbackForm(MenteeFeedbackForm feedbackForm) {
        String sql = "INSERT INTO mentee_feedback_form (communication_platform, finding_omm, session_quality, quality_of_match, recommendation, active_listening_rating, feedback_rating, trust_rating, achieve_goal_rating, developing_strategies_rating, motivation_rating, working_load_rating, programme_improvements, time_contributed, continue_relationship, testimonial, other_comments, takeaways, match_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (
                // get connection to database.
                Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement.
                PreparedStatement stmt = dbCon.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

                // copy the data from the MenteeFeedbackForm domain object into the SQL parameters.
                stmt.setString(1, feedbackForm.getCommunicationPlatform());
                stmt.setString(2, feedbackForm.getFindingOMM());
                stmt.setString(3, feedbackForm.getSessionQuality());
                stmt.setString(4, feedbackForm.getQualityOfMatch());
	            stmt.setBoolean(5, feedbackForm.getRecommendation());
	            stmt.setString(6, feedbackForm.getAchieveGoalRating());
	            stmt.setString(7, feedbackForm.getFeedbackRating());
	            stmt.setString(8, feedbackForm.getTrustRating());
	            stmt.setString(9, feedbackForm.getAchieveGoalRating());
	            stmt.setString(10, feedbackForm.getDevelopingStrategiesRating());
	            stmt.setString(11, feedbackForm.getMotivationRating());
	            stmt.setString(12, feedbackForm.getWorkingLoadRating());
	            stmt.setString(13, feedbackForm.getProgrammeImprovements());
                stmt.setString(14, feedbackForm.getTimeContributed());
                stmt.setBoolean(15, feedbackForm.getContinueRelationship());
                stmt.setBoolean(16, feedbackForm.getTestimonial());
                stmt.setString(17, feedbackForm.getOtherComments());
                stmt.setString(18, feedbackForm.getTakeaways());
                stmt.setInt(19, feedbackForm.getMatchId());
	   
	            stmt.executeUpdate(); // execute the statement.
            

	            // getting generated keys and adding it to domain.
                Integer id = null;
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    id = rs.getInt(1);
                } else {
                    throw new DAOException("Problem getting generated MenteeFeedbackForm ID");
                }

                feedbackForm.setMenteeFeedbackFormId(id);
            
            } catch (SQLException ex) {  // we are forced to catch SQLException.
                // don't let the SQLException leak from our DAO encapsulation.
                throw new DAOException(ex.getMessage(), ex);
            }
        }//end of method saveMenteeFeedbackForm.


    // method to get MenteeFeeback by formId.
    // support method only - used by validateCredentials() below.
    public MenteeFeedbackForm getFormById(Integer formId) {
        String sql = "SELECT * FROM mentee_feedback_form WHERE mentee_feedback_form_id = ?";

        try (
            // get a connection to the database.
            Connection dbCon = DbConnection.getConnection(databaseURI);
            // create the statement.
            PreparedStatement stmt = dbCon.prepareStatement(sql);) {
                // copy the data from the Mentee domain object into the SQL parameters.
                stmt.setInt(1, formId);
                // execute the query.
                ResultSet rs = stmt.executeQuery();
            
                if (rs.next()) {
                    // get the data out of the query.
                    Integer menteeFeedbackFormId = rs.getInt("mentee_feedback_form_id");
                    String communicationPlatform = rs.getString("communication_platform");
                    String findingOMM = rs.getString("finding_omm");
                    String sessionQuality = rs.getString("session_quality");
                    String qualityOfMatch = rs.getString("quality_of_match");
                    boolean recommendation = rs.getBoolean("recommendation");
                    String activeListeningRating  = rs.getString("active_listening_rating");
                    String feedbackRating = rs.getString("feedback_rating");
                    String trustRating = rs.getString("trust_rating");
                    String achieveGoalRating = rs.getString("achieve_goal_rating");
                    String developingStrategiesRating = rs.getString("developing_strategies_rating");
                    String motivationRating = rs.getString("motivation_rating");
                    String workingLoadRating = rs.getString("working_load_rating");
                    String programmeImprovements = rs.getString("programme_improvements");
                    String timeContributed = rs.getString("time_contributed");
                    boolean continueRelationship = rs.getBoolean("continue_relationship");
                    boolean testimonial = rs.getBoolean("testimonial");
                    String otherComments = rs.getString("other_comments");
                    String takeaways = rs.getString("takeaways");
                    Integer matchId = rs.getInt("match_id");
                    
                    // use the data to create a MenteeFeedbackForm object.
                    MenteeFeedbackForm feedbackForm = new MenteeFeedbackForm();
                    feedbackForm.setMenteeFeedbackFormId(menteeFeedbackFormId);
                    feedbackForm.setCommunicationPlatform(communicationPlatform);
                    feedbackForm.setFindingOMM(findingOMM);
                    feedbackForm.setSessionQuality(sessionQuality);
                    feedbackForm.setQualityOfMatch(qualityOfMatch);
                    feedbackForm.setRecommendation(recommendation);
                    feedbackForm.setActiveListeningRating(activeListeningRating);
                    feedbackForm.setFeedbackRating(feedbackRating);
                    feedbackForm.setTrustRating(trustRating);
                    feedbackForm.setAchieveGoalRating(achieveGoalRating);
                    feedbackForm.setDevelopingStrategiesRating(developingStrategiesRating);
                    feedbackForm.setMotivationRating(motivationRating);
                    feedbackForm.setWorkingLoadRating(workingLoadRating);
                    feedbackForm.setProgrammeImprovements(programmeImprovements);
                    feedbackForm.setTimeContributed(timeContributed);
                    feedbackForm.setContinueRelationship(continueRelationship);
                    feedbackForm.setTestimonial(testimonial);
                    feedbackForm.setOtherComments(otherComments);
                    feedbackForm.setTakeaways(takeaways);
                    feedbackForm.setMatchId(matchId);
                    
                    return feedbackForm;
                } else {
                    return null;
                }
            } catch (SQLException ex) {  // we are forced to catch SQLException.
                // don't let the SQLException leak from our DAO encapsulation.
                throw new DAOException(ex.getMessage(), ex);
            }
        }// end of method getFormById.
        

    
    // method to delete MenteeFeedbackForm.
    public void removeMenteeFeedbackForm(MenteeFeedbackForm feedbackForm) {
        String sql = "DELETE FROM mentee_feedback_form WHERE mentee_feedback_form_id = ?";
        
        try (
            // get connection to database.
            Connection dbCon = DbConnection.getConnection(databaseURI);
            // create the statement.
            PreparedStatement stmt = dbCon.prepareStatement(sql);) {
                // copy the data from the Mentee domain object into the SQL parameters.
                stmt.setInt(1, feedbackForm.getMenteeFeedbackFormId());
                stmt.executeUpdate(); // execute the statement
            
            } catch (SQLException ex) {  // we are forced to catch SQLException
                // don't let the SQLException leak from our DAO encapsulation
                throw new DAOException(ex.getMessage(), ex);
            }
        }// end of method removeMenteFeedbackForm.

}// end of MenteeFeedbackFormJdbcDAO class.
