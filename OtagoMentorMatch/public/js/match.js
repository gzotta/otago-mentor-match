"use strict";

/*
 * AngularJS module for the match app, and other plugglable modules.
 * ngResource = REST resource, ngStorage = local storage module.
 */
var module = angular.module("MatchingApp", ["ngResource", "ngStorage"]);

///////Mentor Factories and Controller///////

// Factory for the ngResource object that will get the all the Mentors from the web service.
module.factory("mentorAPI", function($resource) {
    return $resource("/api/mentors");
});

// Factory for the ngResource object that will get a Mentor by email from the web service.
module.factory("mentorsAPI", function($resource) {
    return $resource("/api/mentors/:email");
});

// factory for th ngResource object that will get the all the Mentees from the web service.
module.factory("registerMenteeAPI", function($resource){
    return $resource("/api/mentees");
});

//factor for the ngResource object that will get all the mentees by email from the web service.
module.factory("menteesAPI", function($resource){
    return $resource("/api/mentees/:email");
});

// factory for th ngResource object that will get the all the Mentees from the web service.
module.factory("registerMenteeFeedbackFormsAPI", function($resource){
    return $resource("/api/menteeFeedbackForms");
});
// Controller for managing Mentor resources.
module.controller(
    "MentorController",
    function(mentorAPI, mentorsAPI, $window) {
        //alert("in controller");

        this.registerMentor = function(mentor) {
            alert("Register Mentor");
            console.log(mentor);
        };
    }
);

// Controller for managing Mentee resources.
module.controller(
    "MenteeController",
    function(registerMenteeAPI, menteesAPI, $window) {
        alert("on controller");
        this.registerMentee = function(mentee) {
            alert("Register Mentee");
            console.log(mentee);
        };
    }
);
// Controller for managing Mentee Feedback forms.
module.controller(
    "MenteeFeedbackFormsController",
    function(registerMenteeFeedbackFormsAPI, $window) {
        alert("on controller");
        this.registerMenteeFeedbackForms = function(menteeFeedbackForms) {
            alert("fill in Mentee feedback form");
            console.log(menteeFeedbackForms);
        };
    }
);