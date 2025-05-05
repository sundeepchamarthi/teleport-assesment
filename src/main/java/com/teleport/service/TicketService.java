package com.teleport.service;

import com.teleport.entity.Ticket;
import com.teleport.config.TicketEventProducer;
import com.teleport.repository.TicketRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final TicketEventProducer ticketEventProducer;

    public Ticket createTicket(Ticket ticket) {
        Ticket saved = ticketRepository.save(ticket);
        ticketEventProducer.sendTicketCreatedEvent(saved);
        return saved;
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ticket not found with id: " + id));
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
}