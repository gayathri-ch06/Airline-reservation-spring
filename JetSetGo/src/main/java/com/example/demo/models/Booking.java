package com.example.demo.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="booking_id")
	private int bookingId;
	@Column(name="payment_id")
	private String paymentId;
	@Column(name="departure_flight")
	private int departureFlight;
	@Column(name="return_flight")
	private int returnFlight;
	@Column(name="user_email")
	private String userEmail;
	
	@Column(name="total_fare")
	private double totalFare;
	@Column(name="booking_date")
	private Date bookingDate;
	@Column(name="trip_type")
	private String tripType;
	@Column(name="number_of_passengers")
	private int numberOfPassengers;
	@Column(name="number_of_carryon")
	private int numberOfCarryon;
	@Column(name="number_of_checked_bags")
	private int numberOfCheckedBags;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public int getDepartureFlight() {
		return departureFlight;
	}
	public void setDepartureFlight(int departureFlight) {
		this.departureFlight = departureFlight;
	}
	public int getReturnFlight() {
		return returnFlight;
	}
	public void setReturnFlight(int returnFlight) {
		this.returnFlight = returnFlight;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public double getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
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
