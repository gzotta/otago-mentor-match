package domain;

public class MentorFeedbackForm {
        private Integer mentor_feedback_id;
        private String finding_omm;
        private String enough_time_to_establish_relationship;
        private String describe_sessions;
        private String active_listening_rating;
        private String feedback_rating;
        private String trust_rating;
        private String achieve_goals_rating;
        private String developing_strategies_rating;
        private String motivation_rating;
        private String working_goals_rating;
        private String suitable_match;
        private String recommendation;
        private String potential_improvements;
        private String time_contributed;
        private String stay_in_touch;
        private String join_next_intake;
        private String testimonial;
        private String takeaways;
        private Integer matchId;


    //empty constructor.
    public MentorFeedbackForm() {
    }


    //constructor with all fields.
    public MentorFeedbackForm(Integer mentor_feedback_id, String finding_omm, String enough_time_to_establish_relationship, String describe_sessions, String active_listening_rating, String feedback_rating, String trust_rating, String achieve_goals_rating, String developing_strategies_rating, String motivation_rating, String working_goals_rating, String suitable_match, String recommendation, String potential_improvements, String time_contributed, String stay_in_touch, String join_next_intake, String testimonial, String takeaways, Integer matchId) {
        this.mentor_feedback_id = mentor_feedback_id;
        this.finding_omm = finding_omm;
        this.enough_time_to_establish_relationship = enough_time_to_establish_relationship;
        this.describe_sessions = describe_sessions;
        this.active_listening_rating = active_listening_rating;
        this.feedback_rating = feedback_rating;
        this.trust_rating = trust_rating;
        this.achieve_goals_rating = achieve_goals_rating;
        this.developing_strategies_rating = developing_strategies_rating;
        this.motivation_rating = motivation_rating;
        this.working_goals_rating = working_goals_rating;
        this.suitable_match = suitable_match;
        this.recommendation = recommendation;
        this.potential_improvements = potential_improvements;
        this.time_contributed = time_contributed;
        this.stay_in_touch = stay_in_touch;
        this.join_next_intake = join_next_intake;
        this.testimonial = testimonial;
        this.takeaways = takeaways;
        this.matchId = matchId;
    }

    
    
    
    //getters and setters.
    public Integer getMentor_feedback_id() {
        return this.mentor_feedback_id;
    }

    public void setMentor_feedback_id(Integer mentor_feedback_id) {
        this.mentor_feedback_id = mentor_feedback_id;
    }

    public String getFinding_omm() {
        return this.finding_omm;
    }

    public void setFinding_omm(String finding_omm) {
        this.finding_omm = finding_omm;
    }

    public String getEnough_time_to_establish_relationship() {
        return this.enough_time_to_establish_relationship;
    }

    public void setEnough_time_to_establish_relationship(String enough_time_to_establish_relationship) {
        this.enough_time_to_establish_relationship = enough_time_to_establish_relationship;
    }

    public String getDescribe_sessions() {
        return this.describe_sessions;
    }

    public void setDescribe_sessions(String describe_sessions) {
        this.describe_sessions = describe_sessions;
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

    public String getAchieve_goals_rating() {
        return this.achieve_goals_rating;
    }

    public void setAchieve_goals_rating(String achieve_goals_rating) {
        this.achieve_goals_rating = achieve_goals_rating;
    }

    public String getDeveloping_strategies_rating() {
        return this.developing_strategies_rating;
    }

    public void setDeveloping_strategies_rating(String developing_strategies_rating) {
        this.developing_strategies_rating = developing_strategies_rating;
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

    public String getSuitable_match() {
        return this.suitable_match;
    }

    public void setSuitable_match(String suitable_match) {
        this.suitable_match = suitable_match;
    }

    public String getRecommendation() {
        return this.recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getPotential_improvements() {
        return this.potential_improvements;
    }

    public void setPotential_improvements(String potential_improvements) {
        this.potential_improvements = potential_improvements;
    }

    public String getTime_contributed() {
        return this.time_contributed;
    }

    public void setTime_contributed(String time_contributed) {
        this.time_contributed = time_contributed;
    }

    public String getStay_in_touch() {
        return this.stay_in_touch;
    }

    public void setStay_in_touch(String stay_in_touch) {
        this.stay_in_touch = stay_in_touch;
    }

    public String getJoin_next_intake() {
        return this.join_next_intake;
    }

    public void setJoin_next_intake(String join_next_intake) {
        this.join_next_intake = join_next_intake;
    }

    public String getTestimonial() {
        return this.testimonial;
    }

    public void setTestimonial(String testimonial) {
        this.testimonial = testimonial;
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
            " mentor_feedback_id='" + mentor_feedback_id + "'" +
            ", finding_omm='" + finding_omm + "'" +
            ", enough_time_to_establish_relationship='" + enough_time_to_establish_relationship + "'" +
            ", describe_sessions='" + describe_sessions + "'" +
            ", active_listening_rating='" + active_listening_rating + "'" +
            ", feedback_rating='" + feedback_rating + "'" +
            ", trust_rating='" + trust_rating + "'" +
            ", achieve_goals_rating='" + achieve_goals_rating + "'" +
            ", developing_strategies_rating='" + developing_strategies_rating + "'" +
            ", motivation_rating='" + motivation_rating + "'" +
            ", working_goals_rating='" + working_goals_rating + "'" +
            ", suitable_match='" + suitable_match + "'" +
            ", recommendation='" + recommendation + "'" +
            ", potential_improvements='" + potential_improvements + "'" +
            ", time_contributed='" + time_contributed + "'" +
            ", stay_in_touch='" + stay_in_touch + "'" +
            ", join_next_intake='" + join_next_intake + "'" +
            ", testimonial='" + testimonial + "'" +
            ", takeaways='" + takeaways + "'" +
            ", matchId='" + matchId + "'" +
            "}";
    }
   
}
