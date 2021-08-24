/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author zotta
 */
public class Mentor {
    private Integer mentor_id;
    private String mentor_password;
    private String fName;
    private String lName;
    private String email;
    private String phoneNumber;
    private String ethnicity;
    private String iwi_afiliation;
    private String company_name;
    private String employer_job_title;
    private String job_title_department;
    private String industry;
    private String primary_working_industry;
    private String brief_career_history;
    private String mode_of_mentoring_sessions;
    private String undergraduate_course;
    private String undergraduate_institution;
    private String undergraduate_year_of_graduation;
    private String postgraduate_course;
    private String postgraduate_institution;
    private String postgraduate_year_of_graduation;
    private String current_work_and_living_country;
    private String mentoring_preference;
    private String howFindOMM;;
    private String bio;
    private String extra_info;
    private Boolean new_to_mentory;

    public Mentor() {
    }


    public Mentor(Integer mentor_id, String mentor_password, String fName, String lName, String email, String phoneNumber, String ethnicity, String iwi_afiliation, String company_name, String employer_job_title, String job_title_department, String industry, String primary_working_industry, String brief_career_history, String mode_of_mentoring_sessions, String undergraduate_course, String undergraduate_institution, String undergraduate_year_of_graduation, String postgraduate_course, String postgraduate_institution, String postgraduate_year_of_graduation, String current_work_and_living_country, String mentoring_preference, String howFindOMM, String bio, String extra_info, Boolean new_to_mentory, String getHowFindOMM) {
        this.mentor_id = mentor_id;
        this.mentor_password = mentor_password;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.ethnicity = ethnicity;
        this.iwi_afiliation = iwi_afiliation;
        this.company_name = company_name;
        this.employer_job_title = employer_job_title;
        this.job_title_department = job_title_department;
        this.industry = industry;
        this.primary_working_industry = primary_working_industry;
        this.brief_career_history = brief_career_history;
        this.mode_of_mentoring_sessions = mode_of_mentoring_sessions;
        this.undergraduate_course = undergraduate_course;
        this.undergraduate_institution = undergraduate_institution;
        this.undergraduate_year_of_graduation = undergraduate_year_of_graduation;
        this.postgraduate_course = postgraduate_course;
        this.postgraduate_institution = postgraduate_institution;
        this.postgraduate_year_of_graduation = postgraduate_year_of_graduation;
        this.current_work_and_living_country = current_work_and_living_country;
        this.mentoring_preference = mentoring_preference;
        this.howFindOMM = howFindOMM;
        this.bio = bio;
        this.extra_info = extra_info;
        this.new_to_mentory = new_to_mentory;
        this.getHowFindOMM = getHowFindOMM;
    }




	public Integer getMentor_id() {
		return this.mentor_id;
	}

	public void setMentor_id(Integer mentor_id) {
		this.mentor_id = mentor_id;
	}

	public String getMentor_password() {
		return this.mentor_password;
	}

	public void setMentor_password(String mentor_password) {
		this.mentor_password = mentor_password;
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

	public String getIwi_afiliation() {
		return this.iwi_afiliation;
	}

	public void setIwi_afiliation(String iwi_afiliation) {
		this.iwi_afiliation = iwi_afiliation;
	}

	public String getCompany_name() {
		return this.company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getEmployer_job_title() {
		return this.employer_job_title;
	}

	public void setEmployer_job_title(String employer_job_title) {
		this.employer_job_title = employer_job_title;
	}

	public String getJob_title_department() {
		return this.job_title_department;
	}

	public void setJob_title_department(String job_title_department) {
		this.job_title_department = job_title_department;
	}

	public String getIndustry() {
		return this.industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getPrimary_working_industry() {
		return this.primary_working_industry;
	}

	public void setPrimary_working_industry(String primary_working_industry) {
		this.primary_working_industry = primary_working_industry;
	}

	public String getBrief_career_history() {
		return this.brief_career_history;
	}

	public void setBrief_career_history(String brief_career_history) {
		this.brief_career_history = brief_career_history;
	}

	public String getMode_of_mentoring_sessions() {
		return this.mode_of_mentoring_sessions;
	}

	public void setMode_of_mentoring_sessions(String mode_of_mentoring_sessions) {
		this.mode_of_mentoring_sessions = mode_of_mentoring_sessions;
	}

	public String getUndergraduate_course() {
		return this.undergraduate_course;
	}

	public void setUndergraduate_course(String undergraduate_course) {
		this.undergraduate_course = undergraduate_course;
	}

	public String getUndergraduate_institution() {
		return this.undergraduate_institution;
	}

	public void setUndergraduate_institution(String undergraduate_institution) {
		this.undergraduate_institution = undergraduate_institution;
	}

	public String getUndergraduate_year_of_graduation() {
		return this.undergraduate_year_of_graduation;
	}

	public void setUndergraduate_year_of_graduation(String undergraduate_year_of_graduation) {
		this.undergraduate_year_of_graduation = undergraduate_year_of_graduation;
	}

	public String getPostgraduate_course() {
		return this.postgraduate_course;
	}

	public void setPostgraduate_course(String postgraduate_course) {
		this.postgraduate_course = postgraduate_course;
	}

	public String getPostgraduate_institution() {
		return this.postgraduate_institution;
	}

	public void setPostgraduate_institution(String postgraduate_institution) {
		this.postgraduate_institution = postgraduate_institution;
	}

	public String getPostgraduate_year_of_graduation() {
		return this.postgraduate_year_of_graduation;
	}

	public void setPostgraduate_year_of_graduation(String postgraduate_year_of_graduation) {
		this.postgraduate_year_of_graduation = postgraduate_year_of_graduation;
	}

	public String getCurrent_work_and_living_country() {
		return this.current_work_and_living_country;
	}

	public void setCurrent_work_and_living_country(String current_work_and_living_country) {
		this.current_work_and_living_country = current_work_and_living_country;
	}

	public String getMentoring_preference() {
		return this.mentoring_preference;
	}

	public void setMentoring_preference(String mentoring_preference) {
		this.mentoring_preference = mentoring_preference;
	}

	public String getHowFindOMM;() {
		return this.howFindOMM;;
	}

	public void setHowFindOMM;(String howFindOMM;) {
		this.howFindOMM; = howFindOMM;;
	}

	public String getBio() {
		return this.bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getExtra_info() {
		return this.extra_info;
	}

	public void setExtra_info(String extra_info) {
		this.extra_info = extra_info;
	}

	public Boolean getNew_to_mentory() {
		return this.new_to_mentory;
	}

	public void setNew_to_mentory(Boolean new_to_mentory) {
		this.new_to_mentory = new_to_mentory;
	}


    @Override
    public String toString() {
        return "{" +
            " mentor_id='" + mentor_id + "'" +
            ", mentor_password='" + mentor_password + "'" +
            ", fName='" + fName + "'" +
            ", lName='" + lName + "'" +
            ", email='" + email + "'" +
            ", phoneNumber='" + phoneNumber + "'" +
            ", ethnicity='" + ethnicity + "'" +
            ", iwi_afiliation='" + iwi_afiliation + "'" +
            ", company_name='" + company_name + "'" +
            ", employer_job_title='" + employer_job_title + "'" +
            ", job_title_department='" + job_title_department + "'" +
            ", industry='" + industry + "'" +
            ", primary_working_industry='" + primary_working_industry + "'" +
            ", brief_career_history='" + brief_career_history + "'" +
            ", mode_of_mentoring_sessions='" + mode_of_mentoring_sessions + "'" +
            ", undergraduate_course='" + undergraduate_course + "'" +
            ", undergraduate_institution='" + undergraduate_institution + "'" +
            ", undergraduate_year_of_graduation='" + undergraduate_year_of_graduation + "'" +
            ", postgraduate_course='" + postgraduate_course + "'" +
            ", postgraduate_institution='" + postgraduate_institution + "'" +
            ", postgraduate_year_of_graduation='" + postgraduate_year_of_graduation + "'" +
            ", current_work_and_living_country='" + current_work_and_living_country + "'" +
            ", mentoring_preference='" + mentoring_preference + "'" +
            ", howFindOMM='" + howFindOMM + "'" +
            ", bio='" + bio + "'" +
            ", extra_info='" + extra_info + "'" +
            ", new_to_mentory='" + new_to_mentory + "'" +
            ", getHowFindOMM='" + getHowFindOMM + "'" +
            "}";
    }


    
}
