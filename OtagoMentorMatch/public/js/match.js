"use strict";

/*
 * AngularJS module for the match app, and other plugglable modules.
 * ngResource = REST resource, ngStorage = local storage module.
 */
var module = angular.module("MatchingApp", ["ngResource", "ngStorage"]);



//////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////Mentor Resources Section///////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////
//---Mentor Factories---//
/////////////////////////

// Factory for the ngResource object that will post a Mentor to the web service. 
module.factory("registerMentorAPI", function($resource) {
    return $resource("/api/registerMentor");
});

// Factory for the ngResource object that will get a Mentor by email from the web service.
module.factory("mentorsAPI", function($resource) {
    return $resource("/api/mentors/:email");
});

// Factory for the ngResource object that will post a MentorFeedbackForm to the web service.
module.factory("saveMentorFeedbackFormAPI", function($resource) {
    return $resource("/api/mentorFeedbackForms");
});

// Factory for the ngResource object that will get a MentorFeedbackForm by id.
module.factory("getMentorFeedbackFormAPI", function($resource) {
    return $resource("/api/mentorFeedbackForms/:id");
});

// Factory for the ngResource object that will get a Mentor by email and then sign it in. 
module.factory("mentorSignInAPI", function($resource) {
    return $resource("/api/mentors/:email");
});

///////////////////////////
//---Mentor Controler---//
/////////////////////////

// Controller for managing Mentor resources.
module.controller("MentorController", function(registerMentorAPI, mentorsAPI, saveMentorFeedbackFormAPI, mentorSignInAPI, getMentorFeedbackFormAPI, $window, $http) {
    //Message for users (this message is called and changed within this.signIn method when Sign In fails).
    this.signInMessage = "Please login to continue.";
    // Alias 'this' so that we can access it inside callback functions.
    let ctrl = this;

    // Function to save (Register) a Mentor.
    this.registerMentor = function(mentor) {
        registerMentorAPI.save(null, mentor,
            // success callback
            function() {
                $window.location = 'index.html';
            },
            // erro callback
            function(error) {
                console.log(error);
            }
        );
    };


    // Function to Sign In Mentor.
    this.signIn = function(email, password) {
        // generate authentication token
        let authToken = $window.btoa(email + ":" + password);
        // store token
        $sessionStorage.authToken = authToken;
        // add token to the HTTP request headers
        $http.defaults.headers.common.Authorization = 'Basic ' + authToken;

        // get Mentee from database
        mentorSignInAPI.get({ 'email': email },
            // success callback
            function(mentor) {
                // also store the retrieved mentee
                $sessionStorage.mentor = mentor;
                // redirect to home
                $window.location = 'home.html';
            },
            // fail callback
            function() {
                ctrl.signInMessage = 'Login failed. Please try again.';
            }
        );

    };


    // Function to Sign out for Mentee
    this.signOut = function() {
        $sessionStorage.$reset();
        $window.location = 'index.html';
    };





    // Function to save a MentorFeedbackForm.
    this.saveMentorFeedbackForm = function(mentorFeedbackForm) {
        alert("fill in Mentor feedback form");
        console.log(mentorFeedbackForm);
    }


});


//////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////Mentee Resources Section///////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////
//---Mentee Factories---//
/////////////////////////

// Factory for the ngResource object that will register a Mentee to the web service.
module.factory("registerMenteeAPI", function($resource) {
    return $resource("/api/registerMentee");
});

// Factory for the ngResource object that will get a Mentee by email from the web service.
module.factory("menteesAPI", function($resource) {
    return $resource("/api/mentees/:email");
});

// Factory for the ngResource object that will save a MenteeFeedbackForm to the web service.
module.factory("saveMenteeFeedbackFormAPI", function($resource) {
    return $resource("/api/menteeFeedbackForms");
});

// Factory for the ngResource object that will get a MenteeFeedbackForm by id.
module.factory("getMenteeFeedbackFormAPI", function($resource) {
    return $resource("/api/menteeFeedbackForms/:id");
});

// Factory for the ngResource object that will get a Mentee by email and then sign it in. 
module.factory("menteeSignInAPI", function($resource) {
    return $resource("/api/mentees/:email");
});

///////////////////////////
//---Mentee Controler---//
/////////////////////////

// Controller for managing Mentee resources.
module.controller("MenteeController", function(menteeSignInAPI, registerMenteeAPI, menteesAPI, saveMenteeFeedbackFormAPI, getMenteeFeedbackFormAPI, $sessionStorage, $window, $http) {
    //Message for users (this message is called and changed within this.signIn method when Sign In fails).
    this.signInMessage = "Please login to continue.";
    // Alias 'this' so that we can access it inside callback functions.
    let ctrl = this;


    // Function to save (Register) a Mentee.
    this.registerMentee = function(mentee) {
        registerMenteeAPI.save(null, mentee,
            // success callback
            function() {
                $window.location = 'index.html';
            },
            // Error callback
            function(error) {
                console.log(error);
            }
        );
    };

    // Function to Sign In Mentee
    this.signIn = function(email, password) {
        // generate authentication token
        let authToken = $window.btoa(email + ":" + password);
        // store token
        $sessionStorage.authToken = authToken;
        // add token to the HTTP request headers
        $http.defaults.headers.common.Authorization = 'Basic ' + authToken;

        // get Mentee from database
        menteeSignInAPI.get({ 'email': email },
            // success callback
            function(mentee) {
                // also store the retrieved mentee
                $sessionStorage.mentee = mentee;
                // redirect to home
                $window.location = 'home.html';
            },
            // fail callback
            function() {
                ctrl.signInMessage = 'Login failed. Please try again.';
            }
        );

    };


    // Function to Sign out for Mentee
    this.signOut = function() {
        $sessionStorage.$reset();
        $window.location = 'index.html';
    };


    // Function to save a MenteeFeedbackForm.
    this.saveMenteeFeedbackForm = function(menteeFeedbackForm) {
        alert("fill in Mentee feedback form");
        console.log(menteeFeedbackForm);
    };



});



//////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////Journal Entry Resources Section///////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////


//////////////////////////////////
//---Journal Entry Factories---//
////////////////////////////////

// factory for the ngResource object that will post a Journal entry to the web service.
module.factory("journalEntriesAPI", function($resource) {
    return $resource("/api/journalEntries");
});

///////////////////////////////////
//---Journal Entry Controller---//
/////////////////////////////////

// Controller for managing Journal Entry forms.
module.controller("JournalEntriesController", function(journalEntriesAPI, $window) {
    alert("on controller");

    // Function to save (Post) a Journal Entry.
    this.saveJournalEntry = function(journalEntry) {
        alert("fill in Journal Entry");
        console.log(journalEntry);
    };
});


//////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////Match Resources Section///////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////
//-------Macth Factories-------//
////////////////////////////////

//////////////////////////////////
//-------Macth Controler-------//
////////////////////////////////






//////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////Workshop Resources Section///////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////
//-----Workshop Factories------//
////////////////////////////////

//////////////////////////////////
//----Workshop Controler-------//
////////////////////////////////