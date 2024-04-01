package com.avinashit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.avinashit.binding.Passenger;
import com.avinashit.binding.Ticket;
import com.avinashit.services.BookService;

@RestController
public class BookController {

	private BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@PostMapping(value = "/ticket", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger passenger) {

		Ticket ticket = bookService.bookTicket(passenger);
		return new ResponseEntity<Ticket>(ticket, HttpStatus.CREATED);
	}

	@GetMapping(value = "/ticket/{ticketNum}", produces = { "application/json" })
	public ResponseEntity<Ticket> getTicketByTicketNum(@PathVariable Integer ticketNum) {

		return new ResponseEntity<Ticket>(bookService.getTicket(ticketNum), HttpStatus.OK);
	}
}
