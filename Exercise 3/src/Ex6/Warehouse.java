package Ex6;

import java.util.ArrayList;

public class Warehouse
{
  String warehouseId;
  int productAmount;

  ArrayList<Product> products;

  public Warehouse(String warehouseId)
  {
    this.warehouseId = warehouseId;
    this.products = new ArrayList<>();
  }

  public void receiveProduct(Product product)
  {
    products.add(product);

  }
  public void shipProduct(Product product)
  {
    products.remove(product);
  }
}
