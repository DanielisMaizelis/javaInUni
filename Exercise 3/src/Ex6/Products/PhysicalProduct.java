package Ex6.Products;

import Ex6.Product;

public class PhysicalProduct extends Product
{

  String name;
  int quantity;
  double weight;

  public PhysicalProduct(String name, int quantity, double weight)
  {
    this.name = name;
    this.quantity = quantity;
    this.weight = weight;
  }

  @Override
  public String getName()
  {
    return null;
  }

  @Override
  public int getStockQuantity()
  {
    return 0;
  }

  @Override
  public void updateStockQuantity(int quantity)
  {

  }
}
