public class Workshop {

    private Integer workshop_id;
    private String topic;
    private Date date;
    private String location;
    private Boolean online;
    private Boolean mentor;
    private Boolean mentee;

    
}


    public Workshop() {
    }

    public Workshop(Integer workshop_id, String topic, Date date, String location, Boolean online, Boolean mentor, Boolean mentee) {
        this.workshop_id = workshop_id;
        this.topic = topic;
        this.date = date;
        this.location = location;
        this.online = online;
        this.mentor = mentor;
        this.mentee = mentee;
    }

    public Integer getWorkshop_id() {
        return this.workshop_id;
    }

    public void setWorkshop_id(Integer workshop_id) {
        this.workshop_id = workshop_id;
    }

    public String getTopic() {
        return this.topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean isOnline() {
        return this.online;
    }

    public Boolean getOnline() {
        return this.online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public Boolean isMentor() {
        return this.mentor;
    }

    public Boolean getMentor() {
        return this.mentor;
    }

    public void setMentor(Boolean mentor) {
        this.mentor = mentor;
    }

    public Boolean isMentee() {
        return this.mentee;
    }

    public Boolean getMentee() {
        return this.mentee;
    }

    public void setMentee(Boolean mentee) {
        this.mentee = mentee;
    }

    @Override
    public String toString() {
        return "{" +
            " workshop_id='" + getWorkshop_id() + "'" +
            ", topic='" + getTopic() + "'" +
            ", date='" + getDate() + "'" +
            ", location='" + getLocation() + "'" +
            ", online='" + isOnline() + "'" +
            ", mentor='" + isMentor() + "'" +
            ", mentee='" + isMentee() + "'" +
            "}";
    }
