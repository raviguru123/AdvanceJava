package org.lld.practice.ticketing.system.strategy;

import org.lld.practice.ticketing.system.Ticket;

public class SendSMS implements TicketAction {
    public void action(Ticket ticket) {
        System.out.println("Send SMS");
    }
}
