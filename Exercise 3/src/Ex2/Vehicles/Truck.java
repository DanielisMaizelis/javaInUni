package Ex2.Vehicles;

import Ex2.Maintainable;
import Ex2.Vehicle;

public class Truck extends Vehicle implements Maintainable
{
    private int year;
    private String make;
    private String model;
    public Truck(String make, String model, int year)
    {
        super(make, model, year);
    }

}
