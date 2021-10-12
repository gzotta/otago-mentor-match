package dao;

import domain.Match;
import domain.MatchDisplay;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author James Pettitt
 */
public class MatchJdbcDAO {
    private String databaseURI = DbConnection.getDefaultConnectionUri();

    public MatchJdbcDAO() {
    }

    // constructor that intialises the URI.
    public MatchJdbcDAO(String databaseURI) {
        this.databaseURI = databaseURI;
    }

    // method to save Match.
    public void saveMatch(Match match) {
        String sql = "INSERT INTO match_table (date,  mentor_id,  mentee_id) VALUES (?, ?, ?)";

        try (Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement.
                PreparedStatement stmt = dbCon.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            // copy the data from the Match object into the SQL parameters.
            stmt.setString(1, match.getDate());
            stmt.setInt(2, match.getMentorId());
            stmt.setInt(3, match.getMenteeId());

            stmt.executeUpdate();

            // getting generated keys and adding it to domain.
            Integer id = null;
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            } else {
                throw new DAOException("Problem getting generated Match ID");
            }

            match.setMatchId(id);

        } catch (SQLException ex) { // we are forced to catch SQLException.
            // don't let the SQLException leak from our DAO encapsulation.
            throw new DAOException(ex.getMessage(), ex);
        }
    }// end saveMatch method.

    // Method to get all Matches.
    public List<MatchDisplay> getAllMatches() {
        String sql = "SELECT match_table.match_id, match_table.mentor_id, mentor.fname, mentor.lname, match_table.mentee_id, mentee.fname, mentee.lname FROM match_table INNER JOIN mentee ON match_table.mentee_id=mentee.mentee_id INNER JOIN mentor On match_table.mentor_id=mentor.mentor_id";

        try (Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement.
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {

            // execute the query.
            ResultSet rs = stmt.executeQuery();

            // use the data to create a Match object.
            List<MatchDisplay> matches = new ArrayList<>();
            while (rs.next()) {
                // get the data out of the query.
                Integer match_id = rs.getInt("match_id");
                Integer mentorId = rs.getInt("mentor_id");
                Integer menteeId = rs.getInt("mentee_id");
                String menteeFname = rs.getString("mentee.fname");
                String menteeLname = rs.getString("mentee.lname");
                String mentorFname = rs.getString("mentor.fname");
                String mentorLname = rs.getString("mentor.lname");

                MatchDisplay match = new MatchDisplay();
                match.setMatch_id(match_id);
                match.setMenteeId(menteeId);
                match.setMentorId(mentorId);
                match.setMenteeFname(menteeFname);
                match.setMenteeLname(menteeLname);
                match.setMentorFname(mentorFname);
                match.setMentorLname(mentorLname);

                matches.add(match);
            }
            return matches;

        } catch (SQLException ex) {
            // don't let the SQLException leak from our DAO encapsulation.
            throw new DAOException(ex.getMessage(), ex);
        }

    }

    // method to get Match by Mentee's ID.
    public List<MatchDisplay> getMatchByMenteeId(Integer menteeId) {
        String sql = "SELECT match_table.match_id, match_table.mentor_id, mentor.fname, mentor.lname FROM match_table INNER JOIN mentee ON match_table.mentee_id=mentee.mentee_id INNER JOIN mentor On match_table.mentor_id=mentor.mentor_id WHERE match_table.mentee_id = ?";

        try (Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement.
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the Match domain object into the SQL parameters.
            stmt.setInt(1, menteeId);
            // execute the query.
            ResultSet rs = stmt.executeQuery();

            // use the data to create a Match object.
            List<MatchDisplay> matches = new ArrayList<>();
            while (rs.next()) {
                // get the data out of the query.
                Integer match_id = rs.getInt("match_id");
                String mentorFname = rs.getString("mentor.fname");
                String mentorLname = rs.getString("mentor.lname");

                MatchDisplay match = new MatchDisplay();
                match.setMatch_id(match_id);
                match.setMentorFname(mentorFname);
                match.setMentorLname(mentorLname);

                matches.add(match);
            }
            return matches;

        } catch (SQLException ex) {
            // don't let the SQLException leak from our DAO encapsulation.
            throw new DAOException(ex.getMessage(), ex);
        }
    }// end getMatchByMenteeId method

    // Get Matches by Mentee by ID.
    public Collection<MatchDisplay> getMatchesByMenteeId(Integer id) {
        String sql = "SELECT match_table.match_id, mentor.fname, mentor.lname, mentee.fname, mentee.lname FROM match_table INNER JOIN mentee ON match_table.mentee_id=mentee.mentee_id INNER JOIN mentor On match_table.mentor_id=mentor.mentor_id WHERE match_table.mentee_id = ?";
        try (
                // get a connection to the database.
                Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement.
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the Mentee domain object into the SQL parameters.
            stmt.setInt(1, id);
            // execute the query.
            ResultSet rs = stmt.executeQuery();
            // use the data to create a Match object.
            List<MatchDisplay> matches = new ArrayList<>();
            while (rs.next()) {
                // get the data out of the query.
                Integer match_id = rs.getInt("match_id");
                Integer mentorId = rs.getInt("mentor_id");
                Integer menteeId = rs.getInt("mentee_id");
                String menteeFname = rs.getString("mentee.fname");
                String menteeLname = rs.getString("mentee.lname");
                String mentorFname = rs.getString("mentor.fname");
                String mentorLname = rs.getString("mentor.lname");

                MatchDisplay match = new MatchDisplay();
                match.setMatch_id(match_id);
                match.setMenteeId(menteeId);
                match.setMentorId(mentorId);
                match.setMenteeFname(menteeFname);
                match.setMenteeLname(menteeLname);
                match.setMentorFname(mentorFname);
                match.setMentorLname(mentorLname);

                matches.add(match);
            }
            return matches;
        } catch (SQLException ex) { // we are forced to catch SQLException.
            // don't let the SQLException leak from our DAO encapsulation.
            throw new DAOException(ex.getMessage(), ex);
        }
    }// end of method to get Mentor by email.

    // method to delete Match.
    public void removeMatch(Match match) {
        String sql = "DELETE FROM match WHERE match_id = ?";

        try (Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement.
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the Match object into the SQL parameters
            stmt.setInt(1, match.getMatchId());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }// end removeMatch method

}// end class