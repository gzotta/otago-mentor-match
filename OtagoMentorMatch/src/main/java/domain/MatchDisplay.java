package domain;

public class MatchDisplay {

    Integer match_id;
    Integer mentorId;
    Integer menteeId;
    String menteeFname;
    String menteeLname;
    String menteeEmail;
    String menteePhoneNumber;
    String menteeBio;
    String menteePersonalInterest;
    String mentorFname;
    String mentorLname;
    String mentorEmail;
    String mentorPhoneNumber;
    String mentorBio;
    String mentorEmployerJobTitle;
    String mentorJobTitleDepartment;
    String mentorCompanyName;

    public MatchDisplay() {
    }

    public MatchDisplay(Integer match_id, Integer mentorId, Integer menteeId, String menteeFname, String menteeLname,
            String mentorFname, String mentorLname) {
        this.match_id = match_id;
        this.mentorId = mentorId;
        this.menteeId = menteeId;
        this.menteeFname = menteeFname;
        this.menteeLname = menteeLname;
        this.mentorFname = mentorFname;
        this.mentorLname = mentorLname;
    }

    public MatchDisplay(Integer match_id, Integer mentorId, Integer menteeId, String menteeFname, String menteeLname,
            String menteeEmail, String menteePhoneNumber, String menteeBio, String menteePersonalInterest,
            String mentorFname, String mentorLname, String mentorEmail, String mentorPhoneNumber, String mentorBio,
            String mentorEmployerJobTitle, String mentorJobTitleDepartment, String mentorCompanyName) {
        this.match_id = match_id;
        this.mentorId = mentorId;
        this.menteeId = menteeId;
        this.menteeFname = menteeFname;
        this.menteeLname = menteeLname;
        this.menteeEmail = menteeEmail;
        this.menteePhoneNumber = menteePhoneNumber;
        this.menteeBio = menteeBio;
        this.menteePersonalInterest = menteePersonalInterest;
        this.mentorFname = mentorFname;
        this.mentorLname = mentorLname;
        this.mentorEmail = mentorEmail;
        this.mentorPhoneNumber = mentorPhoneNumber;
        this.mentorBio = mentorBio;
        this.mentorEmployerJobTitle = mentorEmployerJobTitle;
        this.mentorJobTitleDepartment = mentorJobTitleDepartment;
        this.mentorCompanyName = mentorCompanyName;
    }

    public Integer getMatch_id() {
        return match_id;
    }

    public void setMatch_id(Integer match_id) {
        this.match_id = match_id;
    }

    public Integer getMentorId() {
        return mentorId;
    }

    public void setMentorId(Integer mentorId) {
        this.mentorId = mentorId;
    }

    public Integer getMenteeId() {
        return menteeId;
    }

    public void setMenteeId(Integer menteeId) {
        this.menteeId = menteeId;
    }

    public String getMenteeFname() {
        return menteeFname;
    }

    public void setMenteeFname(String menteeFname) {
        this.menteeFname = menteeFname;
    }

    public String getMenteeLname() {
        return menteeLname;
    }

    public void setMenteeLname(String menteeLname) {
        this.menteeLname = menteeLname;
    }

    public String getMenteeEmail() {
        return menteeEmail;
    }

    public void setMenteeEmail(String menteeEmail) {
        this.menteeEmail = menteeEmail;
    }

    public String getMenteePhoneNumber() {
        return menteePhoneNumber;
    }

    public void setMenteePhoneNumber(String menteePhoneNumber) {
        this.menteePhoneNumber = menteePhoneNumber;
    }

    public String getMenteeBio() {
        return menteeBio;
    }

    public void setMenteeBio(String menteeBio) {
        this.menteeBio = menteeBio;
    }

    public String getMenteePersonalInterest() {
        return menteePersonalInterest;
    }

    public void setMenteePersonalInterest(String menteePersonalInterest) {
        this.menteePersonalInterest = menteePersonalInterest;
    }

    public String getMentorFname() {
        return mentorFname;
    }

    public void setMentorFname(String mentorFname) {
        this.mentorFname = mentorFname;
    }

    public String getMentorLname() {
        return mentorLname;
    }

    public void setMentorLname(String mentorLname) {
        this.mentorLname = mentorLname;
    }

    public String getMentorEmail() {
        return mentorEmail;
    }

    public void setMentorEmail(String mentorEmail) {
        this.mentorEmail = mentorEmail;
    }

    public String getMentorPhoneNumber() {
        return mentorPhoneNumber;
    }

    public void setMentorPhoneNumber(String mentorPhoneNumber) {
        this.mentorPhoneNumber = mentorPhoneNumber;
    }

    public String getMentorBio() {
        return mentorBio;
    }

    public void setMentorBio(String mentorBio) {
        this.mentorBio = mentorBio;
    }

    public String getMentorEmployerJobTitle() {
        return mentorEmployerJobTitle;
    }

    public void setMentorEmployerJobTitle(String mentorEmployerJobTitle) {
        this.mentorEmployerJobTitle = mentorEmployerJobTitle;
    }

    public String getMentorJobTitleDepartment() {
        return mentorJobTitleDepartment;
    }

    public void setMentorJobTitleDepartment(String mentorJobTitleDepartment) {
        this.mentorJobTitleDepartment = mentorJobTitleDepartment;
    }

    public String getMentorCompanyName() {
        return mentorCompanyName;
    }

    public void setMentorCompanyName(String mentorCompanyName) {
        this.mentorCompanyName = mentorCompanyName;
    }
}

    