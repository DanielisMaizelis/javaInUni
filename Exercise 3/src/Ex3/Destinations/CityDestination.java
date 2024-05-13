package Ex3.Destinations;

import Ex3.Destination;

public class CityDestination implements Destination {
    private String destinationName;
    private double tripCost;

    public CityDestination(String destinationName, double tripCost)
    {
        this.destinationName = destinationName;
        this.tripCost = tripCost;
    }


    @Override
    public String getDestinationName() {
        return destinationName;
    }

    @Override
    public double getTripCost() {
        return tripCost;

    }
}
