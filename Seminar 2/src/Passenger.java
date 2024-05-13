import Exceptions.ReserveSeatException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
  public Map<Integer, Booking> getBookingHistory()
  {
    int counter = 0;
    Map<Integer, Booking> bookingMap = new HashMap<>();
    for(Booking booking: bookingHistory)
    {
      bookingMap.put(++counter,booking);
    }
    return bookingMap;
  }
  public void cancelBooking(Booking booking, FlightService flightService) throws NullPointerException
  {

    // Iterates each booking for the passenger
    for(Booking iteratedBooking : bookingHistory)
    {
      // If the booking is found
      if(Objects.equals(booking,iteratedBooking))
      {
        // Retrieves a flight f
        // rom the found booking
        Flight flightBooked = booking.getFlight();
        // Finds a flight seat based on the booked flight and cancels the seat
        flightBooked.cancelSeat(booking.getSeat());
      }
    }
    // Removes the desired booking from the passenger's history
    bookingHistory.remove(booking); // ???
  }
  public void updatePassengerDiscount(double newDiscount){}

  public String getName(){return name;}
  public String getPaymentMethod(){return paymentMethod;}
  public void bookFlight(String flightNumber, String seatNum, FlightService flightService) throws ReserveSeatException
  {
    Flight foundFlight   = flightService.findFlight(flightNumber);
    Seat   reservedSeat  = foundFlight.reserveSeat(seatNum);
    if(reservedSeat != null)
    {
      double totalPrice = foundFlight.getBasePrice()+reservedSeat.getPrice();
      Booking booking = new Booking(name,foundFlight, reservedSeat, paymentMethod,discount, totalPrice);
      bookingHistory.add(booking);
    }
  }

}
