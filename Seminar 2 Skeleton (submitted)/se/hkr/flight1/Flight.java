import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;

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
