import Exceptions.ReserveSeatException;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Flight implements Serializable
{
  private String flightNumber;
  private String departureCity;
  private ZonedDateTime departureTime;
  private String arrivalCity;
  private ZonedDateTime arrivalTime;
  private ArrayList<Seat> seats;
  private double basePrice;


  public Flight(String flightNumber, String departureCity, ZonedDateTime departureTime, String arrivalCity, ZonedDateTime arrivalTime, double basePrice)
  {
    this.flightNumber  = flightNumber;
    this.departureCity = departureCity;
    this.departureTime = departureTime;
    this.arrivalCity   = arrivalCity;
    this.arrivalTime   = arrivalTime;
    this.seats         = new ArrayList<>(); // Composition
    this.setUpSeats();
    this.basePrice     = basePrice;
  }

  private void setUpSeats()
  {
    final int  TOTAL_ROWS = 30; // Number 30
    final char COLUMN_A   = 65; // Character A
    final char COLUMN_F   = 70; // Character F
    final int  BUSINESS_CLASS_LAST_ROW = 5;
    final double BUSINESS_SEAT_PRICE = 1000;
    final double ECONOMY_SEAT_PRICE = 100;

    // Creates 30 rows of seats ranging from A to F
    for(int row = 1; row<TOTAL_ROWS; row++)
    {
      for(char col=COLUMN_A; col<=COLUMN_F; col++)
      {
        Seat seat;
        String seatNum = Integer.toString(row);
        seatNum       += Character.toString(col);
        if(row <= BUSINESS_CLASS_LAST_ROW)
        {
          seat = new Seat(seatNum, "Business", BUSINESS_SEAT_PRICE);
        }
        else
        {
          seat = new Seat(seatNum, "Economy", ECONOMY_SEAT_PRICE);
        }
        seats.add(seat);
      }
    }
  }

  public String getFlightNumber(){return flightNumber;}

  public String getDepartureCity(){return departureCity;}

  public ZonedDateTime getDepartureTime(){return departureTime;}

  public String getArrivalCity(){return arrivalCity;}

  public ZonedDateTime getArrivalTime(){return arrivalTime;}

  public ArrayList<Seat> getSeats(){return seats;}

  public double getBasePrice(){return basePrice;}

  @Override
  public String toString()
  {
    String departureTimeConcatenated = departureTime.toLocalDate() +" "+departureTime.toLocalTime();
    String arrivalTimeConcatenated   = arrivalTime.toLocalDate() +" "+arrivalTime.toLocalTime();

    // Returns a formatted string for displaying data in the table:
    return String.format("%10s %15s %15s %20s %20s %10s \n", flightNumber, departureCity,arrivalCity, departureTimeConcatenated, arrivalTimeConcatenated,basePrice+"SEK");
  }

  public void cancelSeat(Seat seat)
  {
    seat.setAvailability(seat.getSeatNumber());
  }

  public Seat reserveSeat(String requestedSeatName) throws ReserveSeatException
  {
    boolean seatFound = false;
    boolean seatFree  = false;
    Seat seat         = null;

    for(Seat s:seats)
    {
      if(Objects.equals(s.getSeatNumber(), requestedSeatName))
      {
        seatFound = true;
        if(Objects.equals(s.getAvailability(), s.getSeatNumber()))
        {
          seatFree = true;
          s.setAvailability("X");
          seat = s;
        }
      }
    }
    if(!seatFound)
    {
      throw new ReserveSeatException("Seat to reserve is not found!");
    }
    else if(!seatFree)
    {
      throw new ReserveSeatException(String.format("Seat %s is reserved, try a different seat", requestedSeatName));
    }
    return seat;
  }


}
