package com.example.demo.dto;

import java.sql.Date;

public class FlightSearchBody {

	private String from;
    private String to;
    private Date departureDate;
    private int adults;
    private int children;
    private int infants;
    private String tripType;
    
	public FlightSearchBody(String from, String to, Date departureDate, int adults, int children,
			int infants, String tripType) {
		super();
		this.from = from;
		this.to = to;
		this.departureDate = departureDate;
		this.adults = adults;
		this.children = children;
		this.infants = infants;
		this.tripType = tripType;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public int getAdults() {
		return adults;
	}

	public void setAdults(int adults) {
		this.adults = adults;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public int getInfants() {
		return infants;
	}

	public void setInfants(int infants) {
		this.infants = infants;
	}

	public String getTripType() {
		return tripType;
	}

	public void setTripType(String tripType) {
		this.tripType = tripType;
	} 
	 
    
}
