package com.temperatures.rest.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TemperatureF {
	
	@JsonProperty("id")
	private long id;
	@JsonProperty("Temperature in fahrenheit")
	private double tempf;
	@JsonProperty("Created On")
	private Date cdate;
	@JsonProperty("Updateded On")
	private Date udate;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getTempf() {
		return tempf;
	}
	public void setTempf(double tempf) {
		this.tempf = tempf;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public Date getUdate() {
		return udate;
	}
	public void setUdate(Date udate) {
		this.udate = udate;
	}

}
