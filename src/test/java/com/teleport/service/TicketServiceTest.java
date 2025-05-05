package com.teleport.service;

import com.teleport.entity.Ticket;
import com.teleport.entity.User;
import com.teleport.config.TicketEventProducer;
import com.teleport.repository.TicketRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TicketServiceTest {

    @Mock
    private TicketRepository ticketRepository;

    @Mock
    private TicketEventProducer ticketEventProducer;

    @InjectMocks
    private TicketService ticketService;

    public TicketServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateTicket() {
        Ticket ticket = Ticket.builder()
                .destination("Kuala Lumpur")
                .travelDate("2025-05-06")
                .user(User.builder().id(1L).username("Mani").email("mani@example.com").build())
                .build();

        when(ticketRepository.save(any(Ticket.class))).thenReturn(ticket);

        Ticket created = ticketService.createTicket(ticket);

        assertNotNull(created);
        verify(ticketEventProducer, times(1)).sendTicketCreatedEvent(ticket);
    }

    @Test
    void testGetTicketById() {
        Ticket ticket = Ticket.builder()
                .id(1L)
                .destination("Penang")
                .travelDate("2025-06-01")
                .user(User.builder().id(2L).username("Sundeep").email("sun@example.com").build())
                .build();

        when(ticketRepository.findById(1L)).thenReturn(Optional.of(ticket));

        Ticket result = ticketService.getTicketById(1L);
        assertEquals("Penang", result.getDestination());
    }
}