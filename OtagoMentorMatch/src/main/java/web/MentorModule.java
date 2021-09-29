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
public class MentorModule extends Jooby {

    public MentorModule(MentorJdbcDAO mentorDao) {

        // Save (POST) a Mentor.
        post("/api/registerMentor", (req, rsp) -> {
            Mentor mentor = req.body().to(Mentor.class);
            mentorDao.saveMentor(mentor);
            rsp.status(Status.CREATED);
        });

        // Get a Mentor by email.
        get("/api/mentors/:email", (req) -> {
            String email = req.param("email").value();

            if (mentorDao.getMentorByEmail(email) == null) {
                return new Result().status(Status.NOT_FOUND);
            } else {
                return mentorDao.getMentorByEmail(email);
            }
        });

        // DELETE a Mentor.
        delete("/api/mentors/:email", (req, rsp) -> {
            String email = req.param("email").value();
            Mentor mentor = mentorDao.getMentorByEmail(String.valueOf(email));
            mentorDao.removeMentor(mentor);
            rsp.status(Status.NO_CONTENT);
        });

        // GET all Mentors.
        get("/api/mentors", () -> mentorDao.getMentors());

        // GET Mentors by industry.
        get("/api/mentors/:industry", (req) -> {
            String primaryWorkingIndustry = req.param("industry").value();
            return mentorDao.getMentorByIndustry(primaryWorkingIndustry);
        });
    }

}
