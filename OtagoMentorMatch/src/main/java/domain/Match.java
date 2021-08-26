package domain;

public class Match {
    private Integer matchId;
    private Date date;
    private Mentor mentor;
    private Mentee mentee;

    // Empty Constructor
    public Match() {}

    // Constructor with all fields
    public Match(Integer matchId, Date date, Mentor mentor, Mentee mentee) {
        this.matchId = matchId;
        this.date = date;
        this.mentor = mentor;
        this.mentee = mentee;
    }

    //getters and setters
    public Integer getMatchId() {
        return this.matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Mentor getMentor() {
        return this.mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    public Mentee getMentee() {
        return this.mentee;
    }

    public void setMentee(Mentee mentee) {
        this.mentee = mentee;
    }

    // To string method
    @Override
    public String toString() {
        return "Match{" +
            " matchId='" + this.matchId + "'" +
            ", date='" + this.date + "'" +
            ", mentor='" + this.mentor + "'" +
            ", mentee='" + this.mentee + "'" +
            "}";
    }
    
}//end class
