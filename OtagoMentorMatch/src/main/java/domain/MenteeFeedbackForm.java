package domain;
 
public class MenteeFeedbackForm {
    private Integer menteeFeedbackFormId;
    private String communicationPlatform;
    private String findingOMM;
    private String sessionQuality;
    private String qualityOfMatch;
    private boolean recommendation;
    private String activeListeningRating;
    private String feedbackRating;
    private String trustRating;
    private String achieveGoalRating;
    private String developingStrategiesRating;
    private String motivationRating;
    private String workingLoadRating;
    private String programmeImprovements;
    private String timeContributed;
    private boolean continueRelationship;
    private boolean testimonial;
    private String otherComments;
    private String takeaways;
    private Integer menteeId;
 
 
    //empty constructor.
    public MenteeFeedbackForm() {
    }
 
 
    //constructor with all fields.
    public MenteeFeedbackForm(Integer menteeFeedbackFormId, String communicationPlatform, String findingOMM, String sessionQuality, String qualityOfMatch, boolean recommendation, String activeListeningRating, String feedbackRating, String trustRating, String achieveGoalRating, String developingStrategiesRating, String motivationRating, String workingLoadRating, String programmeImprovements, String timeContributed, boolean continueRelationship, boolean testimonial, String otherComments, String takeaways, Integer menteeId) {
        this.menteeFeedbackFormId = menteeFeedbackFormId;
        this.communicationPlatform = communicationPlatform;
        this.findingOMM = findingOMM;
        this.sessionQuality = sessionQuality;
        this.qualityOfMatch = qualityOfMatch;
        this.recommendation = recommendation;
        this.activeListeningRating = activeListeningRating;
        this.feedbackRating = feedbackRating;
        this.trustRating = trustRating;
        this.achieveGoalRating = achieveGoalRating;
        this.developingStrategiesRating = developingStrategiesRating;
        this.motivationRating = motivationRating;
        this.workingLoadRating = workingLoadRating;
        this.programmeImprovements = programmeImprovements;
        this.timeContributed = timeContributed;
        this.continueRelationship = continueRelationship;
        this.testimonial = testimonial;
        this.otherComments = otherComments;
        this.takeaways = takeaways;
        this.menteeId = menteeId;
    }




    //getters and setters.
    public Integer getMenteeFeedbackFormId() {
        return this.menteeFeedbackFormId;
    }

    public void setMenteeFeedbackFormId(Integer menteeFeedbackFormId) {
        this.menteeFeedbackFormId = menteeFeedbackFormId;
    }

    public String getCommunicationPlatform() {
        return this.communicationPlatform;
    }

    public void setCommunicationPlatform(String communicationPlatform) {
        this.communicationPlatform = communicationPlatform;
    }

    public String getFindingOMM() {
        return this.findingOMM;
    }

    public void setFindingOMM(String findingOMM) {
        this.findingOMM = findingOMM;
    }

    public String getSessionQuality() {
        return this.sessionQuality;
    }

    public void setSessionQuality(String sessionQuality) {
        this.sessionQuality = sessionQuality;
    }

    public String getQualityOfMatch() {
        return this.qualityOfMatch;
    }

    public void setQualityOfMatch(String qualityOfMatch) {
        this.qualityOfMatch = qualityOfMatch;
    }

    public boolean isRecommendation() {
        return this.recommendation;
    }

    public boolean getRecommendation() {
        return this.recommendation;
    }

    public void setRecommendation(boolean recommendation) {
        this.recommendation = recommendation;
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

    public String getWorkingLoadRating() {
        return this.workingLoadRating;
    }

    public void setWorkingLoadRating(String workingLoadRating) {
        this.workingLoadRating = workingLoadRating;
    }

    public String getProgrammeImprovements() {
        return this.programmeImprovements;
    }

    public void setProgrammeImprovements(String programmeImprovements) {
        this.programmeImprovements = programmeImprovements;
    }

    public String getTimeContributed() {
        return this.timeContributed;
    }

    public void setTimeContributed(String timeContributed) {
        this.timeContributed = timeContributed;
    }

    public boolean isContinueRelationship() {
        return this.continueRelationship;
    }

    public boolean getContinueRelationship() {
        return this.continueRelationship;
    }

    public void setContinueRelationship(boolean continueRelationship) {
        this.continueRelationship = continueRelationship;
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

    public String getOtherComments() {
        return this.otherComments;
    }

    public void setOtherComments(String otherComments) {
        this.otherComments = otherComments;
    }

    public String getTakeaways() {
        return this.takeaways;
    }

    public void setTakeaways(String takeaways) {
        this.takeaways = takeaways;
    }

    public Integer getMenteeId() {
        return this.menteeId;
    }

    public void setMenteeId(Integer menteeId) {
        this.menteeId = menteeId;
    }
   




    //to string.
    @Override
    public String toString() {
        return "{" +
            " menteeFeedbackFormId='" + menteeFeedbackFormId + "'" +
            ", communicationPlatform='" + communicationPlatform + "'" +
            ", findingOMM='" + findingOMM + "'" +
            ", sessionQuality='" + sessionQuality + "'" +
            ", qualityOfMatch='" + qualityOfMatch + "'" +
            ", recommendation='" + recommendation + "'" +
            ", activeListeningRating='" + activeListeningRating + "'" +
            ", feedbackRating='" + feedbackRating + "'" +
            ", trustRating='" + trustRating + "'" +
            ", achieveGoalRating='" + achieveGoalRating + "'" +
            ", developingStrategiesRating='" + developingStrategiesRating + "'" +
            ", motivationRating='" + motivationRating + "'" +
            ", workingLoadRating='" + workingLoadRating + "'" +
            ", programmeImprovements='" + programmeImprovements + "'" +
            ", timeContributed='" + timeContributed + "'" +
            ", continueRelationship='" + continueRelationship + "'" +
            ", testimonial='" + testimonial + "'" +
            ", otherComments='" + otherComments + "'" +
            ", takeaways='" + takeaways + "'" +
            ", menteeId='" + menteeId + "'" +
            "}";
    }
    
}//end class