'use strict';
(function(){
    
    /******************************************
     **** config.js
     ******************************************/
    angular.module('vms')
    
    /*** CONSTANT ***/
    .constant('_CONSTANT'    , 
    {
    	'_DEFAULT_PAGE_SIZE'            : 20,
    	'_DEFAULT_PAGE_SIZE_OPTS'       : [10,20,50,100],
        '_ENCODING'                     : 'UTF-8',
        '_HTML5_MODE'                   : true,
        '_PAS_SOURCE'                   : false,
        "_STATES"                    :
        {
            'HOME'                              :'home',
            'ERROR'                             :'error',
            'VEHICLES'                          :'veh',
            'VEHICLES_VIEW'                     :'veh.view',
            'VEHICLES_ADD'                      :'veh.add',
            'VEHICLES_EDIT'                     :'veh.edit'
        }
    })
    .constant('_ENDPOINT_URI'                   , 'http'+((ssl)?'s':'')+'://'+hostname+':'+port+'/'+context+'/api/v1')

    
    /*** CONFIG ***/
    ;
    
})();