package Ex3.Travellers;

import Ex3.Destination;
import Ex3.Traveller;

public class BusinessTraveller extends Traveller
{
    public BusinessTraveller(String name, String travelerId)
    {
        super(name, travelerId);
    }
    @Override
    public void bookTrip(Destination destination)
    {
        super.bookTrip(destination);
        System.out.println("Business Traveller-specific booking logic");
        System.out.println();
    }
    @Override
    public void cancelTrip()
    {
        super.cancelTrip();
        System.out.println("Business Traveller-specific cancellation logic");
        System.out.println();
    }
}
