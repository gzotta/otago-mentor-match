package domain;

/**
 *
 * @author james pettitt
 */
public class Mentee {
    private Integer menteeId;
    private String fname;
    private String lname;
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

    public Mentee(){}

    // Constructor with all fields.
    public Mentee(Integer menteeId, String fname, String lname, String phoneNumber, String email, String yearOfStudy, String motivationForJoiningOMM, String industryOfInterest, String learningMethod, String personalInterests, String howFindOMM, String randomMatching, String bio) {
        this.menteeId = menteeId;
        this.fname = fname;
        this.lname = lname;
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
    public Integer getMenteeId() {
        return this.menteeId;
    }

    public void setMenteeId(Integer menteeId) {
        this.menteeId = menteeId;
    }

    public String getFName() {
        return this.fname;
    }

    public void setFName(String fname) {
        this.fname = fname;
    }

    public String getLName() {
        return this.lname;
    }

    public void setLName(String lname) {
        this.lname = lname;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getYearOfStudy() {
        return this.yearOfStudy;
    }

    public void setYearOfStudy(String yearOfStudy) {
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
            " menteeId='" + this.menteeId + "'" +
            ", fName='" + this.fname + "'" +
            ", lName='" + this.lname + "'" +
            ", phoneNumber='" + this.phoneNumber + "'" +
            ", email='" + this.email + "'" +
            ", yearOfStudy='" + this.yearOfStudy + "'" +
            ", motivationForJoiningOMM='" + this.motivationForJoiningOMM + "'" +
            ", industryOfInterest='" + this.industryOfInterest + "'" +
            ", learningMethod='" + this.learningMethod + "'" +
            ", personalInterests='" + this.personalInterests + "'" +
            ", howFindOMM='" + this.howFindOMM + "'" +
            ", randomMatching='" + this.randomMatching + "'" +
            ", bio='" + this.bio + "'" +
            "}";
    }

}//end class


