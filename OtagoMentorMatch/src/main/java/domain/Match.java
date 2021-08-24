package @domain;
import domain.Mentor;
import domain.Mentee;

public class Match {
    private int match_id;
    private Date date;
    private Mentor mentor;
    private Mentee mentee;
//Constructor

    public Match(int match_id, Date date, Mentor mentor, Mentee mentee) {
        this.match_id = match_id;
        this.date = date;
        this.mentor = mentor;
        this.mentee = mentee;
    }

    //getters and setters
    public int getMatch_id() {
        return this.match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "Match{" + "matchID=" + match_id + ", date=" + date'}';
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
    
    //Other match methods
}
