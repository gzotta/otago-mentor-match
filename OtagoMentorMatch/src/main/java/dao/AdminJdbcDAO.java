package dao;

import domain.Admin;
import helpers.ScryptHelper;
import auth.CredentialsValidator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Taine Bayly
 */
public class AdminJdbcDAO implements CredentialsValidator {

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

        // get connection to database.
        Connection dbCon = DbConnection.getConnection(databaseURI);
        // SQL query to insert admin object into admin table.
        String saveAdminSql = "INSERT INTO admin (password, fname, lname, email, phone_number) VALUES (?,?,?,?,?)";
        // SQL queery to insert email and password into user table.
        String saveUserSql = "INSERT INTO user (user_password, user_email) VALUES (?,?)";
        // This line converts the password into a hash.
        String hash = ScryptHelper.hash(admin.getPassword()).toString();

        try {
            try (

                    // Create the statement to save Admin.
                    PreparedStatement saveAdminStmt = dbCon.prepareStatement(saveAdminSql,
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

                //// ### Save the Admin ### ////

                // Copy the data from the amdmin domain object into the SQL parameters.
                saveAdminStmt.setString(1, hash);
                saveAdminStmt.setString(2, admin.getFname());
                saveAdminStmt.setString(3, admin.getLname());
                saveAdminStmt.setString(4, admin.getEmail());
                saveAdminStmt.setString(5, admin.getPhoneNumber());

                saveAdminStmt.executeUpdate(); // execute the statement.

                // getting generated keys and adding it to domain.
                Integer id = null;
                ResultSet rs = saveAdminStmt.getGeneratedKeys();
                if (rs.next()) {
                    id = rs.getInt(1);
                } else {
                    throw new DAOException("Problem getting generated Admin ID");
                }

                admin.setAdminId(id);

                //// ### Save the User ### ///

                // Copy the data from the amdmin domain object into the SQL parameters.
                saveUserStmt.setString(1, hash);
                saveUserStmt.setString(2, admin.getEmail());

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
                Logger.getLogger(AdminJdbcDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }// end of method to save Admin

    // method to get Admin by email.
    // support method only - used by validateCredentials() below.
    public Admin getAdminByEmail(String email) {
        String sql = "SELECT * FROM admin WHERE email = ?";

        try (
                // get a connection to the database.
                Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement.
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the amdmin domain object into the SQL parameters.
            stmt.setString(1, email);
            // execute the query.
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // get the data out of the query.
                Integer adminId = rs.getInt("admin_id");
                String password = rs.getString("password");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String phone_number = rs.getString("phone_number");
                String adminEmail = rs.getString("email");

                // use the data to create a Admin object.
                Admin admin = new Admin();

                admin.setAdminId(adminId);
                admin.setPassword(password);
                admin.setFname(fname);
                admin.setLname(lname);
                admin.setPhoneNumber(phone_number);
                admin.setEmail(adminEmail);

                return admin;
            } else {
                return null;
            }
        } catch (SQLException ex) { // we are forced to catch SQLException.
            // don't let the SQLException leak from our DAO encapsulation.
            throw new DAOException(ex.getMessage(), ex);
        }
    }// end of method to get Admin by email.

    // Method to validate credentials for Admins.
    @Override
    public Boolean validateCredentials(String email, String password) {

        try (

                // get connection to database.
                Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement.
                PreparedStatement stmt = dbCon.prepareStatement("select password from admin where email = ?");) {

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
    }// end of method to validate Admins.

    // method to delete Admin
    public void removeAdmin(Admin admin) {
        String sql = "DELETE FROM admin WHERE email = ?";

        try (
                // get connection to database.
                Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement.
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the Admin domain object into the SQL parameters.
            stmt.setString(1, admin.getEmail());
            stmt.executeUpdate(); // execute the statement

        } catch (SQLException ex) { // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }// end of method to delete Admin.

}// end of AdminJdbcDAO class.