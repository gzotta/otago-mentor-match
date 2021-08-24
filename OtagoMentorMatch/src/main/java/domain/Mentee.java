package domain;

/**
 *
 * @author james pettitt
 */
public class Mentee {
    private int menteeId;
    private String fName;
    private String lName;
    private int phoneNumber;
    private String email;
    private int yearOfStudy;
    private String motivationForJoiningOMM;
    private String industryOfInterest;
    private String learningMethod;
    private String personalInterests;
    private String howFindOMM;
    private String randomMatching;
    private String bio;

    public Mentee(){}
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

    //no setters  at the moment
    public int getMenteeId(){
        return this.menteeId;
    }

    public String getMenteeFirstName(){
        return fName;
    }

    public String getMenteeLastName(){
        return fName;
    }

    public String getMenteeFullName(){
        return fName + " " + lName;
    }

    public int getMenteePhoneNumber(){
        return phoneNumber;
    }

    public String getMenteeEmail(){
        return email;
    }

    public int getMenteeYearOfStudy(){
        return yearOfStudy;
    }

    public String getMenteeMotivation(){
        return motivationForJoiningOMM;
    }

    public String getMenteeIndustryOfInterest(){
        return industryOfInterest;
    }

    public String getMenteeLearningMethod(){
        return learningMethod;
    }

    public String getMenteePersonalInterests(){
        return personalInterests;
    }

    public String getMenteeHowFindOMM(){
        return howFindOMM;
    }

    public String getMenteeRandomMatching(){
        return randomMatching;
    }

    public String getMenteeBio(){
        return bio;
    }

    @Override
    public String toString(){
        String menteedetails = String.format("Mentee{ id=%d, name=%s %s, phoneNumber=%d, email=%s, yearOfStudy=%d, motivation=%s, industryofinterest=%s, learningmethod=%s, personalinterests=%s, howfindomm=%s, randommatching=%s, bio=%s", menteeId, fName, lName, phoneNumber, email, yearOfStudy, motivationForJoiningOMM, industryOfInterest, learningMethod, personalInterests, howFindOMM, randomMatching, bio);
        return menteedetails;
    }

}//end class


