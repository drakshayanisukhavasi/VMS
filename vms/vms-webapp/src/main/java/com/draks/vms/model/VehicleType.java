package com.draks.vms.model;

public enum VehicleType {
	
	CAR("C"),
	TRUCK("T"),
	AIRPLANE("A"),
	AMPHIBIAN("M"),
	BOAT("B");
	
	VehicleType(String code) {
		this.code = code;
	}
	
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
