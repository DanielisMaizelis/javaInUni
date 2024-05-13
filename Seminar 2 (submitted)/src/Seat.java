import java.io.Serializable;

public class Seat implements Serializable
{
  private String seatNumber;
  private String classType;
  private double price;
  private String availability;

  public Seat(String seatNumber, String classType, double price)
  {
    this.seatNumber   = seatNumber;
    this.classType    = classType;
    this.price        = price;
    // Availability is shown in future implementations, when the seats are displayed
    // If they are free, they will display a seat number, like normal, but if the seat
    // Is reserved, it will be replaced by an X.
    this.availability = seatNumber;
  }
  public void setAvailability(String newAvailability)
  {
    availability = newAvailability;
  }
}
