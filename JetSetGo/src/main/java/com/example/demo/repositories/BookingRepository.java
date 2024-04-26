package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Booking;


public interface BookingRepository extends JpaRepository<Booking, Integer> {

	List<Booking> findByBookingId(int bookingId);

	void deleteByBookingId(int bookingId);

	List<Booking> findByUserEmail(String userEmail);
}