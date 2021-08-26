package domain;

/**
 *
 * @author james pettitt
 */
public class Mentee {
    private Integer menteeId;
    private String fName;
    private String lName;
    private String phoneNumber;
    private String email;
    private String yearOfStudy;
    private String motivationForJoiningOMM;
    private String industryOfInterest;
    private String learningMethod;
    private String personalInterests;
    private String howFindOMM;
    private String randomMatching;
    private String bio;


    // Empty constructor.
    public Mentee(){}

    // Constructor with all fields.
    public Mentee(int menteeId, String fName, String lName, int phoneNumber, String email, int yearOfStudy, String motivationForJoiningOMM, String industryOfInterest, String learningMethod, String personalInterests, String howFindOMM, String randomMatching, String bio) {
        this.menteeId = menteeId;
        this.fName = fName;
        this.lName = lName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.yearOfStudy = yearOfStudy;
        this.motivationForJoiningOMM = motivationForJoiningOMM;
        this.industryOfInterest = industryOfInterest;
        this.learningMethod = learningMethod;
        this.personalInterests = personalInterests;
        this.howFindOMM = howFindOMM;
        this.randomMatching = randomMatching;
        this.bio = bio;
    }


    // Getters and Setters.

    public int getMenteeId() {
        return this.menteeId;
    }

    public void setMenteeId(int menteeId) {
        this.menteeId = menteeId;
    }

    public String getFName() {
        return this.fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return this.lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public int getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getYearOfStudy() {
        return this.yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public String getMotivationForJoiningOMM() {
        return this.motivationForJoiningOMM;
    }

    public void setMotivationForJoiningOMM(String motivationForJoiningOMM) {
        this.motivationForJoiningOMM = motivationForJoiningOMM;
    }

    public String getIndustryOfInterest() {
        return this.industryOfInterest;
    }

    public void setIndustryOfInterest(String industryOfInterest) {
        this.industryOfInterest = industryOfInterest;
    }

    public String getLearningMethod() {
        return this.learningMethod;
    }

    public void setLearningMethod(String learningMethod) {
        this.learningMethod = learningMethod;
    }

    public String getPersonalInterests() {
        return this.personalInterests;
    }

    public void setPersonalInterests(String personalInterests) {
        this.personalInterests = personalInterests;
    }

    public String getHowFindOMM() {
        return this.howFindOMM;
    }

    public void setHowFindOMM(String howFindOMM) {
        this.howFindOMM = howFindOMM;
    }

    public String getRandomMatching() {
        return this.randomMatching;
    }

    public void setRandomMatching(String randomMatching) {
        this.randomMatching = randomMatching;
    }

    public String getBio() {
        return this.bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    
    // To string
    @Override
    public String toString() {
        return "{" +
            " menteeId='" + getMenteeId() + "'" +
            ", fName='" + getFName() + "'" +
            ", lName='" + getLName() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", email='" + getEmail() + "'" +
            ", yearOfStudy='" + getYearOfStudy() + "'" +
            ", motivationForJoiningOMM='" + getMotivationForJoiningOMM() + "'" +
            ", industryOfInterest='" + getIndustryOfInterest() + "'" +
            ", learningMethod='" + getLearningMethod() + "'" +
            ", personalInterests='" + getPersonalInterests() + "'" +
            ", howFindOMM='" + getHowFindOMM() + "'" +
            ", randomMatching='" + getRandomMatching() + "'" +
            ", bio='" + getBio() + "'" +
            "}";
    }



}//end class


