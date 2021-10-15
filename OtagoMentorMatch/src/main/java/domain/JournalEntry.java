package domain;

public class JournalEntry {
    private Integer journalEntryId;
    private String topicsCovered;
    private String lengthOfSession;
    private String notes;
    private Integer matchId;

    // empty constructor.
    public JournalEntry() {
    }

    // constructor with all fields.
    public JournalEntry(Integer journalEntryId, String topicsCovered, String lengthOfSession, String notes,
            Integer matchId) {
        this.journalEntryId = journalEntryId;
        this.topicsCovered = topicsCovered;
        this.lengthOfSession = lengthOfSession;
        this.notes = notes;
        this.matchId = matchId;
    }

    // getters and setters.
    public Integer getJournalEntryId() {
        return this.journalEntryId;
    }

    public void setJournalEntryId(Integer journalEntryId) {
        this.journalEntryId = journalEntryId;
    }

    public String getTopicsCovered() {
        return this.topicsCovered;
    }

    public void settopicsCovered(String topicsCovered) {
        this.topicsCovered = topicsCovered;
    }

    public String getLengthOfSession() {
        return this.lengthOfSession;
    }

    public void setLengthOfSession(String lengthOfSession) {
        this.lengthOfSession = lengthOfSession;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getMatchId() {
        return this.matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    // to string.
    @Override
    public String toString() {
        return "{" + " journal_entry_id='" + journalEntryId + "'" + ", topicsCovered='" + topicsCovered + "'"
                + ", lengthOfSession='" + lengthOfSession + "'" + ", notes='" + notes + "'" + ", matchId='" + matchId
                + "'" + "}";
    }

}
