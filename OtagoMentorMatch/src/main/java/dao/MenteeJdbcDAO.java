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
    public MenteeJdbcDAO() {
    }

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


    // method to get Mentee by first name.
    // support method only - used by validateCredentials() below.
    public Mentee getMenteeByFname(String fname) {
        String sql = "SELECT * FROM mentee WHERE fname = ?";

        try (
            // get a connection to the database.
            Connection dbCon = DbConnection.getConnection(databaseURI);
            // create the statement.
            PreparedStatement stmt = dbCon.prepareStatement(sql);) {
                // copy the data from the Mentee domain object into the SQL parameters.
                stmt.setString(1, fname);
                // execute the query.
                ResultSet rs = stmt.executeQuery();
            
                if (rs.next()) {
                    // get the data out of the query.
                    int menteeId = rs.getInt("mentee_id");
                    String password = rs.getString("password");
                    String lname = rs.getString("lname");
                    String phone_number = rs.getString("phone_number");
                    String email  = rs.getString("email");
                    String year_of_study = rs.getString("year_of_study");
                    String motivation_for_joining_omm = rs.getString("motivation_for_joining_omm");
                    String industry_of_interest = rs.getString("industry_of_interest");
                    String personal_interests = rs.getString("personal_interests");
                    String how_find_omm = rs.getString("how_find_omm");
                    String random_matching = rs.getString("random_matching");
                    String bio = rs.getString("bio");
                    
                    // use the data to create a Mentee object.
                    Mentee mentee = new Mwentee();
                    mentee.setMenteeId();
                    mentee.setMenteePassword();
                    mentee.setLname();
                    mentee.setPhoneNumber();
                    mentee.setEmail();
                    mentee.setYearOfStudy();
                    mentee.setMotivationForJoiningOMM();
                    mentee.setIndustryOfInterest();
                    mentee.setLearningMethod();
                    mentee.setPersonalInterests();
                    mentee.setHowFindOMM();
                    mentee.setRandomMatching();
                    mentee.setBio();
                    
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
    // accesses getMenteeByFname() above.
    public Boolean validateCredentials(String fname, String password) {
        Mentee mentee = getMenteeByFname(fname);
        if ((mentee != null) && (mentee.getPassword().equals(password))) {
            return true;
        } else {
            return false;
        }
    }// end of method to sign users in.


    
    // method to delete Mentee.
    public void removeMentee(Mentee mentee) {
        String sql = "DELETE FROM mentee WHERE fname = ?";
        
        try (
            // get connection to database.
            Connection dbCon = DbConnection.getConnection(databaseURI);
            // create the statement.
            PreparedStatement stmt = dbCon.prepareStatement(sql);) {
                // copy the data from the Mentee domain object into the SQL parameters.
                stmt.setString(1, mentee.getFname());
                stmt.executeUpdate(); // execute the statement
            
            } catch (SQLException ex) {  // we are forced to catch SQLException
                // don't let the SQLException leak from our DAO encapsulation
                throw new DAOException(ex.getMessage(), ex);
            }
        }// end of method to delete Mentee.

}// end of MenteeJdbcDAO class.
