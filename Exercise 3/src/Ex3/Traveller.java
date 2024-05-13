package Ex3;

import java.util.ArrayList;

public abstract class Traveller
{
    private String name;
    private String travelerId;
    private ArrayList<Trip> trips;
    public Traveller(String name, String travelerId)
    {
        this.name       = name;
        this.travelerId = travelerId;
        this.trips      = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }

    public String getTravelerId()
    {
        return travelerId;
    }

    public void bookTrip(Destination destination)
    {
        Trip currentTrip = new Trip(this,destination.getDestinationName(),destination.getTripCost(),"2024-01-10");
        System.out.println("Booking Successful:");
        System.out.printf("Traveller: %s (%s)", currentTrip.traveller().getName(), currentTrip.traveller().getClass().getSimpleName());
        System.out.println();
        System.out.printf("Destination: %s", currentTrip.destination());
        System.out.println();
        System.out.printf("Trip cost: $%s", currentTrip.tripCost());
        System.out.println();
        System.out.printf("Booking date: %s", currentTrip.bookingDate());
        System.out.println();
        trips.add(currentTrip);
    }

    public void cancelTrip()
    {
        if (trips.isEmpty())
        {
            System.out.println("Nothing to cancel");
        }
        else
        {
            Trip lastElement = trips.getLast();
            System.out.println();
            System.out.println("Cancellation Successful:");
            System.out.printf("Traveller: %s (%s)", lastElement.traveller().getName(), lastElement.traveller().getClass().getSimpleName());
            System.out.println();
            System.out.printf("Destination: %s", lastElement.destination());
            System.out.println();
            System.out.printf("Trip cost: $%s", lastElement.tripCost());
            System.out.println();
            System.out.printf("Booking date: %s", lastElement.bookingDate());
            System.out.println();
            lastElement = null;
        }
    }
}
