package dao;

import domain.JournalEntry;

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
public class JournalEntryJdbcDAO {
    private String databaseURI = DbConnection.getDefaultConnectionUri();

    public JournalEntryJdbcDAO() {
    }

    // constructor that intialises the URI.
    public JournalEntryJdbcDAO(String databaseURI) {
        this.databaseURI = databaseURI;
    }

    // method to save Entry.
    public void saveEntry(JournalEntry journalEntry) {
        String sql = "INSERT INTO journal_entry (topics_covered, length_of_session, notes, match_id) VALUES (?, ?, ?, ?)";

        try (Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement.
                PreparedStatement stmt = dbCon.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            // copy the data from the JE object into the SQL parameters.

            // these methods dont exist until changes are made in domain class
            stmt.setString(1, journalEntry.getTopicsCovered());
            stmt.setString(2, journalEntry.getLengthOfSession());
            stmt.setString(3, journalEntry.getNotes());
            stmt.setInt(4, journalEntry.getMatchId());

            stmt.executeUpdate();

            // getting generated keys and adding it to domain.
            Integer id = null;
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            } else {
                throw new DAOException("Problem getting generated Entry ID");
            }

            journalEntry.setJournalEntryId(id);

        } catch (SQLException ex) { // we are forced to catch SQLException.
            // don't let the SQLException leak from our DAO encapsulation.
            throw new DAOException(ex.getMessage(), ex);
        }
    }// end saveEntry method

    // method to get JE by journal_entry_id
    public JournalEntry getEntryById(Integer journalEntryId) {
        String sql = "SELECT * FROM journal_entry WHERE journal_entry_id = ?";

        try (Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement.
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the JE domain object into the SQL parameters.
            stmt.setInt(1, journalEntryId);
            // execute the query.
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // get the data out of the query.
                Integer entryId = rs.getInt("journal_entry_id"); // getInteger ? getInt
                String topicsCovered = rs.getString("topics_covered");
                String lengthOfSession = rs.getString("length_of_session");
                String notes = rs.getString("notes");
                Integer matchId = rs.getInt("match_id");

                // use the data to create a Journal Entry
                JournalEntry journalEntry = new JournalEntry(entryId, topicsCovered, lengthOfSession, notes, matchId);
                return journalEntry;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            // don't let the SQLException leak from our DAO encapsulation.
            throw new DAOException(ex.getMessage(), ex);
        }
    }// end getEntryById method

// get all JE method
public Collection<JournalEntry> getJournalEntries() {

    String sql = "SELECT * FROM journal_entry";
    try (
            // get connection to database.
            Connection dbCon = DbConnection.getConnection(databaseURI);
            // create the statement.
            PreparedStatement stmt = dbCon.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
        ResultSet rs = stmt.executeQuery(); // execute the query

        List<JournalEntry> journalEntries = new ArrayList<>(); // using list to preserve data order

        // iterate through query results
        while (rs.next()) {

            Integer entryId = rs.getInt("journal_entry_id"); // getInteger ? getInt
            String topicsCovered = rs.getString("topics_covered");
            String lengthOfSession = rs.getString("length_of_session");
            String notes = rs.getString("notes");
            Integer matchId = rs.getInt("match_id");
            // use the data to create a Mentee object.
            JournalEntry journalEntry = new JournalEntry();
            journalEntry.setJournalEntryId(entryId);
            journalEntry.settopicsCovered(topicsCovered);
            journalEntry.setLengthOfSession(lengthOfSession);
            journalEntry.setNotes(notes);;
            journalEntry.setMatchId(matchId);;
            

            journalEntries.add(journalEntry); // put it in the collection
        }

        return journalEntries;

    } catch (SQLException ex) {
        throw new DAOException(ex.getMessage(), ex);
    }
}
    // method to delete JE
    public void removeEntry(JournalEntry journalEntry) {
        String sql = "DELETE FROM journal_entry WHERE journal_entry_id = ?";

        try (Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement.
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the JE object into the SQL parameters
            stmt.setInt(1, journalEntry.getJournalEntryId());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }// end removeEntry method

}// end class