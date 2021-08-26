package domain;

public class JournalEntry {
    private Integer journal_entry_id;
    private String topics_covered;
    private String length_of_session;
    private String notes;
    private Integer matchId;


    //empty constructor.
    public JournalEntry() {
    }


    //constructor with all fields.
    public JournalEntry(Integer journal_entry_id, String topics_covered, String length_of_session, String notes, Integer matchId) {
        this.journal_entry_id = journal_entry_id;
        this.topics_covered = topics_covered;
        this.length_of_session = length_of_session;
        this.notes = notes;
        this.matchId = matchId;
    }


    //getters and setters.
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

    public Integer getMatchId() {
        return this.matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }



    //to string. 
    @Override
    public String toString() {
        return "{" +
            " journal_entry_id='" + journal_entry_id + "'" +
            ", topics_covered='" + topics_covered + "'" +
            ", length_of_session='" + length_of_session + "'" +
            ", notes='" + notes + "'" +
            ", matchId='" + matchId + "'" +
            "}";
    }



}
