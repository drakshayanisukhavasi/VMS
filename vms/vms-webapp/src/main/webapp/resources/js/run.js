'use strict';
(function(){

    /******************************************
     **** run.js
     ******************************************/
    angular.module('vms')
    .run(['$rootScope', '$log', '$filter', '$sce', '$state', '$q', '$window', '$timeout', '$location', '_CONSTANT',  
          function($rootScope, $log, $filter, $sce, $state, $q, $window, $timeout, $location,  _CONSTANT) {
        // Common method to init controller (set title, clean alerts, ...)
        $rootScope.initController = function($state, $scope, controlParams) {
            
            $window.scrollTo(0, 0);
        };
        
        $rootScope._CONSTANT = _CONSTANT;
    }]);
})();