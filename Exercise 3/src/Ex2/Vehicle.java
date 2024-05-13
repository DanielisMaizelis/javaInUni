package Ex2;

import java.util.ArrayList;

public abstract class Vehicle implements Maintainable
{
    private String make;
    private String model;
    private int year;


    public Vehicle(String make, String model, int year)
    {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    @Override
    public void scheduleMaintenance(MaintenanceTypes maintenance)
    {
        System.out.println("Scheduled "+maintenance+" for "+make+" "+model);
    }

    @Override
    public void performMaintenance()
    {
        System.out.println("Performing maintenance for "+ year+" "+ make +" "+ model);
    }
}
