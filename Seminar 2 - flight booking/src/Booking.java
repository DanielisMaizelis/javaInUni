import java.util.SequencedCollection;

public class Booking
{
  private String passengerName;
  private Flight flight;
  private String bookingReference;
  private String paymentMethod;
  private double passengerDiscount;
  private double totalPrice;

  private Seat seat;

  public Booking(String passengerName, Flight flight, Seat seat, String paymentMethod, double passengerDiscount, double totalPrice)
  {
    this.passengerName     = passengerName;
    this.flight            = flight;
    this.paymentMethod     = paymentMethod;
    this.passengerDiscount = passengerDiscount;
    this.totalPrice        = totalPrice-totalPrice*(passengerDiscount/100);
    this.seat              = seat; // Aggregation
  }

  @Override
  public String toString()
  {
    return String.format("%10s %10s %20s %10s %10s %10s %10s", passengerName,this.getFlight().getFlightNumber(),
            this.getFlight().getDepartureCity()+"-"+this.getFlight().getArrivalCity(), this.seat.getSeatNumber(), paymentMethod,
            passengerDiscount+"%", totalPrice+"SEK");
  }

  public String getPassengerName(){return passengerName;}

  public Flight getFlight(){return flight;}

  public String getPaymentMethod(){return paymentMethod;}

  public double getPassengerDiscount(){return passengerDiscount;}

  public double getTotalPrice()
  {
    return totalPrice;
  }

  public Seat getSeat()
  {
    return seat;
  }
}
