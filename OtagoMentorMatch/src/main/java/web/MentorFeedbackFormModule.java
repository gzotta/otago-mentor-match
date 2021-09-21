package web;

import dao.MentorFeedbackFormJdbcDAO;
import domain.MentorFeedbackForm;
import org.jooby.Jooby;
//import org.jooby.Result;
import org.jooby.Status;

/**
 *
 * @author James Pettitt
 */
public class MentorFeedbackFormModule extends Jooby {

    public MentorFeedbackFormModule(MentorFeedbackFormJdbcDAO mentorFeedbackFormDao) {

        // Save (POST) a MentorFeedbackForm.
        post("/api/mentorFeedbackForms", (req, rsp) -> {
            MentorFeedbackForm mentorFeedbackForm = req.body().to(MentorFeedbackForm.class);
            mentorFeedbackFormDao.saveMentorFeedbackForm(mentorFeedbackForm);
            rsp.status(Status.CREATED);
        });

        // DELETE a MentorFeedbackForm.
        delete("/api/mentorFeedbackForms/:id", (req, rsp) -> {
            String id = req.param("id").value();
            MentorFeedbackForm mentorFeedbackForm = mentorFeedbackFormDao.getFormById(Integer.parseInt(id));
            mentorFeedbackFormDao.removeMentorFeedbackForm(mentorFeedbackForm);
            rsp.status(Status.NO_CONTENT);
        });
    }

}