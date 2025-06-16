package com.avinash.sprint3;

class TicketBookingSystem {
    private int availableTickets = 5;

    // Synchronized method to ensure only one thread accesses this at a time
    public synchronized void bookTicket(String user, int requestedTickets) {
        System.out.println(user + " trying to book " + requestedTickets + " ticket(s).");

        if (requestedTickets <= availableTickets) {
            System.out.println("Booking successful for " + user);
            availableTickets -= requestedTickets;
            System.out.println("Tickets left: " + availableTickets);
        } else {
            System.out.println("Booking failed for " + user + ". Not enough tickets.");
        }

        System.out.println("--------------------------------------------------");
    }
}

class User extends Thread {
    private TicketBookingSystem bookingSystem;
    private int ticketsToBook;
    private String userName;

    public User(TicketBookingSystem system, String name, int tickets) {
        this.bookingSystem = system;
        this.userName = name;
        this.ticketsToBook = tickets;
    }

    @Override
    public void run() {
        bookingSystem.bookTicket(userName, ticketsToBook);
    }
}

public class TicketBookingDemo {
    public static void main(String[] args) {
        TicketBookingSystem bookingSystem = new TicketBookingSystem();

        // Creating threads (users)
        User user1 = new User(bookingSystem, "Alice", 2);
        User user2 = new User(bookingSystem, "Bob", 1);
        User user3 = new User(bookingSystem, "Charlie", 3);
        User user4 = new User(bookingSystem, "Diana", 1);

        // Start threads
        user1.start();
        user2.start();
        user3.start();
        user4.start();
    }
}
