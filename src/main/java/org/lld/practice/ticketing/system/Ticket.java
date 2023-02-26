package org.lld.practice.ticketing.system;

import lombok.Getter;
import lombok.Setter;
import org.lld.practice.ticketing.system.strategy.TicketAction;

@Getter
public class Ticket {
    @Setter
    TicketStatus ticketStatus;

    @Setter
    TicketAction ticketAction;

    private final Integer id;
    final TicketType ticketType;
    final String description;

    public Ticket(final TicketType ticketType, final String description) {
        this.ticketType = ticketType;
        this.description = description;
        this.id = IDGenerator.getID();
    }

}
