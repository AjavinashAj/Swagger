package com.avinashit.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.avinashit.binding.Passenger;
import com.avinashit.binding.Ticket;

@Service
public class BookServiceImpl implements BookService{

	private Map<Integer ,Ticket> ticketMap=new HashMap<>(); 
	private Integer ticketNum=1;
	@Override
	public Ticket bookTicket(Passenger passenger) {
		Ticket ticket=new Ticket();
		BeanUtils.copyProperties(passenger, ticket);
		ticket.setStatus("CONFIRM");
		ticket.setTicketCost(680.0);
		ticket.setTicketNum(ticketNum);
		ticketMap.put(ticketNum, ticket);
		ticketNum++;
		return ticket;
	}

	@Override
	public Ticket getTicket(Integer ticketNum) {
		if(ticketMap.containsKey(ticketNum)) {
			return ticketMap.get(ticketNum);
		}
		return null;
	}

}
