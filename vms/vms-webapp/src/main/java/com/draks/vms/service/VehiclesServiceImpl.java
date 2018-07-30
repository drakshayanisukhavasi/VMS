package com.draks.vms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.draks.vms.dao.VehiclesRepository;
import com.draks.vms.exception.TechnicalException;
import com.draks.vms.model.Vehicle;
import com.google.common.collect.Iterators;

@Service
public class VehiclesServiceImpl implements VehiclesService<Vehicle, String> {
	
	@Autowired
	VehiclesRepository vehRepos;

	@Override
	public Vehicle add(Vehicle obj) throws TechnicalException {
        if (obj.getRegNo() != null && vehRepos.exists(obj.getRegNo())) {
            throw new TechnicalException("Already exists - " + obj.getRegNo());
        }
        
        vehRepos.save(obj);

        return obj;
	}

	@Override
	public Vehicle modify(Vehicle obj, String id) throws TechnicalException {
		if (obj.getRegNo() == null || !vehRepos.exists(obj.getRegNo())) {
            throw new TechnicalException("Doesn't exists - " + obj.getRegNo());
        }
        
        vehRepos.save(obj);

        return obj;
	}

	@Override
	public void delete(String id) throws TechnicalException {
		if (id == null || !vehRepos.exists(id)) {
            throw new TechnicalException("Doesn't exists - " + id);
        }
        
        vehRepos.delete(id);
	}

	@Override
	public List<Vehicle> get(String filter) throws TechnicalException {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		if (filter!=null && filter.length() > 0) {
			vehicles = vehRepos.searchVehicles(filter);
		} else {
			Iterators.addAll(vehicles, vehRepos.findAll().iterator());
		}
		return vehicles;
	}
}
