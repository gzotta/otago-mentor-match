CREATE TABLE admin (
    admin_id int AUTO_INCREMENT UNIQUE,
    password varchar(200) NOT NULL,
    fname varchar(50) NOT NULL,
    lname varchar (50) NOT NULL,
    email varchar (50) NOT NULL UNIQUE,
    phone_number varchar(20) NOT NULL,
    CONSTRAINT admin_PK PRIMARY KEY (admin_id)
);


CREATE TABLE mentor (
    mentor_id int AUTO_INCREMENT UNIQUE,
    mentor_password varchar(200) NOT NULL,
    fname varchar(50) NOT NULL,
    lname varchar (50) NOT NULL,
    email varchar(50) NOT NULL UNIQUE,
    phone_number varchar(20) NOT NULL,
    ethnicity varchar (50) NOT NULL,
    iwi_afiliation varchar (50),
    company_name varchar (50) NOT NULL,
    employer_job_title varchar (50) NOT NULL,
    job_title_department varchar (50) NOT NULL,
    primary_working_industry varchar (60) NOT NULL,
    brief_career_history varchar (1150) NOT NULL,
    mode_of_mentoring_sessions varchar (80) NOT NULL,
    undergraduate_course varchar (150) NOT NULL,
    undergraduate_institution varchar (150) NOT NULL,
    undergraduate_year_of_graduation varchar (5) NOT NULL,
    postgraduate_course varchar (150),
    postgraduate_institution varchar (150),
    postgraduate_year_of_graduation varchar (5),
    current_working_and_living_country varchar (50) NOT NULL,
    mentoring_preference varchar (50) NOT NULL,
    how_find_omm varchar (80) NOT NULL,
    bio varchar (1150) NOT NULL,
    extra_info varchar (1150) ,
    new_to_mentory varchar (50) NOT NULL,
    CONSTRAINT mentor_PK PRIMARY KEY (mentor_id)
    
);


CREATE TABLE mentee (
    mentee_id int AUTO_INCREMENT UNIQUE,
    password varchar(200) NOT NULL,
    fname varchar(50) NOT NULL,
    lname varchar (50) NOT NULL,
    phone_number varchar(20) NOT NULL,
    email varchar(50) NOT NULL UNIQUE,
    year_of_study varchar(50) NOT NULL,
    motivation_for_joining_omm varchar(1150) NOT NULL,
    industry_of_interest varchar(60) NOT NULL,
    learning_method varchar(80) NOT NULL,
    personal_interests varchar(1150) NOT NULL,
    how_find_omm varchar(80) NOT NULL,
    random_matching varchar(3) NOT NULL,
    bio varchar(1150) NOT NULL,
    CONSTRAINT mentee_PK PRIMARY KEY (mentee_id)
);



CREATE TABLE match_table (
    match_id int AUTO_INCREMENT UNIQUE,
    date varchar(50) NOT NULL,
    mentor_id int NOT NULL,
    mentee_id int NOT NULL,
    CONSTRAINT match_table_PK PRIMARY KEY (match_id),
    CONSTRAINT match_table_mentor_FK FOREIGN KEY (mentor_id) REFERENCES mentor(mentor_id),
    CONSTRAINT match_table_mentee_FK FOREIGN KEY (mentee_id) REFERENCES mentee(mentee_id)
);


CREATE TABLE journal_entry (
    journal_entry_id int AUTO_INCREMENT,
    topics_covered varchar(1150) NOT NULL,
    length_of_session varchar(20) NOT NULL,
    notes varchar(1150),
    match_id int NOT NULL,
    CONSTRAINT journal_entry_PK PRIMARY KEY (journal_entry_id),
    CONSTRAINT journal_entry_match_table FOREIGN KEY (match_id) REFERENCES match_table(match_id)
);

CREATE TABLE mentee_feedback_form (
    mentee_feedback_form_id int AUTO_INCREMENT,
    communication_platform varchar(50) NOT NULL,
    finding_omm varchar (150) NOT NULL,
    session_quality varchar(150) NOT NULL,
    quality_of_match varchar(50) NOT  NULL,
    recommendation varchar(10) NOT NULL,
    active_listening_rating varchar(50) NOT NULL,
    feedback_rating varchar(50) NOT NULL,
    trust_rating varchar(50) NOT NULL,
    achieve_goal_rating varchar(50) NOT NULL,
    developing_strategies_rating varchar(50) NOT NULL,
    motivation_rating varchar(50) NOT NULL,
    working_load_rating varchar(50) NOT NULL,
    programme_improvements varchar(1150) NOT NULL,
    time_contributed varchar(50) NOT NULL,
    continue_relationship varchar(20) NOT NULL,
    testimonial varchar(20) NOT NULL,
    other_comments varchar(1150),
    takeaways varchar(1150),
    mentee_id int NOT NULL,
    CONSTRAINT mentee_feedback_form_PK PRIMARY KEY (mentee_feedback_form_id),
    CONSTRAINT mentee FOREIGN KEY (mentee_id) REFERENCES mentee(mentee_id)
);

CREATE TABLE mentor_feedback_form (
    mentor_feedback_form_id int AUTO_INCREMENT,
    finding_omm varchar(150) NOT NULL,
    enough_time_to_establish_relationship varchar(90) NOT NULL,
    describe_sessions varchar(1150) NOT NULL,
    active_listening_rating varchar(50) NOT NULL,
    feedback_rating varchar(50) NOT NULL,
    trust_rating varchar(50) NOT NULL,
    achieve_goal_rating varchar(50) NOT NULL,
    developing_strategies_rating varchar(50) NOT NULL,
    motivation_rating varchar(50) NOT NULL,
    working_goals_rating varchar(50) NOT NULL,
    suitable_match varchar(50) NOT NULL, 
    recommendation varchar(10), 
    potential_improvements varchar(1150),
    time_contributed varchar(50) NOT NULL,
    continue_relationship varchar(20) NOT NULL,
    join_next_intake varchar(20) NOT NULL,
    testimonial varchar(20) NOT NULL,
    takeaways varchar(1150),
    mentor_id int NOT NULL,
    CONSTRAINT mentor_feedback_form_PK PRIMARY KEY (mentor_feedback_form_id),
    CONSTRAINT mentor FOREIGN KEY (mentor_id) REFERENCES mentor(mentor_id)
);


CREATE TABLE workshop (
    workshop_id int AUTO_INCREMENT,
    topic varchar(50) NOT NULL,
    date datetime NOT NULL,
    location varchar(80) NOT NULL,
    online varchar(3) NOT NULL,
    mentor varchar(3) NOT NULL,
    mentee varchar(3) NOT NULL,
    CONSTRAINT Workshop_PK PRIMARY KEY (workshop_id)

);

CREATE TABLE user (
    user_password varchar(200) NOT NULL,
    user_email varchar(50) NOT NULL UNIQUE,
    CONSTRAINT users_PK PRIMARY KEY (user_password, user_email)
);



/*Drop table statements
DROP TABLE admin;
DROP TABLE mentor;
DROP TABLE mentee;
DROP TABLE Match;
DROP TABLE journal_entry;
DROP TABLE mentee_feedback_form;
DROP TABLE Workshop;
DROPT TABLE users;
*/