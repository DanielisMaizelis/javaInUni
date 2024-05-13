package Ex2;

import Ex2.Vehicles.Car;
import Ex2.Vehicles.Motorcycle;
import Ex2.Vehicles.Truck;

public class Exercise2
{
    public void start()
    {
        Vehicle car   = new Car("Toyota","Corolla", 2023);
        Vehicle moto  = new Motorcycle("Harley Davidson","F1124", 2020);
        Vehicle truck = new Truck("Mercedes","Truck", 2000);

        Vehicle[] vehicles = {car,moto,truck};

        System.out.println();
        System.out.println("Scheduling maintenances:");
        for(Vehicle vehicle: vehicles)
        {
            vehicle.scheduleMaintenance(MaintenanceTypes.OIL_CHANGE);
            vehicle.scheduleMaintenance(MaintenanceTypes.TYRE_CHANGE);
        }
        System.out.println();
        System.out.println("Performing maintenances:");
        for (Vehicle vehicle: vehicles)
        {
            vehicle.performMaintenance();
        }
    }
}
