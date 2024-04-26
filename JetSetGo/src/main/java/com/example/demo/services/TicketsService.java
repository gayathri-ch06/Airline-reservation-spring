package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Tickets;
import com.example.demo.repositories.TicketsRepository;

import java.util.List;

@Service
public class TicketsService {

    @Autowired
    private TicketsRepository ticketRepository;

    // Method to add a ticket
    public void addTicket(Tickets ticket) {
        ticketRepository.save(ticket);
    }

    // Method to retrieve all tickets
    public List<Tickets> getAllTickets() {
        return ticketRepository.findAll();
    }

    // Method to retrieve a ticket by ticket ID
    public List<Tickets> getTicketByTicketId(int ticketId) {
        return ticketRepository.findByTicketId(ticketId);
    }

    public List<Tickets> getTicketByBookingId(int bookingId) {
        return ticketRepository.findByBookingId(bookingId);
    }

    // Method to update a ticket
    public void updateTicket(int ticketId, Tickets updatedTicket) {
        Tickets existingTicket = ticketRepository.findById(ticketId).orElse(null);
        if (existingTicket != null) {
            // Update ticket fields
            existingTicket.setBookingId(updatedTicket.getBookingId());
            existingTicket.setFirstName(updatedTicket.getFirstName());
            existingTicket.setLastName(updatedTicket.getLastName());
            existingTicket.setGender(updatedTicket.getGender());
            existingTicket.setDateOfBirth(updatedTicket.getDateOfBirth());
            existingTicket.setPassengerType(updatedTicket.getPassengerType());
            existingTicket.setSeatAssigned(updatedTicket.getSeatAssigned());
            existingTicket.setFlightType(updatedTicket.getFlightType());
            // Save updated ticket
            ticketRepository.save(existingTicket);
        } else {
            // Handle ticket not found
            // You can throw an exception or handle it in any other appropriate way
        }
    }

    // Method to delete a ticket by ticket ID
    public void deleteTicket(int ticketId) {
        ticketRepository.deleteById(ticketId);
    }
}
