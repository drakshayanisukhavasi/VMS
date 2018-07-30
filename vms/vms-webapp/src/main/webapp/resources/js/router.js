'use strict';
(function(){
    
/******************************************
 **** routes.js
 ******************************************/
angular.module('vms')

.config(['$stateProvider', '$urlRouterProvider', '$locationProvider', '_CONSTANT',
    function($stateProvider, $urlRouterProvider, $locationProvider, _CONSTANT) {
        $urlRouterProvider.otherwise("/home");
        $urlRouterProvider.when("/home","/vehicles");
        
        $locationProvider.html5Mode({
            enabled        : _CONSTANT._HTML5_MODE
        });
        
        $stateProvider
        /*******************************************************
         * HOME
        *******************************************************/
        .state(_CONSTANT._STATES.VEHICLES, {
            template        : '<div ui-view></div>',
            abstract        : true
        })
        .state(_CONSTANT._STATES.VEHICLES_VIEW, {
            url                 : '/vehicles',
            templateUrl         : 'resources/js/components/vehicles/vehicles.html?v='+version,
            controller          : 'vehiclesController'
        })
        .state(_CONSTANT._STATES.VEHICLES_ADD, {
            url                 : '/add',
            templateUrl         : 'resources/js/components/vehicles/vehicles_maintain.html?v='+version,
            controller          : 'vehiclesController'
        })
        .state(_CONSTANT._STATES.VEHICLES_EDIT, {
            url                 : '/edit',
            templateUrl         : 'resources/js/components/vehicles/vehicles_maintain.html?v='+version,
            controller          : 'vehiclesController',
            params              : { vehicle: null }
        })
        ;
    }
]);

})();