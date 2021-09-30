package domain;

public class Mentor {
    private Integer mentorId;
    private String mentorPassword;
    private String fname;
    private String lname;
    private String email;
    private String phoneNumber;
    private String ethnicity;
    private String iwiAfiliation;
    private String companyName;
    private String employerJobTitle;
    private String jobTitleDepartment;
    private String industry;
    private String primaryWorkingIndustry;
    private String briefCareerHistory;
    private String modeOfMentoringSessions;
    private String undergraduateCourse;
    private String undergraduateInstitution;
    private String undergraduateYearOfGraduation;
    private String postgraduateCourse;
    private String postgraduateInstitution;
    private String postgraduateYearOfGraduation;
    private String currentWorkAndLivingCountry;
    private String mentoringPreference;
    private String howFindOMM;
    private String bio;
    private String extraInfo;
    private Boolean newToMentory;

    public Mentor() {
    }

    // Constructor with all fields
    public Mentor(Integer mentorId, String mentorPassword, String fname, String lname, String email, String phoneNumber,
            String ethnicity, String iwiAfiliation, String companyName, String employerJobTitle,
            String jobTitleDepartment, String industry, String primaryWorkingIndustry, String briefCareerHistory,
            String modeOfMentoringSessions, String undergraduateCourse, String undergraduateInstitution,
            String undergraduateYearOfGraduation, String postgraduateCourse, String postgraduateInstitution,
            String postgraduateYearOfGraduation, String currentWorkAndLivingCountry, String mentoringPreference,
            String howFindOMM, String bio, String extraInfo, Boolean newToMentory) {
        this.mentorId = mentorId;
        this.mentorPassword = mentorPassword;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.ethnicity = ethnicity;
        this.iwiAfiliation = iwiAfiliation;
        this.companyName = companyName;
        this.employerJobTitle = employerJobTitle;
        this.jobTitleDepartment = jobTitleDepartment;
        this.industry = industry;
        this.primaryWorkingIndustry = primaryWorkingIndustry;
        this.briefCareerHistory = briefCareerHistory;
        this.modeOfMentoringSessions = modeOfMentoringSessions;
        this.undergraduateCourse = undergraduateCourse;
        this.undergraduateInstitution = undergraduateInstitution;
        this.undergraduateYearOfGraduation = undergraduateYearOfGraduation;
        this.postgraduateCourse = postgraduateCourse;
        this.postgraduateInstitution = postgraduateInstitution;
        this.postgraduateYearOfGraduation = postgraduateYearOfGraduation;
        this.currentWorkAndLivingCountry = currentWorkAndLivingCountry;
        this.mentoringPreference = mentoringPreference;
        this.howFindOMM = howFindOMM;
        this.bio = bio;
        this.extraInfo = extraInfo;
        this.newToMentory = newToMentory;
    }

    // Getters and Setters
    public Integer getMentorId() {
        return this.mentorId;
    }

    public void setMentorId(Integer mentorId) {
        this.mentorId = mentorId;
    }

    public String getMentorPassword() {
        return this.mentorPassword;
    }

    public void setMentorPassword(String mentorPassword) {
        this.mentorPassword = mentorPassword;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEthnicity() {
        return this.ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getIwiAfiliation() {
        return this.iwiAfiliation;
    }

    public void setIwiAfiliation(String iwiAfiliation) {
        this.iwiAfiliation = iwiAfiliation;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmployerJobTitle() {
        return this.employerJobTitle;
    }

    public void setEmployerJobTitle(String employerJobTitle) {
        this.employerJobTitle = employerJobTitle;
    }

    public String getJobTitleDepartment() {
        return this.jobTitleDepartment;
    }

    public void setJobTitleDepartment(String jobTitleDepartment) {
        this.jobTitleDepartment = jobTitleDepartment;
    }

    public String getIndustry() {
        return this.industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getPrimaryWorkingIndustry() {
        return this.primaryWorkingIndustry;
    }

    public void setPrimaryWorkingIndustry(String primaryWorkingIndustry) {
        this.primaryWorkingIndustry = primaryWorkingIndustry;
    }

    public String getBriefCareerHistory() {
        return this.briefCareerHistory;
    }

    public void setBriefCareerHistory(String briefCareerHistory) {
        this.briefCareerHistory = briefCareerHistory;
    }

    public String getModeOfMentoringSessions() {
        return this.modeOfMentoringSessions;
    }

    public void setModeOfMentoringSessions(String modeOfMentoringSessions) {
        this.modeOfMentoringSessions = modeOfMentoringSessions;
    }

    public String getUndergraduateCourse() {
        return this.undergraduateCourse;
    }

    public void setUndergraduateCourse(String undergraduateCourse) {
        this.undergraduateCourse = undergraduateCourse;
    }

    public String getUndergraduateInstitution() {
        return this.undergraduateInstitution;
    }

    public void setUndergraduateInstitution(String undergraduateInstitution) {
        this.undergraduateInstitution = undergraduateInstitution;
    }

    public String getUndergraduateYearOfGraduation() {
        return this.undergraduateYearOfGraduation;
    }

    public void setUndergraduateYearOfGraduation(String undergraduateYearOfGraduation) {
        this.undergraduateYearOfGraduation = undergraduateYearOfGraduation;
    }

    public String getPostgraduateCourse() {
        return this.postgraduateCourse;
    }

    public void setPostgraduateCourse(String postgraduateCourse) {
        this.postgraduateCourse = postgraduateCourse;
    }

    public String getPostgraduateInstitution() {
        return this.postgraduateInstitution;
    }

    public void setPostgraduateInstitution(String postgraduateInstitution) {
        this.postgraduateInstitution = postgraduateInstitution;
    }

    public String getPostgraduateYearOfGraduation() {
        return this.postgraduateYearOfGraduation;
    }

    public void setPostgraduateYearOfGraduation(String postgraduateYearOfGraduation) {
        this.postgraduateYearOfGraduation = postgraduateYearOfGraduation;
    }

    public String getCurrentWorkAndLivingCountry() {
        return this.currentWorkAndLivingCountry;
    }

    public void setCurrentWorkAndLivingCountry(String currentWorkAndLivingCountry) {
        this.currentWorkAndLivingCountry = currentWorkAndLivingCountry;
    }

    public String getMentoringPreference() {
        return this.mentoringPreference;
    }

    public void setMentoringPreference(String mentoringPreference) {
        this.mentoringPreference = mentoringPreference;
    }

    public String getHowFindOMM() {
        return this.howFindOMM;
    }

    public void setHowFindOMM(String howFindOMM) {
        this.howFindOMM = howFindOMM;
    }

    public String getBio() {
        return this.bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getExtraInfo() {
        return this.extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public Boolean isNewToMentory() {
        return this.newToMentory;
    }

    public Boolean getNewToMentory() {
        return this.newToMentory;
    }

    public void setNewToMentory(Boolean newToMentory) {
        this.newToMentory = newToMentory;
    }

    // To string
    @Override
    public String toString() {
        return "{" + " mentorId='" + this.mentorId + "'" + ", mentorPassword='" + this.mentorPassword + "'"
                + ", fName='" + this.fname + "'" + ", lName='" + this.lname + "'" + ", email='" + this.email + "'"
                + ", phoneNumber='" + this.phoneNumber + "'" + ", ethnicity='" + this.ethnicity + "'"
                + ", iwiAfiliation='" + this.iwiAfiliation + "'" + ", companyName='" + this.companyName + "'"
                + ", employerJobTitle='" + this.employerJobTitle + "'" + ", jobTitleDepartment='"
                + this.jobTitleDepartment + "'" + ", industry='" + this.industry + "'" + ", primaryWorkingIndustry='"
                + this.primaryWorkingIndustry + "'" + ", briefCareerHistory='" + this.briefCareerHistory + "'"
                + ", modeOfMentoringSessions='" + this.modeOfMentoringSessions + "'" + ", undergraduateCourse='"
                + this.undergraduateCourse + "'" + ", undergraduateInstitution='" + this.undergraduateInstitution + "'"
                + ", undergraduateYearOfGraduation='" + this.undergraduateYearOfGraduation + "'"
                + ", postgraduateCourse='" + this.postgraduateCourse + "'" + ", postgraduateInstitution='"
                + this.postgraduateInstitution + "'" + ", postgraduateYearOfGraduation='"
                + this.postgraduateYearOfGraduation + "'" + ", currentWorkAndLivingCountry='"
                + this.currentWorkAndLivingCountry + "'" + ", mentoringPreference='" + this.mentoringPreference + "'"
                + ", howFindOMM='" + this.howFindOMM + "'" + ", bio='" + this.bio + "'" + ", extraInfo='"
                + this.extraInfo + "'" + ", newToMentory='" + this.newToMentory + "'" + "}";
    }

}// end class