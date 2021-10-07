package domain;

import java.util.Date;

public class Match {
    private Integer matchId;
    private String date;
    private Integer mentorId;
    private Integer menteeId;

    // Empty Constructor
    public Match() {
    }

    // Constructor with all fields
    public Match(Integer matchId, String date, Integer mentorId, Integer menteeId) {
        this.matchId = matchId;
        this.date = date;
        this.mentorId = mentorId;
        this.menteeId = menteeId;
    }

    // getters and setters

    public Integer getMatchId() {
        return this.matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
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

    // To string method
    @Override
    public String toString() {
        return "{" + " matchId='" + matchId + "'" + ", date='" + date + "'" + ", mentorId='" + mentorId + "'"
                + ", menteeId='" + menteeId + "'" + "}";
    }

}// end class
