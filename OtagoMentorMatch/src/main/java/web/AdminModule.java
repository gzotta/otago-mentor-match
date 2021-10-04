package web;

import dao.AdminJdbcDAO;
import domain.Admin;
import org.jooby.Jooby;
import org.jooby.Result;
//import org.jooby.Result;
import org.jooby.Status;

/**
 *
 * @author zotta
 */
public class AdminModule extends Jooby {

    public AdminModule(AdminJdbcDAO adminDao) {

        // Save (POST) an Admin.
        post("/api/admins", (req, rsp) -> {
            Admin admin = req.body().to(Admin.class);
            adminDao.saveAdmin(admin);
            rsp.status(Status.CREATED);
        });
        // Get a Mentee by email.
        get("/api/admins/:email", (req) -> {
            String email = req.param("email").value();

            if (adminDao.getAdminByEmail(email) == null) {
                return new Result().status(Status.NOT_FOUND);
            } else {
                return adminDao.getAdminByEmail(email);
            }
        });
        // DELETE an Admin.
        delete("/api/admins/:email", (req, rsp) -> {
            String email = req.param("email").value();
            Admin admin = adminDao.getAdminByEmail(String.valueOf(email));
            adminDao.removeAdmin(admin);
            rsp.status(Status.NO_CONTENT);
        });
    }

}
