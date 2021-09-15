package web;

import dao.MentorJdbcDAO;
import domain.Mentor;
import org.jooby.Jooby;
import org.jooby.Result;
import org.jooby.Status;

/**
 *
 * @author zotta
 */
public class MentorModule extends Jooby{

    public MentorModule(MentorJdbcDAO mentorDao){
        
        // Save (POST) a Mentor.
        post("/api/signUpMentor", (req, rsp) -> {
            Mentor mentor = req.body().to(Mentor.class);
            mentorDao.saveMentor(mentor);
            rsp.status(Status.CREATED);
        });
        
        // DELETE a Mentor.
        delete("/api/mentor/:email", (req, rsp) -> {
            String email = req.param("email").value();
            Mentor mentor = menteeDao.getMentorByEmail(String.valueOf(email));
            mentorDao.removeMentor(mentor);
            rsp.status(Status.NO_CONTENT);
        });
    }



}
