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

  public Flight(String flightNumber, String departureCity, ZonedDateTime departureTime, String arrivalCity, ZonedDateTime arrivalTime,  double basePrice)
  {
    this.flightNumber  = flightNumber;
    this.departureCity = departureCity;
    this.departureTime = departureTime;
    this.arrivalCity   = arrivalCity;
    this.arrivalTime   = arrivalTime;
    this.seats         = new ArrayList<>();
    this.basePrice     = basePrice;
    this.setUpSeats();
  }

  private void setUpSeats()
  {
    for(int i=0; i<35; i++)
    {
      for(char j=65; j<70; j++)
      {
        System.out.println(i);
      }
    }




//    final int TOTAL_ROWS = 30; // Number 30
//    final char COLUMN_A = 65; // Character A
//    final char COLUMN_F = 70; // Character F
//    final int BUSINESS_CLASS_LAST_ROW = 5;
//
//
//    // Creates 30 rows of seats ranging from A to F
//    // So from A to F, done 30 times
//    // From 1A to 30F
//    for(int row = 1; row < TOTAL_ROWS; row++)
//    {
//      for(char col = COLUMN_A; col <= COLUMN_F; col++)
//      {
//        Seat seat;
//        String seatNum = Integer.toString(row);
//        seatNum += Character.toString(col);
//        // Assigns business class seats for first 5 rows
//        if(row <= BUSINESS_CLASS_LAST_ROW)
//        {
//          seat = new Seat(seatNum, "Business", 60);
//        }
//        // The rest are economy class
//        else
//        {
//          seat = new Seat(seatNum, "Economy", 30);
//        }
//        seats.add(seat);
//      }
//    }
  }
  public String getFlightNumber(){return flightNumber;}

  public String getDepartureCity(){return departureCity;}

  public ZonedDateTime getDepartureTime(){return departureTime;}

  public String getArrivalCity(){return arrivalCity;}

  public ZonedDateTime getArrivalTime(){return arrivalTime;}

  public ArrayList<Seat> getSeats(){return seats;}

  public double getBasePrice(){return basePrice;}

  public Seat reserveSeat(String requestedSeatName)
  {
    return null;
  }

  public void showAvailableSeats()
  {
  }
}
