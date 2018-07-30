'use strict';
(function(){
    
    /******************************************
     **** common/service/modal-factory.js
     ******************************************/
    angular.module('vms').factory('modelFactory', modelFactory);
    
    modelFactory.$inject  = ['$log', '$q', '$rootScope', 'apiService'];

    function modelFactory ($log, $q, $rootScope, apiService) {
        var service = this;
        
        service.vehicle = function() {
            var vehicle = {};
            vehicle.type = '';
            vehicle.capacity = 0;
            vehicle.regNo = '';
            return vehicle;
        };
        
        return service;
    }
})();