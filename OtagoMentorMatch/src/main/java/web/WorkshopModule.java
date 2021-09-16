package web;

import dao.WorkshopJdbcDAO;
import domain.Workshop;
import org.jooby.Jooby;
import org.jooby.Result;
import org.jooby.Status;


/**
 *
 * @author James Pettitt
 */
public class WorkshopModule extends Jooby {
    
    public WorkshopModule(WorshopJdbcDAO workshopDao){
        
        // Save (POST) a Workshop.
        post("/api/workshops", (req, rsp) -> {
            Workshop workshop = req.body().to(Workshop.class);
            workshopDao.saveWorkshop(workshop);
            rsp.status(Status.CREATED);
        });
    
        // DELETE a Workshop.
        delete("/api/workshops/:id", (req, rsp) -> {
            String id = req.param("id").value(); //is it silly to req as String then convert to integer?
            Workshop workshop = workshopDao.getWorkshopById(Integer.parseInt(id));
            workshopDao.removeWorkshop(workshop);
            rsp.status(Status.NO_CONTENT);
        });
    }

}