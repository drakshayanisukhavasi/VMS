package com.draks.vms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.draks.vms.exception.TechnicalException;
import com.draks.vms.model.Vehicle;

public interface VehiclesRepository extends CrudRepository<Vehicle, String> {
	@Query("SELECT v FROM Vehicle v WHERE LOWER(CONCAT(v.type, v.regNo, v.capacity)) LIKE CONCAT('%', LOWER(:filter), '%')")
	public List<Vehicle> searchVehicles(@Param("filter") String filter) throws TechnicalException;
}
