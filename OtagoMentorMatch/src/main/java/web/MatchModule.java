package web;

import dao.MatchJdbcDAO;
import domain.Match;
import org.jooby.Jooby;
//import org.jooby.Result;
import org.jooby.Status;

public class MatchModule extends Jooby {

    public MatchModule(MatchJdbcDAO matchDao) {

        // Save (POST) a Match.
        post("/api/matches", (req, rsp) -> {
            Match match = req.body().to(Match.class);
            matchDao.saveMatch(match);
            rsp.status(Status.CREATED);
        });

        // DELETE a Match.
        delete("/api/matches/:id", (req, rsp) -> {
            String id = req.param("id").value();
            Match match = (Match) matchDao.getMatchByMenteeId(Integer.parseInt(id));
            matchDao.removeMatch(match);
            rsp.status(Status.NO_CONTENT);
        });

        // GET all Matches.
        get("api/matches", () -> matchDao.getAllMatches());

        // Get Matches by Mentee ID.
        get("/api/matches/mentee/:id", (req) -> {
            String id = req.param("id").value();
            return matchDao.getMatchByMenteeId(Integer.parseInt(id));
        });
        get("/api/mymatches/mentee/:id", (req) -> {
            String id = req.param("id").value();
            return matchDao.getMyMatchByMenteeId(Integer.parseInt(id));
        });
        get("/api/mymatches/mentor/:id", (req) -> {
            String id = req.param("id").value();
            return matchDao.getMyMatchByMentorId(Integer.parseInt(id));
        });

    }
}
