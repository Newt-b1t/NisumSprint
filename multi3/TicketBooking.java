package com.nisum.Question3;

public class TicketBooking {
    private int availableTickets = 5;

    public synchronized void bookTicket(String userName, int numberOfTickets) {
        System.out.println(userName + " trying to book " + numberOfTickets + " tickets...");

        if (numberOfTickets <= availableTickets) {
            System.out.println("Booking confirmed for " + userName);
            availableTickets -= numberOfTickets;
            System.out.println("Tickets remaining: " + availableTickets);
        } else {
            System.out.println("Not enough tickets for " + userName + ". Only " + availableTickets + " left.");
        }
    }
}

