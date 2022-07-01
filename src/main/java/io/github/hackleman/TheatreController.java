package io.github.hackleman;

import io.github.hackleman.errors.SeatAuthException;
import io.github.hackleman.errors.SeatBoundsException;
import io.github.hackleman.errors.SeatTokenException;
import io.github.hackleman.errors.SeatUnavailableException;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class TheatreController
{

    private final int rows = 9;
    private final int columns = 9;
    private Theatre theatre = new Theatre(rows, columns);

    @GetMapping("/seats")
    public Theatre getTheatre()
    {
        return theatre;
    }

    @PostMapping("/purchase")
    public Ticket postPurchase(@RequestBody TicketRequest req)
    {
        int row = req.getRow();
        int column = req.getColumn();

        if (row < 1 || row > 9 || column < 1 || column > 9)
        {
            throw new SeatBoundsException("The number of a row or a column is out of bounds!");
        }

        for (Seat seat : theatre.getAvailable_seats())
        {
            if (seat.getRow() == row && seat.getColumn() == column)
            {
                seat.setAvailability(false);
                seat.setToken(UUID.randomUUID());

                return new Ticket(seat);
            }
        }

        throw new SeatUnavailableException("The ticket has been already purchased!");
    }

    @PostMapping("/return")
    public Refund postRefund(@RequestBody RefundRequest request)
    {
        UUID token = request.getToken();

        for (Seat seat : theatre.purchasedSeats()) {
            if (seat.seatUUID().toString().equals(token.toString())) {

                seat.setAvailability(true);
                seat.setToken(null);

                return new Refund(seat);

            }

        }

        throw new SeatTokenException("Wrong token!");

    }

    @PostMapping("/stats")
    public Stats getStats(@RequestParam(value = "password", required = false) String password)
    {
        if (password == null || !password.equals("super_secret")) {
            throw new SeatAuthException("The password is wrong!");
        }
        return new Stats(theatre);
    }

}