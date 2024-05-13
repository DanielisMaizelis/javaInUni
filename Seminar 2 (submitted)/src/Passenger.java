import java.util.ArrayList;

public class Passenger
{
  private String name;
  private String email;
  private String phoneNumber;
  private ArrayList<Booking> bookingHistory;
  private double discount;
  private String paymentMethod;

  public Passenger(String name, String email, String phoneNumber, String paymentMethod)
  {
    this.name           = name;
    this.email          = email;
    this.phoneNumber    = phoneNumber;
    this.paymentMethod  = paymentMethod;
    this.bookingHistory = new ArrayList<>(); // Composition
  }

  public ArrayList<Booking> getBookingHistory()
  {
    return bookingHistory;
  }
  public void cancelBooking(Booking booking){}
  public void updatePassengerDiscount(double newDiscount){}
  public String getName(){return name;}
  public String getPaymentMethod(){return paymentMethod;}
  public void bookFlight(String flightNumber, String seatNum, FlightService flightService){}
}
