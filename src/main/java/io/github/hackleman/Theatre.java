package io.github.hackleman;

import java.util.stream.Stream;

public class Theatre
{

    private int total_rows;
    private int total_columns;
    private Seat[] seats;

    private Seat[] available_seats;
    private Seat[] purchased_seats;

    Theatre(int rows, int columns) {
        this.total_rows = rows;
        this.total_columns = columns;
        this.seats = new Seat[rows * columns];

        int counter = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int price = (i < 4 ? 10 : 8);
                Seat seat = new Seat(i + 1, j + 1, price);
                seats[columns * i + j] = seat;
            }
        }

    }

    public int getTotal_rows()
    {
        return this.total_rows;
    }

    public void setTotal_rows(int rows)
    {
        this.total_rows = rows;
    }

    public int getTotal_columns()
    {
        return this.total_columns;
    }

    public void setTotal_columns(int columns)
    {
        this.total_columns = columns;
    }

    public Seat[] getAvailable_seats()
    {
        Stream<Seat> stream = Stream.of(seats);

        return stream.filter(p -> p.availability()).toArray(Seat[]::new);
    }

    public Seat[] purchasedSeats()
    {
        Stream<Seat> stream = Stream.of(seats);

        return stream.filter(p -> !p.availability()).toArray(Seat[]::new);
    }

}