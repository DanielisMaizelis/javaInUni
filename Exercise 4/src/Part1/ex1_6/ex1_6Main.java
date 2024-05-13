package Part1.ex1_6;

import java.util.ArrayList;
import java.util.Comparator;

public class ex1_6Main
{
  public void start()
  {
    Product p1 = new Product("Monitor", 299.22);
    Product p2 = new Product("Phone", 200.00);
    Product p3 = new Product("Laptop", 500.00);

    ArrayList<Product> products = new ArrayList<>();
    products.add(p1);
    products.add(p2);
    products.add(p3);


    products.sort(Comparator.comparingDouble(Product::getPrice)); // ?


    for(Product product : products){
      System.out.printf("Part1.ex6.Product[name=%s, price=%,.2f]\n", product.getName(), product.getPrice());
    }
  }
}
