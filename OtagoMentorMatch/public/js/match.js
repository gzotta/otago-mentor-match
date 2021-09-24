"use strict";

/*
 * AngularJS module for the match app, and other plugglable modules.
 * ngResource = REST resource, ngStorage = local storage module.
 */
var module = angular.module("MatchingApp", ["ngResource", "ngStorage"]);

///////Mentor Factories///////

// Factory for the ngResource object that will get the all the Mentors from the web service.
module.factory("registerMentorAPI", function($resource) {
    return $resource("/api/registerMentor");
});

// Factory for the ngResource object that will get a Mentor by email from the web service.
module.factory("mentorsAPI", function($resource) {
    return $resource("/api/mentors/:email");
});

///////////////////////////////////////////////
// Controller for managing Mentor resources //
/////////////////////////////////////////////
module.controller("MentorController", function(registerMentorAPI, mentorsAPI, $window) {
    alert("on controller")
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
});