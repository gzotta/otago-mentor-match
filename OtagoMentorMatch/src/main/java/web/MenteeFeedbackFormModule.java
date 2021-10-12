package web;

import dao.MenteeFeedbackFormJdbcDAO;
import domain.MenteeFeedbackForm;
import org.jooby.Jooby;
//import org.jooby.Result;
import org.jooby.Status;

/**
 *
 * @author James Pettitt
 */
public class MenteeFeedbackFormModule extends Jooby {

    public MenteeFeedbackFormModule(MenteeFeedbackFormJdbcDAO menteeFeedbackFormDao) {

        // Save (POST) a MenteeFeedbackForm.
        post("/api/menteeFeedbackForms", (req, rsp) -> {
            MenteeFeedbackForm menteeFeedbackForm = req.body().to(MenteeFeedbackForm.class);
            menteeFeedbackFormDao.saveMenteeFeedbackForm(menteeFeedbackForm);
            rsp.status(Status.CREATED);
        });
        // GET all Mentee feedback forms.
        get("/api/menteeFeedbackForms", () -> menteeFeedbackFormDao.getMenteeFeedbackForms());
        // DELETE a MenteeFeedbackForm.
        delete("/api/menteeFeedbackForms/:id", (req, rsp) -> {
            String id = req.param("id").value();
            MenteeFeedbackForm menteeFeedbackForm = menteeFeedbackFormDao.getFormById(Integer.parseInt(id));
            menteeFeedbackFormDao.removeMenteeFeedbackForm(menteeFeedbackForm);
            rsp.status(Status.NO_CONTENT);
        });
    }

}