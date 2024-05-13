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
  public FlightService() throws IOException, ClassNotFoundException
  {
    this.flights = new ArrayList<>(); // Composition to class Flight
    this.setUpFlights();
  }
  private void setUpFlights() throws IOException, ClassNotFoundException
  {
    Path path             = Paths.get(FILE_PATH);
    // If the file is not empty
    if(!(Files.size(path) == 0))
    {
      // Get objects from the desired file
      FileInputStream   fis = new FileInputStream(FILE_PATH);
      ObjectInputStream ois = new ObjectInputStream(fis);
      flights.addAll((ArrayList<Flight>) ois.readObject());
    }
    // Gets all the saved flight objects and stores them in flights Arraylist
  }
  public ArrayList<Flight> getFlights(){return flights;}

  public void checkFlightDuplicates(String flightNum) throws FlightBookingException
  {
    for(Flight iteratedFlight: flights)
    {
      if(Objects.equals(iteratedFlight.getFlightNumber(), flightNum))
      {
        throw new FlightBookingException("Flight already exists");
      }
    }
  }

  public void saveFlights() throws Exception
  {
    // If flights have some objects in them
    if(!flights.isEmpty())
    {
      // Store it in the dat file
      FileOutputStream fos   = new FileOutputStream(FILE_PATH);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(flights);
    }
  }

  public void addFlight(String flightNumber, String departureCity, ZonedDateTime departureTime, String arrivalCity, ZonedDateTime arrivalTime, double basePrice)
  {
    Flight flight = new Flight(flightNumber,departureCity, departureTime, arrivalCity, arrivalTime, basePrice);
    flights.add(flight);
  }


  public HashMap<Integer, Flight> searchFlights(String departingCity, String arrivalCity)
  {
    HashMap<Integer,Flight> foundFlights = new HashMap<>();

    int counter = 0;
    for(Flight flight : flights)
    {
      // User wants to see all fights:
      if(departingCity.isBlank() && arrivalCity.isBlank())
      {
        // Inserts a flight in the map with their index
        foundFlights.put(++counter, flight);
      }
      // User wants to see all departing fights, that have the specified arrival city
      else if(departingCity.isBlank())
      {
        if(Objects.equals(flight.getArrivalCity(), arrivalCity))
        {
          // Inserts a flight in the map with their index
          foundFlights.put(++counter, flight);
        }
      }
      // User wants to see all arrival fights, that have the specified departing city
      else if(arrivalCity.isBlank())
      {
        if(Objects.equals(flight.getDepartureCity(), departingCity))
        {
          // Inserts a flight in the map with their index
          foundFlights.put(++counter, flight);
        }
      }
      // User wants to see flight with a specific route
      else if(Objects.equals(flight.getArrivalCity(), arrivalCity) && Objects.equals(flight.getDepartureCity(), departingCity))
      {
        // Inserts a flight in the map with their index
        foundFlights.put(++counter, flight);
      }
    }
    return foundFlights;
  }

  // Method for future implementation, for when the
  public Flight findFlight(String flightNumber)
  {
    return null;
  }
}
