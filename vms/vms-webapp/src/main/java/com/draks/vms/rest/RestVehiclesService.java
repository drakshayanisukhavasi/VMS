package com.draks.vms.rest;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.draks.vms.exception.TechnicalException;
import com.draks.vms.model.Vehicle;
import com.draks.vms.model.VehicleType;
import com.draks.vms.service.VehiclesService;

@RequestMapping("/api/v1/vehicles")
@RestController
public class RestVehiclesService {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(RestVehiclesService.class);
    
    @Autowired
    private VehiclesService<Vehicle, String> vehicleService;

    @RequestMapping(value="/search/", method= RequestMethod.GET, consumes={MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody Page<Vehicle> getVehicle(
            @RequestParam(value = "page", defaultValue = "1", required = false) int pageNo,
            @RequestParam(value = "size", defaultValue = "20", required = false) int pageSize,
            @RequestParam(value = "filter", defaultValue = "", required = false) String search)
                    throws TechnicalException {
    	Page<Vehicle> pVehicles = new PageImpl<Vehicle>(vehicleService.get(search));
    	return pVehicles;
    }
    
    @RequestMapping(value="/add", method= RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED) @ResponseBody Vehicle addVehicle(
            @RequestBody Vehicle vehicle) 
                    throws TechnicalException {
    	return vehicleService.add(vehicle);
     }

    @RequestMapping(value="/update/{regNo}", method= RequestMethod.PUT, consumes={MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody Vehicle modifyVehicle(
    		@PathVariable String regNo,
            @RequestBody Vehicle vehicle) 
                    throws TechnicalException {
        return vehicleService.modify(vehicle, regNo);
    }
    
    @RequestMapping(value="/delete/{regNo}", method= RequestMethod.DELETE, consumes={MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody Vehicle deleteVehicle(
    		@PathVariable String regNo) 
                    throws TechnicalException {
    	Vehicle veh = vehicleService.get(regNo).get(0);
        vehicleService.delete(regNo);
        return veh;
    }
    
    @RequestMapping(value="/types", method= RequestMethod.GET, consumes={MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody List<VehicleType> getYesNo(Principal principal) throws TechnicalException {
        return Arrays.asList(VehicleType.class.getEnumConstants());
    }
}
