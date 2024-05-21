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
    this.availability = seatNumber;
  }
  public void setAvailability(String newAvailability)
  {
    availability = newAvailability;
  }

  public double getPrice()
  {
    return price;
  }

  public String getSeatNumber()
  {
    return seatNumber;
  }

  public String getClassType()
  {
    return classType;
  }

  public String getAvailability()
  {
    return availability;
  }
}
