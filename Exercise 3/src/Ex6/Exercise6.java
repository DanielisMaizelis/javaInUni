package Ex6;

import Ex6.Products.DigitalProduct;
import Ex6.Products.PhysicalProduct;

public class Exercise6
{
  public void start()
  {
    Product physicalProduct = new PhysicalProduct("Book", 100, 3.5);
    Product digitalProduct = new DigitalProduct("eBook", 50, 100);
    // Create warehouses
    Warehouse warehouse1 = new Warehouse("W1");
    Warehouse warehouse2 = new Warehouse("W2");
    // Add products to warehouses
    warehouse1.receiveProduct(physicalProduct);
    warehouse2.receiveProduct(digitalProduct);
    // Create inventory
    Inventory inventory = new Inventory();
//    inventory.addWarehouse(warehouse1);
//    inventory.addWarehouse(warehouse2);
//    // Display initial inventory status
//    System.out.println("Initial Inventory Status:");
//    inventory.displayInventoryStatus();
//    // Ship products and update inventory
//    inventory.shipProductFromWarehouse(warehouse1, physicalProduct, 20);
//    inventory.shipProductFromWarehouse(warehouse2, digitalProduct, 30);
//    // Display updated inventory status
//    System.out.println("Updated Inventory Status:");
//    inventory.displayInventoryStatus();
//    // Display shipment records (New step)
//    System.out.println("Shipment Records:");
//    inventory.displayShipmentRecords();
  }
}
