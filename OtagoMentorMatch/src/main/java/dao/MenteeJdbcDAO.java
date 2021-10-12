package dao;

import domain.Mentee;
import helpers.ScryptHelper;
import auth.CredentialsValidator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/**
 *
 * @author George Zotta
 */
public class MenteeJdbcDAO implements CredentialsValidator {

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
        // get connection to database.
        Connection dbCon = DbConnection.getConnection(databaseURI);
        // SQL query to insert Mentee object into mentee table.
        String saveMenteeSql = "INSERT INTO mentee (password, fname, lname, phone_number, email, year_of_study, motivation_for_joining_omm, industry_of_interest, learning_method, personal_interests, how_find_omm, random_matching, bio) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        // SQL queery to insert email and password into user table.
        String saveUserSql = "INSERT INTO user (user_password, user_email) VALUES (?,?)";
        // This line converts the password into a hash.
        String hash = ScryptHelper.hash(mentee.getMenteePassword()).toString();

        try {
            try (

                    // Create the statement to save Mentee.
                    PreparedStatement saveMenteeStmt = dbCon.prepareStatement(saveMenteeSql,
                            Statement.RETURN_GENERATED_KEYS);
                    // Create the statement to save user.
                    PreparedStatement saveUserStmt = dbCon.prepareStatement(saveUserSql,
                            Statement.RETURN_GENERATED_KEYS);) {

                /*
                 * Since saving an Admin involves multiple statements across multiple tables we
                 * need to control the transaction ourselves to ensure the DB remains
                 * consistent. Turning off auto-commit effectively starts a new transaction.
                 */
                dbCon.setAutoCommit(false);

                //// ### Save the Mentee ### ////

                // copy the data from the Mentee domain object into the SQL parameters.
                saveMenteeStmt.setString(1, hash);
                saveMenteeStmt.setString(2, mentee.getFname());
                saveMenteeStmt.setString(3, mentee.getLname());
                saveMenteeStmt.setString(4, mentee.getPhoneNumber());
                saveMenteeStmt.setString(5, mentee.getEmail());
                saveMenteeStmt.setString(6, mentee.getYearOfStudy());
                saveMenteeStmt.setString(7, mentee.getMotivationForJoiningOMM());
                saveMenteeStmt.setString(8, mentee.getIndustryOfInterest());
                saveMenteeStmt.setString(9, mentee.getLearningMethod());
                saveMenteeStmt.setString(10, mentee.getPersonalInterests());
                saveMenteeStmt.setString(11, mentee.getHowFindOMM());
                saveMenteeStmt.setString(12, mentee.getRandomMatching());
                saveMenteeStmt.setString(13, mentee.getBio());

                saveMenteeStmt.executeUpdate(); // execute the statement.

                // getting generated keys and adding it to domain.
                Integer id = null;
                ResultSet rs = saveMenteeStmt.getGeneratedKeys();
                if (rs.next()) {
                    id = rs.getInt(1);
                } else {
                    throw new DAOException("Problem getting generated Mentee ID");
                }

                mentee.setMenteeId(id);

                //// ### Save the User ### ///

                // Copy the data from the amdmin domain object into the SQL parameters.
                saveUserStmt.setString(1, hash);
                saveUserStmt.setString(2, mentee.getEmail());

                saveUserStmt.executeUpdate(); // execute the statement.

                // Commit the transacion
                dbCon.setAutoCommit(true);

            }
        } catch (SQLException ex) { // we are forced to catch SQLException.
            try {
                // Something went wrong so rollback.
                dbCon.rollback();
                // Turn auto-commit back on.
                dbCon.setAutoCommit(true);
                // And throw an exception to tell the user something bad happened.
                throw new DAOException(ex.getMessage(), ex);
            } catch (SQLException ex1) {
                throw new DAOException(ex1.getMessage(), ex1);
            }
        } finally {
            try {
                dbCon.close();
            } catch (SQLException ex) {
                Logger.getLogger(MenteeJdbcDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }// end of method to save Mentee

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
        } catch (SQLException ex) { // we are forced to catch SQLException.
            // don't let the SQLException leak from our DAO encapsulation.
            throw new DAOException(ex.getMessage(), ex);
        }
    }// end of method to get Mentee by first name.

// Method to GET all Mentors.
public Collection<Mentee> getMentees() {

    String sql = "select * from Mentee";
    try (
            // get connection to database.
            Connection dbCon = DbConnection.getConnection(databaseURI);
            // create the statement.
            PreparedStatement stmt = dbCon.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
        ResultSet rs = stmt.executeQuery(); // execute the query

        List<Mentee> mentees = new ArrayList<>(); // using list to preserve data order

        // iterate through query results
        while (rs.next()) {

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
             String email = rs.getString("email");

             // use the data to create a Mentee object.
             Mentee mentee = new Mentee();
             mentee.setMenteeId(menteeId);
             mentee.setMenteePassword(password);
             mentee.setFname(fname);
             mentee.setLname(lname);
             mentee.setEmail(email);
             mentee.setPhoneNumber(phone_number);
             mentee.setYearOfStudy(year_of_study);
             mentee.setMotivationForJoiningOMM(motivation_for_joining_omm);
             mentee.setIndustryOfInterest(industry_of_interest);
             mentee.setLearningMethod(learning_method);
             mentee.setPersonalInterests(personal_interests);
             mentee.setHowFindOMM(how_find_omm);
             mentee.setRandomMatching(random_matching);
             mentee.setBio(bio);

          

            mentees.add(mentee); // put it in the collection
        }

        return mentees;

    } catch (SQLException ex) {
        throw new DAOException(ex.getMessage(), ex);
    }
}




    // Method to validate credentials for Mentees.
    @Override
    public Boolean validateCredentials(String email, String password) {

        try (

                // get connection to database.
                Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement.
                PreparedStatement stmt = dbCon.prepareStatement("select password from mentee where email = ?");) {

            // copy the data from the Mentee domain object into the SQL parameters.
            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery(); // execute query.

            if (rs.next()) {
                String hash = rs.getString("password");

                // check that the password matches the hash
                return ScryptHelper.check(hash, password);
            } else {
                // no matching email
                return false;
            }

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }// end of method to validate Mentees.

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

        } catch (SQLException ex) { // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }// end of method to delete Mentee.

}// end of MenteeJdbcDAO class.
