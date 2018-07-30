package com.draks.vms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy (lazy=false)
@Table(name = "VEHICLE")
public class Vehicle {
	
	@Column(name="TYPE", nullable = true, length = 20)
	private VehicleType type;
	@Id
	@Column(name="REGNO", nullable = true, length = 20)
	private String regNo;
	
	@Column(name="CAPACITY", nullable = true, length = 2)
	private Integer capacity;
	
	
	public VehicleType getType() {
		return type;
	}
	public void setType(VehicleType type) {
		this.type = type;
	}
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((regNo == null) ? 0 : regNo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (regNo == null) {
			if (other.regNo != null)
				return false;
		} else if (!regNo.equals(other.regNo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Vehicle [type=" + type + ", regNo=" + regNo + ", capacity=" + capacity + "]";
	}
	
	
}
