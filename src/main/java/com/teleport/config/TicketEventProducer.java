package com.teleport.config;

import com.teleport.entity.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TicketEventProducer {

    private final KafkaTemplate<String, Ticket> kafkaTemplate;
    private static final String TOPIC = "ticket-events";

    public void sendTicketCreatedEvent(Ticket ticket) {
       // kafkaTemplate.send(TOPIC, ticket);
    }
}
