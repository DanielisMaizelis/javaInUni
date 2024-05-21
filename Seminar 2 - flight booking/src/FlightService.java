import Exceptions.CityNameException;
import Exceptions.FlightBookingException;
import Exceptions.FlightNumException;

import java.io.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class FlightService implements Serializable
{
  // Composition of the Flight class
  private ArrayList<Flight> flights;
  private final String FILE_PATH = "flights.dat";
  public FlightService() throws Exception
  {
    this.flights          = new ArrayList<>();
    this.retrieveFlights();
  }
  public ArrayList<Flight> getFlights(){return flights;}

  private void retrieveFlights() throws Exception
  {
    File file = new File(FILE_PATH);
    // File is not empty
    if(file.length() != 0)
    {
      // Reads the byte code of the file "flights.dat"
      FileInputStream   fis = new FileInputStream(FILE_PATH);
      ObjectInputStream ois = new ObjectInputStream(fis);
      // Retrieves the objects and puts all of them into the flights ArrayList
      flights.addAll((ArrayList<Flight>) ois.readObject());
    }
  }
  public void saveFlights() throws Exception
  {
    FileOutputStream fos   = new FileOutputStream(FILE_PATH);
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    if(!flights.isEmpty())
    {
      oos.writeObject(flights);
    }
  }

  public void addFlight(String flightNumber, String departureCity, ZonedDateTime departureTime, String arrivalCity, ZonedDateTime arrivalTime, double basePrice) throws FlightBookingException, FlightNumException, CityNameException
  {
    if(departureCity.isBlank() || arrivalCity.isBlank())
    {
      throw new CityNameException("No departure city is specified");
    }
    else
    {
      String concatenatedCities = departureCity.strip()+arrivalCity.strip();
      for(Character ch: concatenatedCities.toCharArray())
      {
        if(Character.isDigit(ch))
        {
          throw new CityNameException("There can't be any numbers in a city name!");
        }
      }
    }
    if(flightNumber.length() != 5)
    {
      throw new FlightNumException("The flight number is 5 characters long!");
    }
    else
    {
      int counter = 0;
      for(Character ch: flightNumber.toCharArray())
      {
        counter++;
        if(counter <= 2)
        {
          if(Character.isDigit(ch))
          {
            throw new FlightNumException("The first 2 signs should be letters!");
          }
          if(Character.isLowerCase(ch))
          {
            throw new FlightNumException("Use uppercase letters!");
          }
        }
        else
        {
          if(!Character.isDigit(ch))
          {
            throw new FlightNumException("Use digits for the last 3 signs!");
          }
        }
      }
      // Iterates all flights
      for(Flight iteratedFlight: flights)
      {
        // Flight number is found to be the same as the iterated one
        if(Objects.equals(iteratedFlight.getFlightNumber(), flightNumber))
        {
          throw new FlightBookingException("Flight already exists");
        }
      }
    }
    Flight flight = new Flight(flightNumber,departureCity, departureTime, arrivalCity, arrivalTime, basePrice);
    flights.add(flight);
  }


  public HashMap<Integer, Flight> searchFlights(String cityData1, String cityData2)
  {
    HashMap<Integer,Flight> foundFlights = new HashMap<>();

    int counter = 0;
    for(Flight flight : flights)
    {
      if(cityData1.isBlank() && cityData2.isBlank())
      {
        foundFlights.put(++counter, flight);
      }
      else if(cityData1.isBlank())
      {
        if(Objects.equals(flight.getArrivalCity(), cityData2))
        {
          foundFlights.put(++counter, flight);
        }
      }
      else if(cityData2.isBlank())
      {
        if(Objects.equals(flight.getDepartureCity(), cityData1))
        {
          foundFlights.put(++counter, flight);
        }
      }
      else if(Objects.equals(flight.getArrivalCity(), cityData2) && Objects.equals(flight.getDepartureCity(), cityData1))
      {
        foundFlights.put(++counter, flight);
      }
    }
    return foundFlights;
  }

  public Flight findFlight(String flightNumber)
  {
    Flight flightFound = null;
    for(Flight f: flights)
    {
      if(Objects.equals(f.getFlightNumber(), flightNumber))
      {
        flightFound = f;
      }
    }
    return flightFound;
  }
}
