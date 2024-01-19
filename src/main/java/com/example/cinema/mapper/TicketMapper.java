package com.example.cinema.mapper;

import com.example.cinema.dto.TicketDto;
import com.example.cinema.models.Ticket;

public class TicketMapper {
    public static Ticket mapToTicket(TicketDto ticketDto) {
        return Ticket.builder()
                .id(ticketDto.getId())
                .codePayement(ticketDto.getCodePayement())
                .nomClient(ticketDto.getNomClient())
                .place(ticketDto.getPlace())
                .prix(ticketDto.getPrix())
                .projection(ticketDto.getProjection())
                .reserver(ticketDto.getReserver())
                .build();
    }

    public static TicketDto mapToTicketDto(Ticket ticket) {
        return TicketDto.builder()
                .id(ticket.getId())
                .codePayement(ticket.getCodePayement())
                .nomClient(ticket.getNomClient())
                .place(ticket.getPlace())
                .prix(ticket.getPrix())
                .projection(ticket.getProjection())
                .reserver(ticket.getReserver())
                .build();
    }
}
