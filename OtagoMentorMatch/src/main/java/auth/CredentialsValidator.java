package auth;

/**
 * @author Mark George <mark.george@otago.ac.nz>
 *
 *         License: FreeBSD (https://opensource.org/licenses/BSD-2-Clause)
 */
public interface CredentialsValidator {

	Boolean validateCredentials(String email, String password);

}