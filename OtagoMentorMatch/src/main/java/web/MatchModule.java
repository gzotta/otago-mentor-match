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
            Match match = req.body().to(Match.class);
            matchDao.saveMatch(match);
            rsp.status(Status.CREATED);
        });
        
        // DELETE a Match.
        delete("/api/matches/:id", (req, rsp) -> {
            String id = req.param("id").value();
            Match match = matchDao.getMatchByMatchId(Integer.parseInt(id));
            matchDao.removeMatch(match);
            rsp.status(Status.NO_CONTENT);
        });
    }
}
