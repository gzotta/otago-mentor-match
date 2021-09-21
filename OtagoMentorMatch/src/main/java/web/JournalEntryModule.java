package web;

import dao.JournalEntryJdbcDAO;
import domain.JournalEntry;
import org.jooby.Jooby;
//import org.jooby.Result;
import org.jooby.Status;

public class JournalEntryModule extends Jooby {

    public JournalEntryModule(JournalEntryJdbcDAO journalEntryDao) {

        // Save (POST) an Entry.
        post("/api/journalEntries", (req, rsp) -> {
            JournalEntry journalEntry = req.body().to(JournalEntry.class);
            journalEntryDao.saveEntry(journalEntry);
            rsp.status(Status.CREATED);
        });

        // DELETE an Entry.
        delete("/api/journalEntries/:id", (req, rsp) -> {
            String id = req.param("id").value();
            JournalEntry journalEntry = journalEntryDao.getEntryById(Integer.parseInt(id));
            journalEntryDao.removeEntry(journalEntry);
            rsp.status(Status.NO_CONTENT);
        });
    }
}
