import Exceptions.CityNameException;
import Exceptions.FlightBookingException;
import Exceptions.FlightNumException;
import Exceptions.ReserveSeatException;

import java.io.EOFException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main
{
  public static void main(String[] args) throws Exception
  {
    // Types of selection in the menu
    final int ADD_FLIGHT     = 1;
    final int ADD_PASSENGER  = 2;
    final int BOOK_FLIGHT    = 3;
    final int SEARCH_FLIGHTS = 4;
    final int VIEW_BOOKINGS  = 5;
    final int SAVE_AND_CLOSE = 6;

    // Default selection
    int       selection      = 0;

    // Scanner class
    Scanner scanner             = new Scanner(System.in);

    // Declared Flight Service Class with the passenger
    FlightService flightService = new FlightService();
    Passenger passenger         = new Passenger("Danielis", "maizeldaniel@gmail.com", "+37062063702", "Card");

    // The loop continues unless the user wants to save and close the program
    while(selection != SAVE_AND_CLOSE)
    {
      // Shows the menu with its choices:
      showMainMenu();
      // The selection is selected with the user
      selection = Integer.parseInt(scanner.nextLine());

      switch(selection)
      {
        case ADD_FLIGHT:
          addFlight(scanner, flightService);
          break;

        case ADD_PASSENGER:
          break;

        case BOOK_FLIGHT:
          bookFlight(scanner,passenger,flightService);
          break;

        case SEARCH_FLIGHTS:
          searchFlights(scanner, flightService);
          break;

        case VIEW_BOOKINGS:
          viewBookings(passenger, scanner, flightService);
          break;

        case SAVE_AND_CLOSE:
          // Saves the file and tells that the changes are saved
          flightService.saveFlights();
          System.out.println("Changes are Saved");
          break;

        default:
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


  static void viewBookings(Passenger passenger, Scanner scanner, FlightService flightService)
  {
    // Gets all bookings that were made, they are mapped ech with a booking and their index
    Map<Integer, Booking> bookings = passenger.getBookingHistory();
    if(bookings.isEmpty())
    {
      System.out.println("There are no bookings at the moment!");
    }
    // Some bookings are found:
    else
    {
      // The heading of the table
      System.out.printf("%2s %10s %10s %20s %10s %10s %10s %10s\n","No", "Name", "Flight No", "Flight Destination", "Seat", "Payment", "Discount", "Total");
      System.out.println("____________________________________________________________________________________________");
      // Iterated map of found bookings
      for(Map.Entry<Integer, Booking> bookingEntry: bookings.entrySet())
      {
        // The key is printed, which is an integer index
        System.out.printf("%2s",bookingEntry.getKey());
        // To each index there is a booking information
        System.out.println(bookingEntry.getValue().toString());
      }
      // Prompts if a user wants to cancel a booking
      System.out.print("Would you like to cancel a booking 'Y'? ");
      String choice = scanner.nextLine();
      if(Objects.equals(choice,"Y"))
      {
        try
        {
          System.out.println("Enter the booking index");
          Integer cancelBook = Integer.parseInt(scanner.nextLine());
          // Based on the chosen index in the table, the booking is cancelled
          passenger.cancelBooking(bookings.get(cancelBook), flightService);
        }
        catch(NumberFormatException e)
        {
          System.out.println("Type in a number, selection aborted!");
        }
      }
    }
  }

  static void searchFlights(Scanner scanner, FlightService flightService)
  {
    // User enters cities to search for flights:
    System.out.print("Enter Departure City (leave blank for any): ");
    String cityData1 = scanner.nextLine();
    System.out.print("Enter Destination City (leave blank for any): ");
    String cityData2 = scanner.nextLine();

    // Retrieves a map of found flights with their indexes
    Map<Integer, Flight> foundFlights = flightService.searchFlights(cityData1,cityData2);

    // No flights are found:
    if(foundFlights.isEmpty())
    {
      System.out.println("None found");
    }
    // Map with its index and corresponding flight is being iterated
    else
    {
      // Printing the table headline
      System.out.printf("%2s %10s %15s %15s %20s %20s %10s\n","No","Flight","From", "To", "Start", "Arrive", "Price");
      System.out.println("________________________________________________________" +
              "__________________________________________");
      // Iterates each found flight using a map:
      for(Map.Entry<Integer, Flight> flight : foundFlights.entrySet())
      {
        // Prints the index of the found flight, which is the index number:
        System.out.printf("%3s", flight.getKey());
        // Prints flight values using the toString method
        System.out.print(flight.getValue().toString());
      }
      // Asks for an index of the flight shown on the table to show the available seats
      System.out.print("Type the number you want, (Enter for no further info): ");
      String stringChoice = scanner.nextLine();
      try
      {
        // The choice is not "Enter", but an index number, so it will show the available seats
        if(!stringChoice.strip().isBlank())
        {
          int intChoice = Integer.parseInt(stringChoice);
          int counter = 0;
          System.out.println("Business Class");
          for(Seat seat: foundFlights.get(intChoice).getSeats())
          {
            counter++;
            System.out.printf("%3s ", seat.getAvailability());

            if(counter % 6 == 0)
            {
              System.out.println();
            }
            if(counter == 6*5)
            {
              System.out.println("Economy Class");
            }
            else if(counter % 3 == 0 && counter % 6 != 0)
            {
              System.out.print("  |  ");
            }
          }
        }
      }
      catch(NumberFormatException e)
      {
        System.out.println("Type in a number, selection aborted!");
      }
    }
  }

  static void bookFlight(Scanner scanner, Passenger passenger, FlightService flightService)
  {
    System.out.print("Enter Flight Number: ");
    String bookingFlightNumber = scanner.nextLine();
    System.out.print("Enter Seat Number: ");
    String bookingSeat = scanner.nextLine();
    try
    {
      passenger.bookFlight(bookingFlightNumber,bookingSeat, flightService);
    }
    catch(ReserveSeatException e)
    {
      System.out.println(e.getMessage());
    }
  }

  static void addFlight(Scanner scanner, FlightService flightService)
  {
    try
    {
      System.out.print("Enter Flight Number (ex. -> XX123): ");
      String flightNumber = scanner.nextLine();
      System.out.print("Enter Departure City: ");
      String depCity = scanner.nextLine();
      System.out.print("Enter Destination City: ");
      String destCity = scanner.nextLine();
      System.out.print("Enter Departure Time (yyyy-MM-dd HH:mm +/-HH:mm): ");
      String depTime = scanner.nextLine();
      System.out.print("Enter Arrival Time (yyyy-MM-dd HH:mm +/-HH:mm): ");
      String arrTime = scanner.nextLine();

      // The time is formatted, then parsed, so that specific data could then be retrieved from the entered time
      // z is used for parsing the time zone
      DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm z");
      ZonedDateTime datetimeFrom = ZonedDateTime.parse(depTime, dtFormat);
      ZonedDateTime datetimeTo   = ZonedDateTime.parse(arrTime, dtFormat);

      System.out.print("Enter Base Price for the flight: ");
      double basePrice = Float.parseFloat(scanner.nextLine());

      flightService.addFlight(flightNumber, depCity, datetimeFrom, destCity, datetimeTo, basePrice);
    }
    catch(FlightBookingException | CityNameException | FlightNumException e)
    {
      System.out.println(e.getMessage());
    }
    catch(NumberFormatException e)
    {
      System.out.println("Use Numbers for the base price!");
    }
    catch (DateTimeParseException e)
    {
      System.out.println("Error, use the proper format for date and time");
    }
  }
}