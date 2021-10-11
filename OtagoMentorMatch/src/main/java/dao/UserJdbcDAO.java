package dao;

import auth.CredentialsValidator;
import helpers.ScryptHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author George Zotta
 */
public class UserJdbcDAO implements CredentialsValidator {

    private String databaseURI = DbConnection.getDefaultConnectionUri();

    // default constructor.
    public UserJdbcDAO() {
    }

    // constructor that intialises the URI.
    public UserJdbcDAO(String databaseURI) {
        this.databaseURI = databaseURI;
    }

    // Method to validate credentials for Users.
    @Override
    public Boolean validateCredentials(String email, String password) {

        try (

                // get connection to database.
                Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement.
                PreparedStatement stmt = dbCon
                        .prepareStatement("select user_password from user where user_email = ?");) {

            // copy the data from the User domain object into the SQL parameters.
            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery(); // execute query.

            if (rs.next()) {
                String hash = rs.getString("user_password");

                // check that the password matches the hash
                return ScryptHelper.check(hash, password);
            } else {
                // no matching email
                return false;
            }

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }// end of method to validate Users.

}
