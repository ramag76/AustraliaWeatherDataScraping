package com.rgs.bigdata.weather.scrap;

public enum Feature {

	ALERTS("alerts"),
	ALMANAC("almanac"),
	ASTRONOMY("astronomy"),
	LOCATION("location"),
	CONDITIONS("conditions"),
	CURRENT_HURRICANE("currenthurricane"),
	FORECAST("forecast");
	
	private final String name;
	
	Feature(String f) {
		this.name = f;
	}
	
	public String toString() {
		return this.name;
	}
	
}
