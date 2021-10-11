package domain;

public class MentorFeedbackForm {
        private Integer mentorFeedbackFormId;
        private String findingOMM;
        private String enoughTimeToEstablishRelationship;
        private String describeSessions;
        private String activeListeningRating;
        private String feedbackRating;
        private String trustRating;
        private String achieveGoalRating;
        private String developingStrategiesRating;
        private String motivationRating;
        private String workingGoalsRating;
        private String suitableMatch;
        private boolean recommendation;
        private String potentialImprovements;
        private String timeContributed;
        private boolean continueRelationship;
        private String joinNextIntake;
        private boolean testimonial;
        private String takeaways;
        private Integer mentorId;

    public MentorFeedbackForm() {}

    //constructor with all fields.
    public MentorFeedbackForm(Integer mentorFeedbackFormId, String findingOMM, String enoughTimeToEstablishRelationship, String describeSessions, String activeListeningRating, String feedbackRating, String trustRating, String achieveGoalRating, String developingStrategiesRating, String motivationRating, String workingGoalsRating, String suitableMatch, boolean recommendation, String potentialImprovements, String timeContributed, boolean continueRelationship, String joinNextIntake, boolean testimonial, String takeaways, Integer mentorId) {
        this.mentorFeedbackFormId = mentorFeedbackFormId;
        this.findingOMM = findingOMM;
        this.enoughTimeToEstablishRelationship = enoughTimeToEstablishRelationship;
        this.describeSessions = describeSessions;
        this.activeListeningRating = activeListeningRating;
        this.feedbackRating = feedbackRating;
        this.trustRating = trustRating;
        this.achieveGoalRating = achieveGoalRating;
        this.developingStrategiesRating = developingStrategiesRating;
        this.motivationRating = motivationRating;
        this.workingGoalsRating = workingGoalsRating;
        this.suitableMatch = suitableMatch;
        this.recommendation = recommendation;
        this.potentialImprovements = potentialImprovements;
        this.timeContributed = timeContributed;
        this.continueRelationship = continueRelationship;
        this.joinNextIntake = joinNextIntake;
        this.testimonial = testimonial;
        this.takeaways = takeaways;
        this.mentorId = mentorId;
    }

    //getters and setters.
    public Integer getMentorFeedbackFormId() {
        return this.mentorFeedbackFormId;
    }

    public void setMentorFeedbackFormId(Integer mentorFeedbackFormId) {
        this.mentorFeedbackFormId = mentorFeedbackFormId;
    }

    public String getFindingOMM() {
        return this.findingOMM;
    }

    public void setFindingOMM(String findingOMM) {
        this.findingOMM = findingOMM;
    }

    public String getEnoughTimeToEstablishRelationship() {
        return this.enoughTimeToEstablishRelationship;
    }

    public void setEnoughTimeToEstablishRelationship(String enoughTimeToEstablishRelationship) {
        this.enoughTimeToEstablishRelationship = enoughTimeToEstablishRelationship;
    }

    public String getDescribeSessions() {
        return this.describeSessions;
    }

    public void setDescribeSessions(String describeSessions) {
        this.describeSessions = describeSessions;
    }

    public String getActiveListeningRating() {
        return this.activeListeningRating;
    }

    public void setActiveListeningRating(String activeListeningRating) {
        this.activeListeningRating = activeListeningRating;
    }

    public String getFeedbackRating() {
        return this.feedbackRating;
    }

    public void setFeedbackRating(String feedbackRating) {
        this.feedbackRating = feedbackRating;
    }

    public String getTrustRating() {
        return this.trustRating;
    }

    public void setTrustRating(String trustRating) {
        this.trustRating = trustRating;
    }

    public String getAchieveGoalRating() {
        return this.achieveGoalRating;
    }

    public void setAchieveGoalRating(String achieveGoalRating) {
        this.achieveGoalRating = achieveGoalRating;
    }

    public String getDevelopingStrategiesRating() {
        return this.developingStrategiesRating;
    }

    public void setDevelopingStrategiesRating(String developingStrategiesRating) {
        this.developingStrategiesRating = developingStrategiesRating;
    }

    public String getMotivationRating() {
        return this.motivationRating;
    }

    public void setMotivationRating(String motivationRating) {
        this.motivationRating = motivationRating;
    }

    public String getWorkingGoalsRating() {
        return this.workingGoalsRating;
    }

    public void setWorkingGoalsRating(String workingGoalsRating) {
        this.workingGoalsRating = workingGoalsRating;
    }

    public String getSuitableMatch() {
        return this.suitableMatch;
    }

    public void setSuitableMatch(String suitableMatch) {
        this.suitableMatch = suitableMatch;
    }

    public boolean getRecommendation() {
        return this.recommendation;
    }

    public void setRecommendation(boolean recommendation) {
        this.recommendation = recommendation;
    }

    public String getPotentialImprovements() {
        return this.potentialImprovements;
    }

    public void setPotentialImprovements(String potentialImprovements) {
        this.potentialImprovements = potentialImprovements;
    }

    public String getTimeContributed() {
        return this.timeContributed;
    }

    public void setTimeContributed(String timeContributed) {
        this.timeContributed = timeContributed;
    }

    public boolean getContinueRelationship() {
        return this.continueRelationship;
    }

    public void setContinueRelationship(boolean continueRelationship) {
        this.continueRelationship = continueRelationship;
    }

    public String getJoinNextIntake() {
        return this.joinNextIntake;
    }

    public void setJoinNextIntake(String joinNextIntake) {
        this.joinNextIntake = joinNextIntake;
    }

    public boolean getTestimonial() {
        return this.testimonial;
    }

    public void setTestimonial(boolean testimonial) {
        this.testimonial = testimonial;
    }

    public String getTakeaways() {
        return this.takeaways;
    }

    public void setTakeaways(String takeaways) {
        this.takeaways = takeaways;
    }

    public Integer getMentorId() {
        return this.mentorId;
    }

    public void setMentorId(Integer mentorId) {
        this.mentorId = mentorId;
    }

    @Override
    public String toString() {
        return "{" +
            " mentorFeedbackFormId='" + mentorFeedbackFormId + "'" +
            ", findingOMM='" + findingOMM + "'" +
            ", enoughTimeToEstablishRelationship='" + enoughTimeToEstablishRelationship + "'" +
            ", describeSessions='" + describeSessions + "'" +
            ", activeListeningRating='" + activeListeningRating + "'" +
            ", feedbackRating='" + feedbackRating + "'" +
            ", trustRating='" + trustRating + "'" +
            ", achieveGoalRating='" + achieveGoalRating + "'" +
            ", developingStrategiesRating='" + developingStrategiesRating + "'" +
            ", motivationRating='" + motivationRating + "'" +
            ", workingGoalsRating='" + workingGoalsRating + "'" +
            ", suitableMatch='" + suitableMatch + "'" +
            ", recommendation='" + recommendation + "'" +
            ", potentialImprovements='" + potentialImprovements + "'" +
            ", timeContributed='" + timeContributed + "'" +
            ", continueRelationship='" + continueRelationship + "'" +
            ", joinNextIntake='" + joinNextIntake + "'" +
            ", testimonial='" + testimonial + "'" +
            ", takeaways='" + takeaways + "'" +
            ", mentorId='" + mentorId + "'" +
            "}";
    }
   
} //end class