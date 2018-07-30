'use strict';
(function(){
    
    /******************************************
     **** common/service/vehicles-service.js
     ******************************************/
    angular.module('vms').service('vehiclesService', vehiclesService);
    
    vehiclesService.$inject  = ['$log', '$q', '$rootScope', 'apiService'];

    function vehiclesService ($log, $q, $rootScope, apiService) {
        var service = this;
        
        /* ***************************************
         * API
         * ************************************** */
        
        /**
         * search
         */
        service.search = function (page, size, filter) {
            return $q(function(resolve, reject)     {
                apiService.get('/vehicles/search/?page=' + page + '&size=' + size + '&filter=' + filter).then(function(result) {
                    resolve( result.data );
                }, function (error) {
                    reject(error);
                });
             });
        };
        
        service.getVehicleTypes = function (page, size, filter) {
            return $q(function(resolve, reject)     {
                apiService.get('/vehicles/types').then(function(result) {
                    resolve( result.data );
                }, function (error) {
                    reject(error);
                });
             });
        };
        
        service.addVehicle = function (vehicle) {
            return $q(function(resolve, reject)     {
                apiService.post('/vehicles/add', vehicle).then(function(result) {
                    resolve( result.data );
                }, function (error) {
                    reject(error);
                });
             });
        };
        
        service.updateVehicle = function (vehicle) {
            return $q(function(resolve, reject)     {
                apiService.put('/vehicles/update/' + vehicle.regNo, vehicle).then(function(result) {
                    resolve( result.data );
                }, function (error) {
                    reject(error);
                });
             });
        };
        
        service.deleteVehicle = function (vehicle) {
            return $q(function(resolve, reject)     {
                apiService.del('/vehicles/delete/' + vehicle.regNo, vehicle).then(function(result) {
                    resolve( result.data );
                }, function (error) {
                    reject(error);
                });
             });
        };
    }
})();