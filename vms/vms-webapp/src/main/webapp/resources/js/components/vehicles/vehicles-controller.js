'use strict';
(function(){
    
    /******************************************
     **** components/vehicles/vehicles-controller.js
     ******************************************/
    angular.module('vms').controller('vehiclesController', vehiclesController);
    
    vehiclesController.$inject  = ['$rootScope', '$scope', '$log', '$state', '$stateParams', 'NgTableParams', 'modelFactory', 'vehiclesService'];

    function vehiclesController ($rootScope, $scope, $log, $state, $stateParams, NgTableParams, modelFactory, vehiclesService) {

        $scope.initialize = function() {
            $log.debug("vehicles-controller.js - initialize() - START: vehiclesController");
            $rootScope.initController($state, $scope);
            
            $scope.filter = '';
            
            $scope.state = $state.current.name;
            $scope.vehicle = $stateParams.vehicle;
            
            if ($scope.state == $rootScope._CONSTANT._STATES.VEHICLES_EDIT && !$scope.vehicle) {
            	$state.go($rootScope._CONSTANT._STATES.VEHICLES_VIEW, {});
            }
            if ($scope.state != $rootScope._CONSTANT._STATES.VEHICLES_VIEW) {
            	$scope.hideAddVehicle = true;
            } else {
            	$scope.hideAddVehicle = false;
            }
            
            $scope.loadVehicles();
            $scope.loadVehicleTypes();
        };
        
        $scope.loadVehicles = function() {
            $scope.vehiclesTable = new NgTableParams({
                page    : 1,
                count    : $rootScope._CONSTANT._DEFAULT_PAGE_SIZE
            }, {
                total: 0,
                counts  : $rootScope._CONSTANT._DEFAULT_PAGE_SIZE_OPTS,
                getData: function(params) {
                        return vehiclesService.search(params.page(), params.count(), $scope.filter).then(function (data) {
                            params.total(data.totalElements);
                            
                            return data.content;
                            
                        }, function (error) {
                            params.total(0);
                            return [];
                        });
                }
            });
        };
        
        $scope.loadVehicleTypes = function() {
        	vehiclesService.getVehicleTypes().then(function(data) {
        		$scope.vehicleTypes = data;
        	}, function (error) {
        		$scope.vehicleTypes = [];
            });
        }
        
        $scope.addNew = function() {
        	if ($scope.form.$valid) {
        		vehiclesService.addVehicle($scope.vehicle).then(function(data) {
        			$state.go($rootScope._CONSTANT._STATES.VEHICLES_VIEW, {});
        		});
        	}
        };
        
        $scope.update = function() {
        	if ($scope.form.$valid) {
        		vehiclesService.updateVehicle($scope.vehicle).then(function(data) {
        			$state.go($rootScope._CONSTANT._STATES.VEHICLES_VIEW, {});
        		});
        	}
        };
        
        $scope.deleteVehicle = function(vehicle) {
    		vehiclesService.deleteVehicle(vehicle).then(function(data) {
    			$scope.vehiclesTable.reload();
    		});
        };
        
        $scope.changeTo = function(mode, data) {
        	$scope.hideAddVehicle = true;
        	if (mode == 'add') {
            	$state.go($rootScope._CONSTANT._STATES.VEHICLES_ADD, {});
        	} else if (mode == 'edit') {
            	$state.go($rootScope._CONSTANT._STATES.VEHICLES_EDIT, {vehicle: data});
        	}
        };
        
        $scope.search = function() {
        	$scope.vehiclesTable.reload();
        };
        
        // INIT
        $scope.initialize();
    }
    
})();