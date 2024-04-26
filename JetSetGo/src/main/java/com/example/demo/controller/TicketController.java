package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Tickets;
import com.example.demo.services.TicketsService;

@RestController
public class TicketController {

	@Autowired
	private TicketsService ticketService;
	
	@PostMapping("/addTicket")
	public void addTicket(@RequestBody Tickets tickets) {
		ticketService.addTicket(tickets);
	}
	
}
