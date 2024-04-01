package com.avinashit.services;

import com.avinashit.binding.Passenger;
import com.avinashit.binding.Ticket;

public interface BookService {
	public Ticket bookTicket(Passenger passenger);
	public Ticket getTicket(Integer ticketNum);

}
