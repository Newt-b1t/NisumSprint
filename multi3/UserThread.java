package com.nisum.Question3;

public class UserThread extends Thread {
    private final TicketBooking bookingSystem;
    private final String userName;
    private final int ticketsToBook;

    public UserThread(TicketBooking bookingSystem, String userName, int ticketsToBook) {
        this.bookingSystem = bookingSystem;
        this.userName = userName;
        this.ticketsToBook = ticketsToBook;
    }

    @Override
    public void run() {
        bookingSystem.bookTicket(userName, ticketsToBook);
    }
}

