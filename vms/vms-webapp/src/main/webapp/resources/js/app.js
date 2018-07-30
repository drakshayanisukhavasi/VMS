'use strict';
(function(){
    
    /******************************************
     **** Entry point for the AngularJS application
     **** 
     **** Define the application's name  and a list of mdoules (libraries)
     ******************************************/
    angular.module('vms', 
        [   'ngRoute',
            'ngMessages',
            'ngResource',
            'ngSanitize',
            'ui.router',
            'ngTable',
            'wt.responsive'
        ]);
})();