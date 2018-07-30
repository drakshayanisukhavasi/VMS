package com.draks.vms.service;

import java.util.List;

import com.draks.vms.exception.TechnicalException;

public abstract interface VehiclesService<T, ID> {
	
	T add(T obj) throws TechnicalException;
    T modify(T obj, ID id) throws TechnicalException;
    void delete(ID id) throws TechnicalException;
    List<T> get(ID id) throws TechnicalException;
}
