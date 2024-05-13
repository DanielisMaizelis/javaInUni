package Ex3;

import Ex3.Destinations.BeachDestination;
import Ex3.Destinations.CityDestination;
import Ex3.Travellers.Tourist;

public class Exercise3
{
    public void start()
    {
        Traveller tourist                 = new Tourist("Alice", "T123");
        CityDestination cityDestination   = new CityDestination("Paris", 500.0);
        BeachDestination beachDestination = new BeachDestination("Maldives", 1500.0);
        tourist.bookTrip(cityDestination);
        tourist.bookTrip(beachDestination);
        tourist.cancelTrip();

    }
}
