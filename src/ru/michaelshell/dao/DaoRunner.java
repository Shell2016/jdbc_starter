package ru.michaelshell.dao;

import ru.michaelshell.dto.TicketFilter;
import ru.michaelshell.entity.Ticket;

import java.math.BigDecimal;
import java.util.Optional;

public class DaoRunner {
    public static void main(String[] args) {
        TicketDao ticketDao = TicketDao.getInstance();
        TicketFilter ticketFilter = new TicketFilter(3, 0, "Эдуард Щеглов", "B1");
        var all = ticketDao.findAll(ticketFilter);
        System.out.println(all);

    }







    private static void updateTest(TicketDao ticketDao) {
        Optional<Ticket> optionalTicket = ticketDao.findById(30L);
        System.out.println(optionalTicket);

        optionalTicket.ifPresent(ticket -> {
            ticket.setCost(BigDecimal.valueOf(150.05));
            ticketDao.update(ticket);
        });
    }


    private static void saveTest(TicketDao ticketDao) {
        Ticket ticket = new Ticket();
        ticket.setPassengerNo("12345");
        ticket.setPassengerName("Michael Shell");
        ticket.setFlightId(3L);
        ticket.setSeatNo("B5");
        ticket.setCost(BigDecimal.TEN);

        var ticket1 = ticketDao.save(ticket);
        System.out.println(ticket1);
    }
}
