package io.github.hackleman;

public class Stats
{
    private int current_income;
    private int number_of_available_seats;
    private int number_of_purchased_tickets;

    Stats(Theatre theatre)
    {
        Seat[] availableSeats = theatre.getAvailable_seats();
        Seat[] purchasedSeats = theatre.purchasedSeats();

        this.number_of_purchased_tickets = purchasedSeats.length;
        this.number_of_available_seats = availableSeats.length;

        for (Seat seat: purchasedSeats) {
            this.current_income += seat.getPrice();
        }

    }

    public int getCurrent_income() {
        return current_income;
    }

    public int getNumber_of_available_seats() {
        return number_of_available_seats;
    }

    public int getNumber_of_purchased_tickets() {
        return number_of_purchased_tickets;
    }
}
