import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class FlightService implements Serializable
{
  private ArrayList<Flight> flights;
  private final String FILE_PATH = "flights.dat";
  public FlightService()
  {
    this.flights = new ArrayList<>(); // Composition to class Flight
    this.setUpFlights();
  }
  private void setUpFlights()
  {
  }
  public ArrayList<Flight> getFlights(){return flights;}

  public void checkFlightDuplicates(String flightNum)
  {
  }

  public void saveFlights() throws Exception
  {
  }

  public void addFlight(String flightNumber, String departureCity, ZonedDateTime departureTime, String arrivalCity, ZonedDateTime arrivalTime, double basePrice)
  {
  }


  public HashMap<Integer, Flight> searchFlights(String departingCity, String arrivalCity)
  {
    return null;
  }

  public Flight findFlight(String flightNumber)
  {
    return null;
  }
}
