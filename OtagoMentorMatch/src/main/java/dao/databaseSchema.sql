USE OMM;
CREATE TABLE Admin (
    adminId int AUTO_INCREMENT,
    password varchar(16) NOT NULL,
    fname varchar(15) NOT NULL,
    lname varchar (15) NOT NULL,
    phoneNumber varchar(13) NOT NULL,
    CONSTRAINT Admin_PK PRIMARY KEY (adminId)
);


CREATE TABLE Mentor (
    mentorId int AUTO_INCREMENT,
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
    menteeId int AUTO_INCREMENT,
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



CREATE TABLE MatchTable (
    matchId int AUTO_INCREMENT,
    date datetime NOT NULL,
    mentorId int NOT NULL,
    menteeId int NOT NULL,
    CONSTRAINT MatchTable_PK PRIMARY KEY (matchId),
    CONSTRAINT MatchTable_Mentor_FK FOREIGN KEY (mentorId) REFERENCES Mentor(mentorId),
    CONSTRAINT MatchTable_Mentee_FK FOREIGN KEY (menteeId) REFERENCES Mentee(menteeId)
);


CREATE TABLE JournalEntry (
    journalEntryId int AUTO_INCREMENT,
    topicsCovered varchar(100) NOT NULL,
    lengthOfSession varchar(15) NOT NULL,
    notes varchar(100),
    matchId int NOT NULL,
    CONSTRAINT JournalEntry_PK PRIMARY KEY (journalEntryId),
    CONSTRAINT JournalEntry_MatchTable FOREIGN KEY (matchId) REFERENCES MatchTable(matchId)
);

CREATE TABLE MenteeFeedbackForm(
    menteeFeedbackFormId int AUTO_INCREMENT,
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
    matchId int NOT NULL,
    CONSTRAINT MenteeFeedbackForm_PK PRIMARY KEY (menteeFeedbackFormId),
    CONSTRAINT MenteeFeedbackForm_MatchTable FOREIGN KEY (matchId) REFERENCES MatchTable(matchId)
);

CREATE TABLE Workshop (
    workshopId int AUTO_INCREMENT,
    topic varchar(20) NOT NULL,
    date datetime NOT NULL,
    location varchar(20) NOT NULL,
    online varchar(3) NOT NULL,
    mentor varchar(3) NOT NULL,
    mentee varchar(3) NOT NULL,
    CONSTRAINT Workshop_PK PRIMARY KEY (workshopId)

);


/*Drop table statements
DROP TABLE Admin;
DROP TABLE Mentor;
DROP TABLE Mentee;
DROP TABLE Match
DROP TABLE JournalEntry
DROP TABLE MenteeFeedbackForm
DROP TABLE Workshop
*/
