package io.github.hackleman;

import java.util.UUID;

public class Ticket
{
    private Seat ticket;

    private UUID token;
    Ticket(Seat seat)
    {
        this.ticket = seat;
        this.token = seat.seatUUID();
    }

    public Seat getTicket() {
        return this.ticket;
    }

    public void setTicket(Seat ticket) {
        this.ticket = ticket;
    }

    public UUID getToken() {
        return this.token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }
}
