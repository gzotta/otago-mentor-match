package dao;

import domain.Mentee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author George Zotta
 */
public class MenteeJdbcDAO {

    private String databaseURI = DbConnection.getDefaultConnectionUri();

    // default constructor.
    public MenteeJdbcDAO() {}

    // constructor that intialises the URI.
    public MenteeJdbcDAO(String databaseURI) {
        this.databaseURI = databaseURI;
    }

    // method to save Mentee.
    public void saveMentee(Mentee mentee) {
        String sql = "INSERT INTO mentee (password, fname, lname, phone_number, email, year_of_study, motivation_for_joining_omm, industry_of_interest, learning_method, personal_interests, how_find_omm, random_matching, bio) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (
                // get connection to database.
                Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement.
                PreparedStatement stmt = dbCon.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

                // copy the data from the Mentee domain object into the SQL parameters.
                stmt.setString(1, mentee.getMenteePassword());
                stmt.setString(2, mentee.getFname());
                stmt.setString(3, mentee.getLname());
                stmt.setString(4, mentee.getPhoneNumber());
	            stmt.setString(5, mentee.getEmail());
	            stmt.setString(6, mentee.getYearOfStudy());
	            stmt.setString(7, mentee.getMotivationForJoiningOMM());
	            stmt.setString(8, mentee.getIndustryOfInterest());
	            stmt.setString(9, mentee.getLearningMethod());
	            stmt.setString(10, mentee.getPersonalInterests());
	            stmt.setString(11, mentee.getHowFindOMM());
	            stmt.setString(12, mentee.getRandomMatching());
	            stmt.setString(13, mentee.getBio());

	   
	            stmt.executeUpdate(); // execute the statement.
            

	            // getting generated keys and adding it to domain.
                Integer Id = null;
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    Id = rs.getInt(1);
                } else {
                    throw new DAOException("Problem getting generated Mentee ID");
                }

                mentee.setMenteeId(Id);
            
            } catch (SQLException ex) {  // we are forced to catch SQLException.
                // don't let the SQLException leak from our DAO encapsulation.
                throw new DAOException(ex.getMessage(), ex);
            }
        }//end of method to save Mentee


    // method to get Mentee by email.
    // support method only - used by validateCredentials() below.
    public Mentee getMenteeByEmail(String email) {
        String sql = "SELECT * FROM mentee WHERE email = ?";

        try (
            // get a connection to the database.
            Connection dbCon = DbConnection.getConnection(databaseURI);
            // create the statement.
            PreparedStatement stmt = dbCon.prepareStatement(sql);) {
                // copy the data from the Mentee domain object into the SQL parameters.
                stmt.setString(1, email);
                // execute the query.
                ResultSet rs = stmt.executeQuery();
            
                if (rs.next()) {
                    // get the data out of the query.
                    Integer menteeId = rs.getInt("mentee_id");
                    String password = rs.getString("password");
                    String fname = rs.getString("fname");
                    String lname = rs.getString("lname");
                    String phone_number = rs.getString("phone_number");
                    String year_of_study = rs.getString("year_of_study");
                    String motivation_for_joining_omm = rs.getString("motivation_for_joining_omm");
                    String industry_of_interest = rs.getString("industry_of_interest");
                    String learning_method = rs.getString("learning_method");
                    String personal_interests = rs.getString("personal_interests");
                    String how_find_omm = rs.getString("how_find_omm");
                    String random_matching = rs.getString("random_matching");
                    String bio = rs.getString("bio");
                    
                    // use the data to create a Mentee object.
                    Mentee mentee = new Mentee();
                    mentee.setMenteeId(menteeId);
                    mentee.setMenteePassword(password);
                    mentee.setFname(fname);
                    mentee.setLname(lname);
                    mentee.setPhoneNumber(phone_number);
                    mentee.setYearOfStudy(year_of_study);
                    mentee.setMotivationForJoiningOMM(motivation_for_joining_omm);
                    mentee.setIndustryOfInterest(industry_of_interest);
                    mentee.setLearningMethod(learning_method);
                    mentee.setPersonalInterests(personal_interests);
                    mentee.setHowFindOMM(how_find_omm);
                    mentee.setRandomMatching(random_matching);
                    mentee.setBio(bio);
                    
                    return mentee;
                } else {
                    return null;
                }
            } catch (SQLException ex) {  // we are forced to catch SQLException.
                // don't let the SQLException leak from our DAO encapsulation.
                throw new DAOException(ex.getMessage(), ex);
            }
        }// end of method to get Mentee by first name.
        

    // method to sign users in.
    // accesses getMenteeByemail() above.
    public Boolean validateCredentials(String email, String password) {
        Mentee mentee = getMenteeByEmail(email);
        if ((mentee != null) && (mentee.getMenteePassword().equals(password))) {
            return true;
        } else {
            return false;
        }
    }// end of method to sign users in.


    
    // method to delete Mentee.
    public void removeMentee(Mentee mentee) {
        String sql = "DELETE FROM mentee WHERE email = ?";
        
        try (
            // get connection to database.
            Connection dbCon = DbConnection.getConnection(databaseURI);
            // create the statement.
            PreparedStatement stmt = dbCon.prepareStatement(sql);) {
                // copy the data from the Mentee domain object into the SQL parameters.
                stmt.setString(1, mentee.getEmail());
                stmt.executeUpdate(); // execute the statement
            
            } catch (SQLException ex) {  // we are forced to catch SQLException
                // don't let the SQLException leak from our DAO encapsulation
                throw new DAOException(ex.getMessage(), ex);
            }
        }// end of method to delete Mentee.

}// end of MenteeJdbcDAO class.
