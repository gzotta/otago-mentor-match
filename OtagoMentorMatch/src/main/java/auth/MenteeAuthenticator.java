package auth;

import com.google.inject.Binder;
import com.typesafe.config.Config;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jooby.Env;
import org.jooby.Err;
import org.jooby.Jooby;
import org.jooby.Result;
import org.jooby.Router;
import org.jooby.Status;

/**
 * @author Mark George <mark.george@otago.ac.nz>
 *
 *         License: FreeBSD (https://opensource.org/licenses/BSD-2-Clause)
 *
 *         An HTTP Basic Access Authentication module for Jooby that has a list
 *         for exclusions.
 */
public class MenteeAuthenticator implements Jooby.Module {

    private final CredentialsValidator validator;
    private final List<String> noAuth = new ArrayList<>();

    public MenteeAuthenticator(CredentialsValidator validator) {
        this.validator = validator;
    }

    public MenteeAuthenticator(CredentialsValidator validator, List<String> noAuth) {
        this(validator);
        this.noAuth.addAll(noAuth);
    }

    @Override
    public void configure(Env env, Config conf, Binder binder) throws Throwable {

        Router router = env.router();

        // listen on ALL requests
        router.use("*", "*", (req, rsp, chain) -> {

            try {
                String authToken = req.header("Authorization").value();

                Base64.Decoder decoder = Base64.getDecoder();

                // strip off the "Basic " part
                String stripped = authToken.replace("Basic ", "");

                String authDetails = new String(decoder.decode(stripped));

                // split the decoded string into email and password
                Matcher matcher = Pattern.compile("(?<email>.+?):(?<password>.*)").matcher(authDetails);

                if (!matcher.matches()) {
                    // token is not in the expected format so is likely invalid
                    rsp.send(new Result().header("WWW-Authenticate", "None").status(Status.UNAUTHORIZED));
                }

                String email = matcher.group("email");
                String password = matcher.group("password");

                if (validator.validateCredentials(email, password)) {
                    // add email to request
                    req.set("email", email);
                    chain.next(req, rsp);
                } else {
                    // bad credentials
                    rsp.send(new Result().header("WWW-Authenticate", "None").status(Status.UNAUTHORIZED));
                }
            } catch (Err ex) {
                rsp.send(new Result().header("WWW-Authenticate", "None").status(Status.UNAUTHORIZED));
            }

        }).name("MenteeAuthenticator").excludes(noAuth);

    }

}