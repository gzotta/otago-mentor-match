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

// Controller for managing Mentor resources.
module.controller("MentorController", function(mentorAPI, mentorsAPI) {
    alert("in controller");
});