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
//
/////////////////////////

// Factory for the ngResource object that will post a Mentor to the web service. 
module.factory("registerMentorAPI", function($resource) {
    return $resource("/api/registerMentor");
});

// Factory for the ngResource object that will post a MentorFeedbackForm to the web service.
module.factory("saveMentorFeedbackFormAPI", function($resource) {
    return $resource("/api/mentorFeedbackForms");
});

// Factory for the ngResource object that will get a MentorFeedbackForm by id.
module.factory("getMentorFeedbackFormAPI", function($resource) {
    return $resource("/api/mentorFeedbackForms/:id");
});

///////////////////////////
//---Mentor Controler---//
/////////////////////////

// Controller for managing Mentor resources.
module.controller("MentorController", function(registerMentorAPI, saveMentorFeedbackFormAPI, getMentorFeedbackFormAPI, $window, $sessionStorage) {

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

///////////////////////////
//---Mentee Controler---//
/////////////////////////

// Controller for managing Mentee resources.
module.controller("MenteeController", function(registerMenteeAPI, saveMenteeFeedbackFormAPI, getMenteeFeedbackFormAPI, $sessionStorage, $window) {

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


    // Function to Sign Out for Mentee
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
///////////////////////////////Login (Sign Up) Resources Section///////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////
//-------Login Factories-------//
////////////////////////////////

// Factory for the ngResource object that will get a Mentor by email and then sign it in (Login). 
module.factory("mentorSignInAPI", function($resource) {
    return $resource("/api/mentors/mentor/:email");
});

// Factory for the ngResource object that will get a Mentee by email and then sign it in (Login). 
module.factory("menteeSignInAPI", function($resource) {
    return $resource("/api/mentees/:email");
});
// Factory for the ngResource object that will get a Mentee by email and then sign it in (Login). 
module.factory("adminSignInAPI", function($resource) {
    return $resource("/api/admins/:email");
});
//////////////////////////////////
//-------Login Controler-------//
////////////////////////////////

// Controller for managing Login (Sign Up) resources.
module.controller("LoginController", function(mentorSignInAPI, menteeSignInAPI, adminSignInAPI, $window, $http, $sessionStorage) {
    //Message for users (this message is called and changed within this.signIn method when Sign In fails).
    this.signInMessage = "Please login to continue.";
    // Alias 'this' so that we can access it inside callback functions.
    let ctrl = this;



    // Function to Sign In (Login) Mentor.
    this.loginUser = function(user) {
        if (user.type == "mentor") {
            // generate authentication token
            let authToken = $window.btoa(user.email + ":" + user.password);
            // store token
            $sessionStorage.authToken = authToken;
            // add token to the HTTP request headers
            $http.defaults.headers.common.Authorization = 'Basic ' + authToken;
            // get Mentee from database
            mentorSignInAPI.get({ 'email': user.email },
                // success callback
                function(user) {
                    // also store the retrieved mentor
                    $sessionStorage.mentor = user;
                    // set user type for content hiding
                    $sessionStorage.user1 = "mentor";
                    // redirect to home
                    $window.location = 'home.html';
                },
                // fail callback
                function() {
                    ctrl.signInMessage = 'Login failed. Please try again.';
                }
            );
        } else if (user.type == "mentee") {
            // generate authentication token
            let authToken = $window.btoa(user.email + ":" + user.password);
            // store token
            $sessionStorage.authToken = authToken;
            // add token to the HTTP request headers
            $http.defaults.headers.common.Authorization = 'Basic ' + authToken;

            // get Mentee from database
            menteeSignInAPI.get({ 'email': user.email },
                // success callback
                function(user) {
                    // also store the retrieved mentee
                    $sessionStorage.mentee = user;
                    // set user type for content hiding
                    $sessionStorage.user1 = "mentee";
                    // redirect to home
                    $window.location = 'home.html';
                },
                // fail callback
                function() {
                    ctrl.signInMessage = 'Login failed. Please try again.';
                }
            );
        } else {
            // generate authentication token
            let authToken = $window.btoa(user.email + ":" + user.password);
            // store token
            $sessionStorage.authToken = authToken;
            // add token to the HTTP request headers
            $http.defaults.headers.common.Authorization = 'Basic ' + authToken;

            // get admin from database
            adminSignInAPI.get({ 'email': user.email },
                // success callback
                function(user) {
                    // also store the retrieved admin
                    $sessionStorage.admin = user;
                    // set user type for content hiding
                    $sessionStorage.user1 = "admin";
                    // redirect to home
                    $window.location = 'home.html';
                },
                // fail callback
                function() {
                    ctrl.signInMessage = 'Login failed. Please try again.';
                }
            );
        }
    };


});



//////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////Match Resources Section///////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////


//////////////////////////////////
//-------Macth Factories-------//
////////////////////////////////

// Factory for the ngResource object that will get all Mentors by industry from the web service.
module.factory("mentorByIndustryAPI", function($resource) {
    return $resource("/api/mentors/:industry");
});

// Factory for the ngResource object that will get all Mentors from the web service.
module.factory("allMentorsAPI", function($resource) {
    return $resource("/api/mentors");
});

// Factory for the ngResource object that will POST a Match to the web service.
module.factory("saveMatchAPI", function($resource) {
    return $resource("/api/matches");
})

//////////////////////////////////
//-------Macth Controler-------//
////////////////////////////////
module.controller("MatchController", function(allMentorsAPI, mentorByIndustryAPI, saveMatchAPI, $sessionStorage, $window) {
    // load Mentors.
    this.mentors = allMentorsAPI.query();
    // load Mentors by industry.
    this.mentorByIndustry = mentorByIndustryAPI.query();

    // Click handler for the industry filter buttons.
    this.selectIndustry = function(selectedIndustry) {
        this.mentorByIndustry = mentorByIndustryAPI.query({ "industry": selectedIndustry });
    };

    // Function to select all Mentors.
    this.selectAll = function() {
        this.mentors = allMentorsAPI.query();
    };

    // Function to store MentorId in session storage
    this.storeMentorId = function(mentor) {
        console.log("storeMentorId called");
        $sessionStorage.mentorId = mentor.mentorId;

    };

    // Function to save (POST) a Match to the database.
    this.storeMatch = function() {

        let mentorId = $sessionStorage.mentorId;
        let menteeId = $sessionStorage.mentee.menteeId;
        let date = new Date().toISOString().substring(0, 10);
        let match = new Match(mentorId, menteeId, date);

        // save (POST) match into the database
        saveMatchAPI.save(null, match,
            // success callback
            function() {
                $window.location = 'home.html';
            },
            // Error callback
            function(error) {
                console.log(error);
            }
        );
    };

});







//////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////Admin Resources Section//////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////
//-----Admin Factories------//
////////////////////////////////
// Factory for the ngResource object that will post an Admin to the web service. 
module.factory("registerAdminAPI", function($resource) {
    return $resource("/api/admins");
});
//////////////////////////////////
//----Admin Controler-------//
////////////////////////////////
// Controller for managing Admin resources.
module.controller("AdminController", function(registerAdminAPI, $sessionStorage, $window) {

    // Function to save (Register) an Admin.
    this.registerAdmin = function(admin) {
        registerAdminAPI.save(null, admin,
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
});



//////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////Workshop Resources Section///////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////
//-----Workshop Factories------//
////////////////////////////////

//////////////////////////////////
//----Workshop Controler-------//
////////////////////////////////







//////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////JavaScript Support Classes///////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////


class Match {

    constructor(mentorId, menteeId, date) {
        this.mentorId = mentorId;
        this.menteeId = menteeId;
        this.date = date;
    }
}