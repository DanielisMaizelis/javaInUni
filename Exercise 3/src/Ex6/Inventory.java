package Ex6;

import java.util.ArrayList;

public class Inventory
{
  ArrayList<Warehouse> warehouses;
  ArrayList<Warehouse> shipmentRecords;

  public Inventory()
  {
    this.warehouses = new ArrayList<>();
  }
  public void addWarehouse(Warehouse warehouse)
  {
    this.warehouses.add(warehouse);
  }

  public void shipProductFromWarehouse(Warehouse warehouse, Product product, int quantity)
  {
    int amountOfProducts = product.getStockQuantity();
    product.updateStockQuantity(amountOfProducts-quantity);
  }
  public void displayInventoryStatus()
  {

  }
}
