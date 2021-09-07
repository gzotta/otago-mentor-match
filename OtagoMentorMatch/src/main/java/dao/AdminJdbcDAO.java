package dao;
 
import domain.Admin;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
/**
 *
 * @author Taine Bayly
 */
public class AdminJdbcDAO {
 
    private String databaseURI = DbConnection.getDefaultConnectionUri();
 
    // default constructor.
    public AdminJdbcDAO() {
    }
 
    // constructor that intialises the URI.
    public AdminJdbcDAO(String databaseURI) {
        this.databaseURI = databaseURI;
    }
 
    // method to save Admin.
    public void saveAdmin(Admin admin) {
        String sql = "INSERT INTO admin (password, fname, lname, email, phone_number) VALUES (?,?,?,?,?)";
 
        try (
                // get connection to database.
                Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement.
                PreparedStatement stmt = dbCon.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
 
                // copy the data from the Mentee domain object into the SQL parameters.
                stmt.setString(1, admin.getPassword());
                stmt.setString(2, admin.getLname());
                stmt.setString(3, admin.getEmail());
                stmt.setString(4, admin.getPhoneNumber());
	            
 
	   
	            stmt.executeUpdate(); // execute the statement.
            
 
	            // getting generated keys and adding it to domain.
                Integer Id = null;
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    Id = rs.getInt(1);
                } else {
                    throw new DAOException("Problem getting generated Admin ID");
                }
 
                admin.setAdminId(Id);
            
            } catch (SQLException ex) {  // we are forced to catch SQLException.
                // don't let the SQLException leak from our DAO encapsulation.
                throw new DAOException(ex.getMessage(), ex);
            }
        }//end of method to save Admin
 
 
    // method to get Admin by email.
    // support method only - used by validateCredentials() below.
    public Mentee getAdminByEmail(String email) {
        String sql = "SELECT * FROM admin WHERE email = ?";
 
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
                    int adminId = rs.getInt("admin_id");
                    String password = rs.getString("password");
                    String fname = rs.getString("fname");
                    String lname = rs.getString("lname");
                    String phone_number = rs.getString("phone_number");
                    String email = rs.getString("email");
                    
                    
                    // use the data to create a Admin object.
                    Admin admin = new Admin();

                    admin.setAdminId(adminId);
                    admin.setMenteePassword(password);
                    admin.setFname(fname);
                    admin.setLname(lname);
                    admin.setPhoneNumber(phone_number);
                    admin.setEmail(email)
                    
                    return admin;
                } else {
                    return null;
                }
            } catch (SQLException ex) {  // we are forced to catch SQLException.
                // don't let the SQLException leak from our DAO encapsulation.
                throw new DAOException(ex.getMessage(), ex);
            }
        }// end of method to get Admin by first name.
        
 
    // method to sign users in.
    // accesses getAdminByemail() above.
    public Boolean validateCredentials(String email, String password) {
        Admin admin = getAdminByEmail(email);
        if ((mentee != null) && (mentee.getAdminPassword().equals(password))) {
            return true;
        } else {
            return false;
        }
    }// end of method to sign users in.
 
 
    
    // method to delete Admin
    public void removeadmin(Admin admin) {
        String sql = "DELETE FROM admin WHERE email = ?";
        
        try (
            // get connection to database.
            Connection dbCon = DbConnection.getConnection(databaseURI);
            // create the statement.
            PreparedStatement stmt = dbCon.prepareStatement(sql);) {
                // copy the data from the Admin domain object into the SQL parameters.
                stmt.setString(1, admin.getEmail());
                stmt.executeUpdate(); // execute the statement
            
            } catch (SQLException ex) {  // we are forced to catch SQLException
                // don't let the SQLException leak from our DAO encapsulation
                throw new DAOException(ex.getMessage(), ex);
            }
        }// end of method to delete Admin.
 
}// end of AdminJdbcDAO class.