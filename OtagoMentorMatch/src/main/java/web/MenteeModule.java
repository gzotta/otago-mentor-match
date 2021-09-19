package web;

import dao.MenteeJdbcDAO;
import domain.Mentee;
import org.jooby.Jooby;
import org.jooby.Result;
import org.jooby.Status;

/**
 *
 * @author zotta
 */
public class MenteeModule extends Jooby {

    public MenteeModule(MenteeJdbcDAO menteeDao) {

        // Save (POST) a Mentee.
        post("/api/mentees", (req, rsp) -> {
            Mentee mentee = req.body().to(Mentee.class);
            menteeDao.saveMentee(mentee);
            rsp.status(Status.CREATED);

        });

        // DELETE a Mentee.
        delete("/api/mentees/:email", (req, rsp) -> {
            String email = req.param("email").value();
            Mentee mentee = menteeDao.getMenteeByEmail(String.valueOf(email));
            menteeDao.removeMentee(mentee);
            rsp.status(Status.NO_CONTENT);
        });

    }

}
