package domain;

public class JournalEntry {
    private Integer journal_entry_id;
    private String topics_covered;
    private String length_of_session;
    private String notes;
    private String match_id;


    public JournalEntry(Integer journal_entry_id, String topics_covered, String length_of_session, String notes, String match_id) {
        this.journal_entry_id = journal_entry_id;
        this.topics_covered = topics_covered;
        this.length_of_session = length_of_session;
        this.notes = notes;
        this.match_id = match_id;
    }

    public Integer getJournal_entry_id() {
        return this.journal_entry_id;
    }

    public void setJournal_entry_id(Integer journal_entry_id) {
        this.journal_entry_id = journal_entry_id;
    }

    public String getTopics_covered() {
        return this.topics_covered;
    }

    public void setTopics_covered(String topics_covered) {
        this.topics_covered = topics_covered;
    }

    public String getLength_of_session() {
        return this.length_of_session;
    }

    public void setLength_of_session(String length_of_session) {
        this.length_of_session = length_of_session;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getMatch_id() {
        return this.match_id;
    }

    public void setMatch_id(String match_id) {
        this.match_id = match_id;
    }

    @Override
    public String toString() {
        return "{" +
            " journal_entry_id='" + getJournal_entry_id() + "'" +
            ", topics_covered='" + getTopics_covered() + "'" +
            ", length_of_session='" + getLength_of_session() + "'" +
            ", notes='" + getNotes() + "'" +
            ", match_id='" + getMatch_id() + "'" +
            "}";
    }

}
