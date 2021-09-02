CREATE TABLE Admin (
    adminId int(1000) AUTO_INCREMENT,
    password varchar(16) NOT NULL,
    fname varchar(15) NOT NULL,
    lname varchar (15) NOT NULL,
    phoneNumber varchar(13) NOT NULL,
    CONSTRAINT Admin_PK PRIMARY KEY (adminId)
);


CREATE TABLE Mentor (
    mentorId int(1000) AUTO_INCREMENT,
    mentorPassword varchar(16) NOT NULL,
    fname varchar(15) NOT NULL,
    lname varchar (15) NOT NULL,
    email varchar(50) NOT NULL,
    phoneNumber varchar(13) NOT NULL,
    ethnicity varchar (20) NOT NULL,
    iwiAfilitation varchar (20) NOT NULL,
    companyName varchar (20) NOT NULL,
    employerJobTitle varchar (20) NOT NULL,
    jobTitleDepartment varchar (20) NOT NULL,
    industry varchar (20) NOT NULL,
    primaryWorkingIndustry varchar (20) NOT NULL,
    briefCareerHistory varchar (20) NOT NULL,
    modeOfMentoringSessions varchar (20) NOT NULL,
    undergraduateCourse varchar (20) NOT NULL,
    undergraduateInstitution varchar (20) NOT NULL,
    undergraduateYearOfGraduation varchar (4) NOT NULL,
    postgraduateCourse varchar (20) NOT NULL,
    postgraduateInstitution varchar (20) NOT NULL,
    postgraduateYearOfGraduation varchar (4) NOT NULL,
    currentWorkingAndLivingCountry varchar (20) NOT NULL,
    mentoringPreference varchar (20) NOT NULL,
    howFindOMM varchar (20) NOT NULL,
    bio varchar (100) NOT NULL,
    extraInfo varchar (100) NOT NULL,
    newToMentory varchar (3) NOT NULL,
    CONSTRAINT Mentor_PK PRIMARY KEY (mentorId)
    
);


CREATE TABLE Mentee (
    menteeId int(1000) AUTO_INCREMENT;
    password varchar(16) NOT NULL,
    fname varchar(15) NOT NULL,
    lname varchar (15) NOT NULL,
    phoneNumber varchar(13) NOT NULL,
    email varchar(50) NOT NULL,
    yearOfStudy varchar(4) NOT NULL,
    motivationForJoiningOMM varchar(100) NOT NULL,
    industryOfInterest varchar(20) NOT NULL,
    learningMethod varchar(20) NOT NULL,
    personalInterests varchar(50) NOT NULL,
    howFindOMM varchar(50) NOT NULL,
    randomMatching varchar(3) NOT NULL,
    bio varchar(100) NOT NULL,
    CONSTRAINT Mentee_PK PRIMARY KEY (menteeId)
);



CREATE TABLE Match (
    matchId int(1000) AUTO_INCREMENT,
    date datetime NOT NULL,
    mentorId varchar(1000) NOT NULL,
    menteeId varchar(1000) NOT NULL,
    CONSTRAINT Match_PK PRIMARY KEY (matchId),
    CONSTRAINT Match_Mentor FOREIGN KEY (mentorId),
    CONSTRAINT Match_Mentee FOREIGN KEY (menteeId)
);


CREATE TABLE JournalEntry (
    journalEntryId int(1000) AUTO_INCREMENT,
    topicsCovered varchar(100) NOT NULL,
    lengthOfSession varchar(15) NOT NULL,
    notes varchar(100),
    matchId varchar(1000) NOT NULL,
    CONSTRAINT JournalEntry_PK PRIMARY KEY (journalEntryId),
    CONSTRAINT JournalEntry_Match FOREIGN KEY (matchId) REFERENCES Match
);

CREATE TABLE MenteeFeedbackForm(
    menteeFeedbackFormId int(1000) AUTO_INCREMENT,
    communicationPlatform varchar(20) NOT NULL,
    findingOMM varchar (50) NOT NULL,
    sessionQuality varchar(20) NOT NULL,
    qualityOfMatch varchar(20) NOT  NULL,
    recommendation varchar(50) NOT NULL,
    activeListeningRating varchar(20) NOT NULL,
    feedbackRating varchar(20) NOT NULL,
    trustRating varchar(20) NOT NULL,
    achieveGoalsrating varchar(20) NOT NULL,
    developingStrategiesRating varchar(20) NOT NULL,
    motivationRating varchar(20) NOT NULL,
    workingLoadRating varchar(20) NOT NULL,
    programmeImprovements varchar(100) NOT NULL,
    timeContributed varchar(20) NOT NULL,
    continueRelationship varchar(3) NOT NULL,
    testimonial varchar(3) NOT NULL,
    otherComments varchar(50) NOT NULL,
    takeaways varchar(50) NOT NULL,
    matchId varchar(1000) NOT NULL.
    CONSTRAINT MenteeFeedbackForm_PK PRIMARY KEY (menteeFeedbackFormId),
    CONSTRAINT MenteeFeedbackForm_Match FOREIGN KEY (matchId) REFERENCES Match
);

CREATE TABLE Workshop (
    workshopId int(1000) AUTO_INCREMENT,
    topic varchar(20) NOT NULL,
    date datetime NOT NULL,
    location varchar(20) NOT NULL,
    online varchar(3) NOT NULL,
    mentor varchar(3) NOT NULL,
    mentee varchar(3) NOT NULL,
    CONSTRAINT Workshop_PK PRIMARY KEY (workshopId)

);