package web;

import dao.AdminJdbcDAO;
import dao.JournalEntryJdbcDAO;
import dao.MatchJdbcDAO;
import dao.MenteeFeedbackFormJdbcDAO;
import dao.MenteeJdbcDAO;
import dao.MentorFeedbackFormJdbcDAO;
import dao.MentorJdbcDAO;
import dao.WorkshopJdbcDAO;
import java.util.concurrent.CompletableFuture;
import org.jooby.Jooby;
import org.jooby.json.Gzon;

public class Server extends Jooby {

    AdminJdbcDAO adminDao = new AdminJdbcDAO();
    JournalEntryJdbcDAO journalEntryDao = new JournalEntryJdbcDAO();
    MatchJdbcDAO matchDao = new MatchJdbcDAO();
    MenteeFeedbackFormJdbcDAO meenteeFeedbackFormDao = new MenteeFeedbackFormJdbcDAO();
    MenteeJdbcDAO menteeDao = new MenteeJdbcDAO();
    MentorFeedbackFormJdbcDAO mentorFeedbackDao = new MentorFeedbackFormJdbcDAO();
    MentorJdbcDAO mentorDao = new MentorJdbcDAO();
    WorkshopJdbcDAO workshopDao = new WorkshopJdbcDAO();

    public Server() {

        // super("server");
        port(8081);
        use(new Gzon());
        use(new AssetsModule());
        use(new AdminModule(adminDao));
        use(new JournalEntryModule(journalEntryDao));
        use(new MatchModule(matchDao));
        use(new MenteeFeedbackFormModule(meenteeFeedbackFormDao));
        use(new MenteeModule(menteeDao));
        use(new MentorFeedbackFormModule(mentorFeedbackDao));
        use(new MentorModule(mentorDao));
        use(new WorkshopModule(workshopDao));

    }

    public static void main(String[] args) throws Exception {
        System.out.println("\nStarting Server.");

        Server server = new Server();
        CompletableFuture.runAsync(() -> {
            server.start();
        });

        server.onStarted(() -> {
            System.out.println("\nPress Enter to stop the server.");
        });

        // wait for user to hit the Enter key
        System.in.read();
        System.exit(0);
    }
}