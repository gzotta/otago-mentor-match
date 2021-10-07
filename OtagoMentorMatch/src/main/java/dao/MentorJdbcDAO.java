package dao;

import domain.Mentor;
import helpers.ScryptHelper;
import auth.CredentialsValidator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Taine Bayly
 */
public class MentorJdbcDAO implements CredentialsValidator {

    private String databaseURI = DbConnection.getDefaultConnectionUri();

    // default constructor.
    public MentorJdbcDAO() {
    }

    // constructor that intialises the URI.
    public MentorJdbcDAO(String databaseURI) {
        this.databaseURI = databaseURI;
    }

    // method to save Mentor.
    public void saveMentor(Mentor mentor) {
        String sql = "INSERT INTO mentor (mentor_password, fname, lname, email, phone_number, ethnicity, iwi_afiliation, company_name, employer_job_title, job_title_department, primary_working_industry, brief_career_history, mode_of_mentoring_sessions, undergraduate_course, undergraduate_institution, undergraduate_year_of_graduation, postgraduate_course, postgraduate_institution, postgraduate_year_of_graduation, current_working_and_living_country, mentoring_preference, how_find_omm, bio, extra_info, new_to_mentory) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        String hash = ScryptHelper.hash(mentor.getMentorPassword()).toString();

        try (
                // get connection to database.
                Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement.
                PreparedStatement stmt = dbCon.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            // copy the data from the Mentee domain object into the SQL parameters.
            stmt.setString(1, hash);
            stmt.setString(2, mentor.getFName());
            stmt.setString(3, mentor.getLName());
            stmt.setString(4, mentor.getEmail());
            stmt.setString(5, mentor.getPhoneNumber());
            stmt.setString(6, mentor.getEthnicity());
            stmt.setString(7, mentor.getIwiAfiliation());
            stmt.setString(8, mentor.getCompanyName());
            stmt.setString(9, mentor.getEmployerJobTitle());
            stmt.setString(10, mentor.getJobTitleDepartment());
            stmt.setString(11, mentor.getPrimaryWorkingIndustry());
            stmt.setString(12, mentor.getBriefCareerHistory());
            stmt.setString(13, mentor.getModeOfMentoringSessions());
            stmt.setString(14, mentor.getUndergraduateCourse());
            stmt.setString(15, mentor.getUndergraduateInstitution());
            stmt.setString(16, mentor.getUndergraduateYearOfGraduation());
            stmt.setString(17, mentor.getPostgraduateCourse());
            stmt.setString(18, mentor.getPostgraduateInstitution());
            stmt.setString(19, mentor.getPostgraduateYearOfGraduation());
            stmt.setString(20, mentor.getCurrentWorkAndLivingCountry());
            stmt.setString(21, mentor.getMentoringPreference());
            stmt.setString(22, mentor.getHowFindOMM());
            stmt.setString(23, mentor.getBio());
            stmt.setString(24, mentor.getExtraInfo());
            stmt.setBoolean(25, mentor.getNewToMentory());

            stmt.executeUpdate(); // execute the statement.

            // getting generated keys and adding it to domain.
            Integer id = null;
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            } else {
                throw new DAOException("Problem getting generated Mentor ID");
            }

            mentor.setMentorId(id);

        } catch (SQLException ex) { // we are forced to catch SQLException.
            // don't let the SQLException leak from our DAO encapsulation.
            throw new DAOException(ex.getMessage(), ex);
        }
    }// end of method to save Mentor

    // Method to validate credentials for Mentors.
    @Override
    public Boolean validateCredentials(String email, String password) {

        try (

                // get connection to database.
                Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement.
                PreparedStatement stmt = dbCon
                        .prepareStatement("select mentor_password from mentor where email = ?");) {

            // copy the data from the Mentee domain object into the SQL parameters.
            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery(); // execute query.

            if (rs.next()) {
                String hash = rs.getString("mentor_password");

                // check that the password matches the hash
                return ScryptHelper.check(hash, password);
            } else {
                // no matching email
                return false;
            }

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }// end of method to validate Mentors.

    // Method to GET all Mentors.
    public Collection<Mentor> getMentors() {

        String sql = "select * from Mentor";
        try (
                // get connection to database.
                Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement.
                PreparedStatement stmt = dbCon.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            ResultSet rs = stmt.executeQuery(); // execute the query

            List<Mentor> mentors = new ArrayList<>(); // using list to preserve data order

            // iterate through query results
            while (rs.next()) {

                Integer mentorId = rs.getInt("mentor_id");
                String password = rs.getString("mentor_password");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String email = rs.getString("email");
                String phone_number = rs.getString("phone_number");
                String ethnicity = rs.getString("ethnicity");
                String iwi_afiliation = rs.getString("iwi_afiliation");
                String company_name = rs.getString("company_name");
                String employer_job_title = rs.getString("employer_job_title");
                String job_title_department = rs.getString("job_title_department");
                String primary_working_industry = rs.getString("primary_working_industry");
                String brief_career_history = rs.getString("brief_career_history");
                String mode_of_mentoring_sessions = rs.getString("mode_of_mentoring_sessions");
                String undergraduate_course = rs.getString("undergraduate_course");
                String undergraduate_institution = rs.getString("undergraduate_institution");
                String undergraduate_year_of_graduation = rs.getString("undergraduate_year_of_graduation");
                String postgraduate_course = rs.getString("postgraduate_course");
                String postgraduate_institution = rs.getString("postgraduate_institution");
                String postgraduate_year_of_graduation = rs.getString("postgraduate_year_of_graduation");
                String current_working_and_living_country = rs.getString("current_working_and_living_country");
                String mentoring_preference = rs.getString("mentoring_preference");
                String how_find_omm = rs.getString("how_find_omm");
                String bio = rs.getString("bio");
                String extra_info = rs.getString("extra_info");
                boolean new_to_mentory = rs.getBoolean("new_to_mentory");

                // use the data to create a Mentor object.
                Mentor mentor = new Mentor();
                mentor.setMentorId(mentorId);
                mentor.setMentorPassword(password);
                mentor.setFName(fname);
                mentor.setLName(lname);
                mentor.setEmail(email);
                mentor.setPhoneNumber(phone_number);
                mentor.setEthnicity(ethnicity);
                mentor.setIwiAfiliation(iwi_afiliation);
                mentor.setCompanyName(company_name);
                mentor.setEmployerJobTitle(employer_job_title);
                mentor.setJobTitleDepartment(job_title_department);
                mentor.setPrimaryWorkingIndustry(primary_working_industry);
                mentor.setBriefCareerHistory(brief_career_history);
                mentor.setModeOfMentoringSessions(mode_of_mentoring_sessions);
                mentor.setUndergraduateCourse(undergraduate_course);
                mentor.setUndergraduateInstitution(undergraduate_institution);
                mentor.setUndergraduateYearOfGraduation(undergraduate_year_of_graduation);
                mentor.setPostgraduateCourse(postgraduate_course);
                mentor.setPostgraduateInstitution(postgraduate_institution);
                mentor.setPostgraduateYearOfGraduation(postgraduate_year_of_graduation);
                mentor.setCurrentWorkAndLivingCountry(current_working_and_living_country);
                mentor.setMentoringPreference(mentoring_preference);
                mentor.setHowFindOMM(how_find_omm);
                mentor.setBio(bio);
                mentor.setExtraInfo(extra_info);
                mentor.setNewToMentory(new_to_mentory);

                mentors.add(mentor); // put it in the collection
            }

            return mentors;

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    // method to get Mentor by email.
    // support method only - used by validateCredentials() below.
    public Mentor getMentorByEmail(String email) {
        String sql = "SELECT * FROM mentor WHERE email = ?";

        try (
                // get a connection to the database.
                Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement.
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the Mentee domain object into the SQL parameters.
            stmt.setString(1, email);
            // execute the query.
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // get the data out of the query.
                // email not included; count should be 26 get's
                Integer mentorId = rs.getInt("mentor_id");
                String password = rs.getString("mentor_password");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String phone_number = rs.getString("phone_number");
                String ethnicity = rs.getString("ethnicity");
                String iwi_afiliation = rs.getString("iwi_afiliation");
                String company_name = rs.getString("company_name");
                String employer_job_title = rs.getString("employer_job_title");
                String job_title_department = rs.getString("job_title_department");
                String primary_working_industry = rs.getString("primary_working_industry");
                String brief_career_history = rs.getString("brief_career_history");
                String mode_of_mentoring_sessions = rs.getString("mode_of_mentoring_sessions");
                String undergraduate_course = rs.getString("undergraduate_course");
                String undergraduate_institution = rs.getString("undergraduate_institution");
                String undergraduate_year_of_graduation = rs.getString("undergraduate_year_of_graduation");
                String postgraduate_course = rs.getString("postgraduate_course");
                String postgraduate_institution = rs.getString("postgraduate_institution");
                String postgraduate_year_of_graduation = rs.getString("postgraduate_year_of_graduation");
                String current_working_and_living_country = rs.getString("current_working_and_living_country");
                String mentoring_preference = rs.getString("mentoring_preference");
                String how_find_omm = rs.getString("how_find_omm");
                String bio = rs.getString("bio");
                String extra_info = rs.getString("extra_info");
                boolean new_to_mentory = rs.getBoolean("new_to_mentory");

                // use the data to create a Mentor object.
                Mentor mentor = new Mentor();
                mentor.setMentorId(mentorId);
                mentor.setMentorPassword(password);
                mentor.setFName(fname);
                mentor.setLName(lname);
                mentor.setPhoneNumber(phone_number);
                mentor.setEthnicity(ethnicity);
                mentor.setIwiAfiliation(iwi_afiliation);
                mentor.setCompanyName(company_name);
                mentor.setEmployerJobTitle(employer_job_title);
                mentor.setJobTitleDepartment(job_title_department);
                mentor.setPrimaryWorkingIndustry(primary_working_industry);
                mentor.setBriefCareerHistory(brief_career_history);
                mentor.setModeOfMentoringSessions(mode_of_mentoring_sessions);
                mentor.setUndergraduateCourse(undergraduate_course);
                mentor.setUndergraduateInstitution(undergraduate_institution);
                mentor.setUndergraduateYearOfGraduation(undergraduate_year_of_graduation);
                mentor.setPostgraduateCourse(postgraduate_course);
                mentor.setPostgraduateInstitution(postgraduate_institution);
                mentor.setPostgraduateYearOfGraduation(postgraduate_year_of_graduation);
                mentor.setCurrentWorkAndLivingCountry(current_working_and_living_country);
                mentor.setMentoringPreference(mentoring_preference);
                mentor.setHowFindOMM(how_find_omm);
                mentor.setBio(bio);
                mentor.setExtraInfo(extra_info);
                mentor.setNewToMentory(new_to_mentory);

                return mentor;
            } else {
                return null;
            }
        } catch (SQLException ex) { // we are forced to catch SQLException.
            // don't let the SQLException leak from our DAO encapsulation.
            throw new DAOException(ex.getMessage(), ex);
        }
    }// end of method to get Mentor by email.

    // method to delete Mentor.
    public void removeMentor(Mentor mentor) {
        String sql = "DELETE FROM mentor WHERE email = ?";

        try (
                // get connection to database.
                Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement.
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the Mentee domain object into the SQL parameters.
            stmt.setString(1, mentor.getEmail());
            stmt.executeUpdate(); // execute the statement

        } catch (SQLException ex) { // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }// end of method to delete Mentor.

    // method to GET Mentor by industry.
    public Collection<Mentor> getMentorByIndustry(String primaryWorkingIndustry) {

        String sql = "SELECT * FROM mentor WHERE primary_working_industry = ?";
        try (
                // get connection to database.
                Connection dbCon = DbConnection.getConnection(databaseURI);
                // create the statement.
                PreparedStatement stmt = dbCon.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ) {

            stmt.setString(1, primaryWorkingIndustry);
            ResultSet rs = stmt.executeQuery(); // execute the query
            // copy the data from the Mentee domain object into the SQL parameters.

            List<Mentor> mentors = new ArrayList<>(); // using list to preserve data order

            // iterate through query results
            while (rs.next()) {

                Integer mentorId = rs.getInt("mentor_id");
                String password = rs.getString("mentor_password");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String email = rs.getString("email");
                String phone_number = rs.getString("phone_number");
                String ethnicity = rs.getString("ethnicity");
                String iwi_afiliation = rs.getString("iwi_afiliation");
                String company_name = rs.getString("company_name");
                String employer_job_title = rs.getString("employer_job_title");
                String job_title_department = rs.getString("job_title_department");
                String primaryworking_industry = rs.getString("primary_working_industry");
                String brief_career_history = rs.getString("brief_career_history");
                String mode_of_mentoring_sessions = rs.getString("mode_of_mentoring_sessions");
                String undergraduate_course = rs.getString("undergraduate_course");
                String undergraduate_institution = rs.getString("undergraduate_institution");
                String undergraduate_year_of_graduation = rs.getString("undergraduate_year_of_graduation");
                String postgraduate_course = rs.getString("postgraduate_course");
                String postgraduate_institution = rs.getString("postgraduate_institution");
                String postgraduate_year_of_graduation = rs.getString("postgraduate_year_of_graduation");
                String current_working_and_living_country = rs.getString("current_working_and_living_country");
                String mentoring_preference = rs.getString("mentoring_preference");
                String how_find_omm = rs.getString("how_find_omm");
                String bio = rs.getString("bio");
                String extra_info = rs.getString("extra_info");
                boolean new_to_mentory = rs.getBoolean("new_to_mentory");

                // use the data to create a Mentor object.
                Mentor mentor = new Mentor();
                mentor.setMentorId(mentorId);
                mentor.setMentorPassword(password);
                mentor.setFName(fname);
                mentor.setLName(lname);
                mentor.setEmail(email);
                mentor.setPhoneNumber(phone_number);
                mentor.setEthnicity(ethnicity);
                mentor.setIwiAfiliation(iwi_afiliation);
                mentor.setCompanyName(company_name);
                mentor.setEmployerJobTitle(employer_job_title);
                mentor.setJobTitleDepartment(job_title_department);
                mentor.setPrimaryWorkingIndustry(primaryworking_industry);

                mentor.setBriefCareerHistory(brief_career_history);
                mentor.setModeOfMentoringSessions(mode_of_mentoring_sessions);
                mentor.setUndergraduateCourse(undergraduate_course);
                mentor.setUndergraduateInstitution(undergraduate_institution);
                mentor.setUndergraduateYearOfGraduation(undergraduate_year_of_graduation);
                mentor.setPostgraduateCourse(postgraduate_course);
                mentor.setPostgraduateInstitution(postgraduate_institution);
                mentor.setPostgraduateYearOfGraduation(postgraduate_year_of_graduation);
                mentor.setCurrentWorkAndLivingCountry(current_working_and_living_country);
                mentor.setMentoringPreference(mentoring_preference);
                mentor.setHowFindOMM(how_find_omm);
                mentor.setBio(bio);
                mentor.setExtraInfo(extra_info);
                mentor.setNewToMentory(new_to_mentory);

                mentors.add(mentor); // put it in the collection
            }

            return mentors;

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

}// end of MentorJdbcDAO class.
