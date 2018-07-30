'use strict';
(function(){
    
    /******************************************
     **** services/api-service.js
     ******************************************/
    angular.module('vms').service('apiService', apiService);
    
    apiService.$inject  = ['$rootScope', '$log', '$http', '$filter', '_ENDPOINT_URI', '_CONSTANT'];

    function apiService ($rootScope, $log, $http, $filter, _ENDPOINT_URI, _CONSTANT) {
        var service = this;
        
        service.endpoint = _ENDPOINT_URI;
        
        service.get = function (uri, responseType) {
            return this.call(uri, 'GET', '', responseType);
        };
        service.del = function (uri, data, responseType) {
            return this.call(uri, 'DELETE', data, responseType);
        };
        service.put = function (uri, data, responseType) {
            return this.call(uri, 'PUT', data, responseType);
        };
        service.post = function (uri, data, responseType) {
            return this.call(uri, 'POST', data, responseType);
        };
        
        service.getBaseUri = function() {
            return _ENDPOINT_URI;
        };
        
        service.call = function (uri, method, data, responseType) {
                        
            return $http({
                method  : method,
                url     : _ENDPOINT_URI + uri,
                data    : data,
                responseType    : responseType,
                headers : { 
                    'Content-Type'        : 'application/json; charset=' + _CONSTANT._ENCODING,
                    'Cache-Control'       : 'no-cache',
                    'Pragma'              : 'no-cache'
                }
            }).then(
                function(results) {
                    return results;
                }
            );
        }
    }
})();