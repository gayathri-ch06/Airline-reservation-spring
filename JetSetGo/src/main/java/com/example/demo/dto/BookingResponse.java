package com.example.demo.dto;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;

public class BookingResponse {
	
	private String source;
	private String destination;
	private Date arrivalDate;
	private Date departureDate;
	private Time arrivalTime;
	private Time departureTime;
	private double totalFare;
	private String tripType;
	private int numberOfPassengers;
	private int numberOfCarryon;
	private int numberOfCheckedBags;
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Time getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public Time getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}
	public double getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}
	public String getTripType() {
		return tripType;
	}
	public void setTripType(String tripType) {
		this.tripType = tripType;
	}
	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}
	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}
	public int getNumberOfCarryon() {
		return numberOfCarryon;
	}
	public void setNumberOfCarryon(int numberOfCarryon) {
		this.numberOfCarryon = numberOfCarryon;
	}
	public int getNumberOfCheckedBags() {
		return numberOfCheckedBags;
	}
	public void setNumberOfCheckedBags(int numberOfCheckedBags) {
		this.numberOfCheckedBags = numberOfCheckedBags;
	}
	
	
	
	

}
