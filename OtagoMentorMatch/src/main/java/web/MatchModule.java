package web;

import dao.MatchJdbcDAO;
import domain.Match;
import org.jooby.Jooby;
import org.jooby.Result;
import org.jooby.Status;


public class MatchModule extends Jooby{

    public MatchModule(MatchJdbcDAO matchDao){
        
        // Save (POST) a Match.
        post("/api/matches", (req, rsp) -> {
            Macth match = req.body().to(Match.class);
            adminDao.saveMatch(match);
            rsp.status(Status.CREATED);
        });
        
        // DELETE a Match.
        delete("/api/matches/:id", (req, rsp) -> {
            Integer id = req.param("id").value();
            Macth match = matchDao.getMatchByMatchId(Integer.parseInt(id));
            matchDao.removeMatch(match);
            rsp.status(Status.NO_CONTENT);
        });
    }
}
