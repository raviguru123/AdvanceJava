package org.lld.practice.ticketing.system.strategy;

import org.lld.practice.ticketing.system.Ticket;

public class IVRSCall implements  TicketAction{
    public void action(Ticket ticket) {
        System.out.println("IVRS call");
    }
}
