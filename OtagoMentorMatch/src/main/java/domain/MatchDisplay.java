package domain;

public class MatchDisplay {

    Integer match_id;
    Integer mentorId;
    Integer menteeId;
    String menteeFname;
    String menteeLname;
    String mentorFname;
    String mentorLname;

    public MatchDisplay() {
    }

    public MatchDisplay(Integer match_id, Integer mentorId, Integer menteeId, String menteeFname, String menteeLname,
            String mentorFname, String mentorLname) {
        this.match_id = match_id;
        this.mentorId = mentorId;
        this.menteeId = menteeId;
        this.menteeFname = menteeFname;
        this.menteeLname = menteeLname;
        this.mentorFname = mentorFname;
        this.mentorLname = mentorLname;
    }

    public Integer getMatch_id() {
        return this.match_id;
    }

    public void setMatch_id(Integer match_id) {
        this.match_id = match_id;
    }

    public Integer getMentorId() {
        return this.mentorId;
    }

    public void setMentorId(Integer mentorId) {
        this.mentorId = mentorId;
    }

    public Integer getMenteeId() {
        return this.menteeId;
    }

    public void setMenteeId(Integer menteeId) {
        this.menteeId = menteeId;
    }

    public String getMenteeFname() {
        return this.menteeFname;
    }

    public void setMenteeFname(String menteeFname) {
        this.menteeFname = menteeFname;
    }

    public String getMenteeLname() {
        return this.menteeLname;
    }

    public void setMenteeLname(String menteeLname) {
        this.menteeLname = menteeLname;
    }

    public String getMentorFname() {
        return this.mentorFname;
    }

    public void setMentorFname(String mentorFname) {
        this.mentorFname = mentorFname;
    }

    public String getMentorLname() {
        return this.mentorLname;
    }

    public void setMentorLname(String mentorLname) {
        this.mentorLname = mentorLname;
    }

}
