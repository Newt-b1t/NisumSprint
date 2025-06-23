package com.nisum.Question3;

public class BookingApp {
    public static void main(String[] args) {
        TicketBooking bookingSystem = new TicketBooking();

        // Simulate multiple users trying to book tickets
        UserThread user1 = new UserThread(bookingSystem, "Alice", 2);
        UserThread user2 = new UserThread(bookingSystem, "Bob", 2);
        UserThread user3 = new UserThread(bookingSystem, "Charlie", 2);

        user1.start();
        user2.start();
        user3.start();
    }
}

