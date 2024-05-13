package Ex3.Travellers;

import Ex3.Destination;
import Ex3.Traveller;
import Ex3.Trip;

public class Tourist extends Traveller
{
    public Tourist(String name, String travelerId)
    {
        super(name, travelerId);
    }

    @Override
    public void bookTrip(Destination destination)
    {
        super.bookTrip(destination);
        System.out.println("Tourist-specific booking logic");
        System.out.println();
    }
    @Override
    public void cancelTrip()
    {
        super.cancelTrip();
        System.out.println("Tourist-specific cancellation logic");
        System.out.println();
    }


}
