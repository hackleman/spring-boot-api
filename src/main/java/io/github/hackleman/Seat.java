package io.github.hackleman;

import java.util.UUID;

public class Seat {
    private int row;
    private int column;

    private boolean available;

    private UUID token;

    private int price;

    public Seat() {}

    public Seat(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;
        this.available = true;
        this.token = null;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPrice() { return price; }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean availability() {
        return available;
    }

    public void setAvailability(boolean availability) {
        this.available = availability;
    }

    public UUID seatUUID()
    {
        return this.token;
    }

    public void setToken(UUID token)
    {
        this.token = token;
    }
}