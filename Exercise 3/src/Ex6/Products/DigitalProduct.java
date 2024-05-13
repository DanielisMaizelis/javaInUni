package Ex6.Products;

import Ex6.Product;

public class DigitalProduct extends Product
{
  String name;
  double sizeMb;
  int availableDownloads;

  public DigitalProduct(String name, double sizeMb, int availableDownloads)
  {
    this.name = name;
    this.sizeMb = sizeMb;
    this.availableDownloads = availableDownloads;
  }

  @Override
  public String getName()
  {
    return name;
  }

  @Override
  public int getStockQuantity()
  {
    return 0;
  }

  @Override
  public void updateStockQuantity(int quantity)
  {
//    this.quantity = quantity;
  }
}
