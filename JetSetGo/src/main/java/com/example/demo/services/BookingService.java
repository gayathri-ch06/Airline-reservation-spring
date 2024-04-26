package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Service;

import com.example.demo.models.Booking;
import com.example.demo.repositories.BookingRepository;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    
    @Autowired
   	private TextEncryptor textEncryptor;

    // Method to add a new booking
    public Booking addBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    // Method to retrieve all bookings
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Method to retrieve a booking by ID
    public List<Booking> getBookingById(int bookingId) {
        return bookingRepository.findByBookingId(bookingId);
    }
    
    public List<Booking> getBookingByEmail(String userEmail) {
        return bookingRepository.findByUserEmail(userEmail);
    }

    // Method to update an existing booking
    public void updateBooking(int bookingId, Booking updatedBooking) {
        List<Booking> existingBookingOptional = bookingRepository.findByBookingId(bookingId);
        if (!existingBookingOptional.isEmpty()) {
            Booking existingBooking = existingBookingOptional.get(0);
            existingBooking.setPaymentId(updatedBooking.getPaymentId());
            existingBooking.setDepartureFlight(updatedBooking.getDepartureFlight());
            existingBooking.setReturnFlight(updatedBooking.getReturnFlight());
            existingBooking.setUserEmail(updatedBooking.getUserEmail());
            existingBooking.setTotalFare(updatedBooking.getTotalFare());
            existingBooking.setBookingDate(updatedBooking.getBookingDate());
            existingBooking.setTripType(updatedBooking.getTripType());
            existingBooking.setNumberOfPassengers(updatedBooking.getNumberOfPassengers());
            existingBooking.setNumberOfCarryon(updatedBooking.getNumberOfCarryon());
            existingBooking.setNumberOfCheckedBags(updatedBooking.getNumberOfCheckedBags());
            bookingRepository.save(existingBooking);
        } else {
            // Handle booking not found
            // You can throw an exception or handle it in any other appropriate way
        }
    }

    // Method to delete a booking by ID
    public void deleteBooking(int bookingId) {
        bookingRepository.deleteByBookingId(bookingId);
    }
}
