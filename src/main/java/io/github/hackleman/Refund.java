package io.github.hackleman;

public class Refund
{
    private Seat returned_ticket;

    Refund(Seat returned_ticket)
    {
        this.returned_ticket = returned_ticket;
    }

    public Seat getReturned_ticket()
    {
        return this.returned_ticket;
    }
}
