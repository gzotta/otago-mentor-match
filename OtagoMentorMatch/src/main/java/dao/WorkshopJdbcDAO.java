package dao;
 
import domain.Workshop;
 
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
/**
 *
 * @author Taine Bayly
 */
public class WorkshopJdbcDAO {
 
    private String databaseURI = DbConnection.getDefaultConnectionUri();
 
    // default constructor.
    public WorkshopJdbcDAO() {
    }
 
    // constructor that intialises the URI.
    public WorkshopJdbcDAO(String databaseURI) {
        this.databaseURI = databaseURI;
    }
 
    // method to save Workshop.
    public void saveWorkshop(Workshop workshop) {
        String sql = "INSERT INTO workshop (topic, date, location, online, mentor, mentee) VALUES (?,?,?,?,?,?)";
 
        try (
                // get connection to database.
                Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement.
                PreparedStatement stmt = dbCon.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
 
                // copy the data from the Workshop domain object into the SQL parameters.
                stmt.setString(1, workshop.getTopic());
                stmt.setDate(2, (Date) workshop.getDate());
                stmt.setString(3, workshop.getLocation());
                stmt.setBoolean(4, workshop.getOnline());
                stmt.setBoolean(5, workshop.getMentor());
                stmt.setBoolean(6, workshop.getMentee());
	            
 
	   
	            stmt.executeUpdate(); // execute the statement.
            
 
	            // getting generated keys and adding it to domain.
                Integer id = null;
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    id = rs.getInt(1);
                } else {
                    throw new DAOException("Problem getting generated Workshop ID");
                }
 
                workshop.setWorkshopId(id);
            
            } catch (SQLException ex) {  // we are forced to catch SQLException.
                // don't let the SQLException leak from our DAO encapsulation.
                throw new DAOException(ex.getMessage(), ex);
            }
        }//end of method to save Workshop
 
 
 
    
    // method to delete workshop
    public void removeWorkshop(Workshop workshop) {
        String sql = "DELETE FROM workshop WHERE workshop_id = ?";
        
        try (
            // get connection to database.
            Connection dbCon = DbConnection.getConnection(databaseURI);
            // create the statement.
            PreparedStatement stmt = dbCon.prepareStatement(sql);) {
                // copy the data from the Admin domain object into the SQL parameters.
                stmt.setInt(1, workshop.getWorkshopId());
                stmt.executeUpdate(); // execute the statement
            
            } catch (SQLException ex) {  // we are forced to catch SQLException
                // don't let the SQLException leak from our DAO encapsulation
                throw new DAOException(ex.getMessage(), ex);
            }
        }// end of method to delete Admin.
 
}// end of WorkshopJdbcDAO class.