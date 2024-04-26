package com.example.demo.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Tickets;



public interface TicketsRepository extends JpaRepository<Tickets, Integer> {

	List<Tickets> findByTicketId(int ticketId);

	List<Tickets> findByBookingId(int bookingId);
}