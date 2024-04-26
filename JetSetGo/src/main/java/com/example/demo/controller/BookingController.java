package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookingResponse;
import com.example.demo.models.Booking;
import com.example.demo.services.BookingService;
import com.example.demo.services.FlightService;
import com.example.demo.models.Flight;


@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@Autowired
    private FlightService flightService;
	
	
	@PostMapping("/addBooking")
	public Booking addBooking(@RequestBody Booking booking) {
		return bookingService.addBooking(booking);
	}
	
	@PostMapping("/getBooking")
	public List<BookingResponse> getBooking(@RequestBody String email) {
		List<Booking> bookings = bookingService.getBookingByEmail(email);
		List<BookingResponse> result = new ArrayList<BookingResponse>();
		for (Booking booking : bookings) {
			
			Flight flight = flightService.getFlightByFlightId(booking.getDepartureFlight()).get(0);
			BookingResponse response = new BookingResponse();
			response.setArrivalDate(flight.getArrivalDate());
			response.setArrivalTime(flight.getArrivalTime());
			response.setDepartureDate(flight.getDepartureDate());
			response.setDepartureTime(flight.getDepartureTime());
			response.setDestination(flight.getDestination());
			response.setSource(flight.getSource());
			response.setNumberOfCarryon(booking.getNumberOfCarryon());
			response.setNumberOfCheckedBags(booking.getNumberOfCheckedBags());
			response.setNumberOfPassengers(booking.getNumberOfPassengers());
			response.setTotalFare(booking.getTotalFare());
			response.setTripType(booking.getTripType());
			result.add(response);
			
		}
		return result;
		
	}
	
}
