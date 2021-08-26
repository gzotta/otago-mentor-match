package domain;

public class MenteeFeedbackForm {
    private String communication_platform;
    private String finding_omm;
    private String session_quality;
    private String quality_of_match;
    private boolean reccomendation;
    private String active_listening_rating;
    private String feedback_rating;
    private String trust_rating;
    private String achieve_golas_rating;
    private String developing_strategiies_rating;
    private String motivation_rating;
    private String working_goals_rating;
    private String programme_improvements;
    private String time_contributed;
    private boolean continue_relationship;
    private boolean testimonial;
    private String other_comments;
    private String takeaways;
    private Integer matchId;


    //empty constructor.
    public MenteeFeedbackForm() {
    }


    //constructor with all fields.
    public MenteeFeedbackForm(String communication_platform, String finding_omm, String session_quality, String quality_of_match, boolean reccomendation, String active_listening_rating, String feedback_rating, String trust_rating, String achieve_golas_rating, String developing_strategiies_rating, String motivation_rating, String working_goals_rating, String programme_improvements, String time_contributed, boolean continue_relationship, boolean testimonial, String other_comments, String takeaways, Integer matchId) {
        this.communication_platform = communication_platform;
        this.finding_omm = finding_omm;
        this.session_quality = session_quality;
        this.quality_of_match = quality_of_match;
        this.reccomendation = reccomendation;
        this.active_listening_rating = active_listening_rating;
        this.feedback_rating = feedback_rating;
        this.trust_rating = trust_rating;
        this.achieve_golas_rating = achieve_golas_rating;
        this.developing_strategiies_rating = developing_strategiies_rating;
        this.motivation_rating = motivation_rating;
        this.working_goals_rating = working_goals_rating;
        this.programme_improvements = programme_improvements;
        this.time_contributed = time_contributed;
        this.continue_relationship = continue_relationship;
        this.testimonial = testimonial;
        this.other_comments = other_comments;
        this.takeaways = takeaways;
        this.matchId = matchId;
    }


    //getters and setters.

    public String getCommunication_platform() {
        return this.communication_platform;
    }

    public void setCommunication_platform(String communication_platform) {
        this.communication_platform = communication_platform;
    }

    public String getFinding_omm() {
        return this.finding_omm;
    }

    public void setFinding_omm(String finding_omm) {
        this.finding_omm = finding_omm;
    }

    public String getSession_quality() {
        return this.session_quality;
    }

    public void setSession_quality(String session_quality) {
        this.session_quality = session_quality;
    }

    public String getQuality_of_match() {
        return this.quality_of_match;
    }

    public void setQuality_of_match(String quality_of_match) {
        this.quality_of_match = quality_of_match;
    }

    public boolean isReccomendation() {
        return this.reccomendation;
    }

    public boolean getReccomendation() {
        return this.reccomendation;
    }

    public void setReccomendation(boolean reccomendation) {
        this.reccomendation = reccomendation;
    }

    public String getActive_listening_rating() {
        return this.active_listening_rating;
    }

    public void setActive_listening_rating(String active_listening_rating) {
        this.active_listening_rating = active_listening_rating;
    }

    public String getFeedback_rating() {
        return this.feedback_rating;
    }

    public void setFeedback_rating(String feedback_rating) {
        this.feedback_rating = feedback_rating;
    }

    public String getTrust_rating() {
        return this.trust_rating;
    }

    public void setTrust_rating(String trust_rating) {
        this.trust_rating = trust_rating;
    }

    public String getAchieve_golas_rating() {
        return this.achieve_golas_rating;
    }

    public void setAchieve_golas_rating(String achieve_golas_rating) {
        this.achieve_golas_rating = achieve_golas_rating;
    }

    public String getDeveloping_strategiies_rating() {
        return this.developing_strategiies_rating;
    }

    public void setDeveloping_strategiies_rating(String developing_strategiies_rating) {
        this.developing_strategiies_rating = developing_strategiies_rating;
    }

    public String getMotivation_rating() {
        return this.motivation_rating;
    }

    public void setMotivation_rating(String motivation_rating) {
        this.motivation_rating = motivation_rating;
    }

    public String getWorking_goals_rating() {
        return this.working_goals_rating;
    }

    public void setWorking_goals_rating(String working_goals_rating) {
        this.working_goals_rating = working_goals_rating;
    }

    public String getProgramme_improvements() {
        return this.programme_improvements;
    }

    public void setProgramme_improvements(String programme_improvements) {
        this.programme_improvements = programme_improvements;
    }

    public String getTime_contributed() {
        return this.time_contributed;
    }

    public void setTime_contributed(String time_contributed) {
        this.time_contributed = time_contributed;
    }

    public boolean isContinue_relationship() {
        return this.continue_relationship;
    }

    public boolean getContinue_relationship() {
        return this.continue_relationship;
    }

    public void setContinue_relationship(boolean continue_relationship) {
        this.continue_relationship = continue_relationship;
    }

    public boolean isTestimonial() {
        return this.testimonial;
    }

    public boolean getTestimonial() {
        return this.testimonial;
    }

    public void setTestimonial(boolean testimonial) {
        this.testimonial = testimonial;
    }

    public String getOther_comments() {
        return this.other_comments;
    }

    public void setOther_comments(String other_comments) {
        this.other_comments = other_comments;
    }

    public String getTakeaways() {
        return this.takeaways;
    }

    public void setTakeaways(String takeaways) {
        this.takeaways = takeaways;
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
            " communication_platform='" + communication_platform + "'" +
            ", finding_omm='" + finding_omm + "'" +
            ", session_quality='" + session_quality + "'" +
            ", quality_of_match='" + quality_of_match + "'" +
            ", reccomendation='" + reccomendation + "'" +
            ", active_listening_rating='" + active_listening_rating + "'" +
            ", feedback_rating='" + feedback_rating + "'" +
            ", trust_rating='" + trust_rating + "'" +
            ", achieve_golas_rating='" + achieve_golas_rating + "'" +
            ", developing_strategiies_rating='" + developing_strategiies_rating + "'" +
            ", motivation_rating='" + motivation_rating + "'" +
            ", working_goals_rating='" + working_goals_rating + "'" +
            ", programme_improvements='" + programme_improvements + "'" +
            ", time_contributed='" + time_contributed + "'" +
            ", continue_relationship='" + continue_relationship + "'" +
            ", testimonial='" + testimonial + "'" +
            ", other_comments='" + other_comments + "'" +
            ", takeaways='" + takeaways + "'" +
            ", matchId='" + matchId + "'" +
            "}";
    }
 
    
}//end class