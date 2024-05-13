import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class Main
{
  public static void main(String[] args) throws Exception
  {
    // State variables
    final int ADD_FLIGHT     = 1;
    final int ADD_PASSENGER  = 2;
    final int BOOK_FLIGHT    = 3;
    final int SEARCH_FLIGHTS = 4;
    final int VIEW_BOOKINGS  = 5;
    final int SAVE_AND_CLOSE = 6;

    // The option selected by the user
    int selection = 0;
    Scanner scanner             = new Scanner(System.in);
    FlightService flightService = new FlightService();

    Passenger passenger = new Passenger("Danielis", "maizeldaniel@gmail.com", "+37062063702", "Card");

    while(selection != SAVE_AND_CLOSE)
    {
      showMainMenu();
      selection = Integer.parseInt(scanner.nextLine());
      switch(selection)
      {
        case ADD_FLIGHT:
//          addFlight(scanner, flightService);
          break;

        case ADD_PASSENGER:
          break;

        case BOOK_FLIGHT:
          break;

        case SEARCH_FLIGHTS:
          searchFlights(scanner, flightService);
          break;

        case VIEW_BOOKINGS:
          break;

        case SAVE_AND_CLOSE:
          // Saves the file
          flightService.saveFlights();
          System.out.println("Changes are Saved");
          break;

        default:
          // Prompts to choose a correct number
          System.out.println("Choose a number between 1 and 6!!!");
          System.out.println();
          break;
      }
    }
  }
  static void showMainMenu()
  {
    System.out.println("1. Add Flight");
    System.out.println("2. Add Passenger");
    System.out.println("3. Book a Flight");
    System.out.println("4. Search Flights");
    System.out.println("5. View Bookings");
    System.out.println("6. Save and Exit");
    System.out.print("Choose an option: ");
  }



  static void searchFlights(Scanner scanner, FlightService flightService)
  {
    System.out.print("Enter Departure City (leave blank for any): ");
    String departureCity = scanner.nextLine();
    System.out.print("Enter Destination City (leave blank for any): ");
    String arrivalCity = scanner.nextLine();
    // Returns a found flight with and index, so that in the future implementations, it is possible to
    // Ask for more flight seats using that index
    Map<Integer, Flight> foundFlights = flightService.searchFlights(departureCity,arrivalCity);
    if(foundFlights.isEmpty())
    {
      System.out.println("None found");
    }
    else
    {
      // Prints the headings
      System.out.printf("%2s %10s %15s %15s %20s %20s %10s","No","Flight","From", "To", "Start", "Arrive", "Price");
      System.out.println();
      System.out.println("________________________________________________________" +
              "__________________________________________");

      // Prints the found flights with their indexes
      for(Map.Entry<Integer, Flight> flight : foundFlights.entrySet())
      {
        String departureTimeConcatenated = flight.getValue().getDepartureTime().toLocalDate() +" "+flight.getValue().getDepartureTime().toLocalTime();
        String arrivalTimeConcatenated   = flight.getValue().getArrivalTime().toLocalDate() +" "+flight.getValue().getArrivalTime().toLocalTime();

        // Prints out the values for each heading in a table
        System.out.printf("%2s %10s %15s %15s %20s %20s %10s", flight.getKey(), flight.getValue().getFlightNumber(),
                flight.getValue().getDepartureCity(),flight.getValue().getArrivalCity(),
                departureTimeConcatenated, arrivalTimeConcatenated,
                flight.getValue().getBasePrice()+"SEK");
        System.out.println();
      }
    }
  }

  static void addFlight(Scanner scanner, FlightService flightService)
  {
    boolean flightNumCorrect = true;
    System.out.print("Enter Flight Number: ");
    String flightNumber = scanner.nextLine();
    try
    {
      // Checks if the flight number is already taken
      flightService.checkFlightDuplicates(flightNumber);
    }
    catch(FlightBookingException e)
    {
      flightNumCorrect = false;
      System.out.println(e.getMessage());
    }
    if(flightNumCorrect)
    {
      System.out.print("Enter Departure City: ");
      String depCity = scanner.nextLine();
      System.out.print("Enter Destination City: ");
      String destCity = scanner.nextLine();
      System.out.print("Enter Departure Time (yyyy-MM-dd HH:mm +/-HH:mm): ");
      String depTime = scanner.nextLine();
      System.out.print("Enter Arrival Time (yyyy-MM-dd HH:mm +/-HH:mm): ");
      String arrTime = scanner.nextLine();
      DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm z");
      try
      {
        // From the date-time inputs check if the information can be parsed
        ZonedDateTime datetimeFrom = ZonedDateTime.parse(depTime, dtFormat);
        ZonedDateTime datetimeTo   = ZonedDateTime.parse(arrTime, dtFormat);
        System.out.print("Enter Base Price for the flight: ");
        double basePrice = Float.parseFloat(scanner.nextLine());
        flightService.addFlight(flightNumber, depCity, datetimeFrom, destCity, datetimeTo, basePrice);
      }
      catch (Exception e)
      {
        System.out.println("Error, use the proper format");
      }
    }
  }

}