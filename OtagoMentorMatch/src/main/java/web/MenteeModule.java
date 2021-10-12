package web;

import dao.MenteeJdbcDAO;
import domain.Mentee;
import org.jooby.Jooby;
import org.jooby.Status;
import org.jooby.Result;

/**
 *
 * @author zotta
 */
public class MenteeModule extends Jooby {

    public MenteeModule(MenteeJdbcDAO menteeDao) {

        // Save (POST) a Mentee.
        post("/api/registerMentee", (req, rsp) -> {
            Mentee mentee = req.body().to(Mentee.class);
            menteeDao.saveMentee(mentee);
            rsp.status(Status.CREATED);

        });

        // Get a Mentee by email.
        get("/api/mentees/:email", (req) -> {
            String email = req.param("email").value();

            if (menteeDao.getMenteeByEmail(email) == null) {
                return new Result().status(Status.NOT_FOUND);
            } else {
                return menteeDao.getMenteeByEmail(email);
            }
        });
        
        // GET all Mentees.
        get("/api/mentees", () -> menteeDao.getMentees());
        
        // DELETE a Mentee.
        delete("/api/mentees/:email", (req, rsp) -> {
            String email = req.param("email").value();
            Mentee mentee = menteeDao.getMenteeByEmail(String.valueOf(email));
            menteeDao.removeMentee(mentee);
            rsp.status(Status.NO_CONTENT);
        });

    }

}
