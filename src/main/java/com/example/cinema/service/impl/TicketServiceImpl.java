package com.example.cinema.service.impl;

import com.example.cinema.repository.TicketRepository;
import com.example.cinema.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {
    private TicketRepository ticketRepository;
    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository){
        this.ticketRepository=ticketRepository;
    }
}
