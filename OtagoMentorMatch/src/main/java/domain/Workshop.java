package domain;

public class Workshop {
    private Integer workshopId;
    private String topic;
    private Date date;
    private String location;
    private Boolean online;
    private Boolean mentor;
    private Boolean mentee;

    public Workshop() {}

    // Constructor with all fields.
    public Workshop(Integer workshopId, String topic, Date date, String location, Boolean online, Boolean mentor, Boolean mentee) {
        this.workshopId = workshopId;
        this.topic = topic;
        this.date = date;
        this.location = location;
        this.online = online;
        this.mentor = mentor;
        this.mentee = mentee;
    }

    // Getters and Setters.
    public Integer getWorkshopId() {
        return this.workshopId;
    }

    public void setWorkshopId(Integer workshopId) {
        this.workshopId = workshopId;
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

    // To string
    @Override
    public String toString() {
        return "Workshop{" +
            " workshopId='" + this.workshopId + "'" +
            ", topic='" + this.topic + "'" +
            ", date='" + this.date + "'" +
            ", location='" + this.location + "'" +
            ", online='" + this.online + "'" +
            ", mentor='" + this.mentor + "'" +
            ", mentee='" + this.mentee + "'" +
            "}";
    }

}//end class



