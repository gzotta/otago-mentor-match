package dao;

import domain.Match;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    }// end saveMatch method

    // method to get Match by match's id
    public Match getMatchByMatchId(Integer matchId) {
        String sql = "SELECT * FROM match WHERE match_id = ?";

        try (Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement.
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the Match domain object into the SQL parameters.
            stmt.setInt(1, matchId);
            // execute the query.
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // get the data out of the query.
                Integer match_id = rs.getInt("match_id");
                String date = rs.getString("date");
                Integer mentorId = rs.getInt("mentor_id");
                Integer menteeId = rs.getInt("mentee_id");

                // use the data to create a Match object.
                Match match = new Match(match_id, date, mentorId, menteeId);
                return match;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            // don't let the SQLException leak from our DAO encapsulation.
            throw new DAOException(ex.getMessage(), ex);
        }
    }// end getMatchByMenteeId method

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