package Part2.ex2_4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ex2_4Main
{

  public void start()
  {
    Map<String, Map<String, Integer>> categories = new HashMap<>();


    // Item is incremented:
    addItem("Groceries", "Milk",1,categories);
    addItem("Groceries", "Milk",2,categories);
    addItem("Groceries", "Cola",2,categories);
    addItem("Groceries", "Cola",3,categories);
    addItem("Fridge", "Milk",4,categories);
    addItem("Fridge", "Cola",5,categories);
    addItem("Fridge", "Butter",3,categories);

    updateQuantity("Fridge", "Milk",22,categories);
    updateQuantity("Fridge", "Cola",22,categories);

    printItems("Groceries", categories);
    printItems("Fridge", categories);
  }


  private void updateQuantity(String categoryName, String itemName, int quantity, Map<String, Map<String,Integer>> categories)
  {
    for(Map.Entry<String, Map<String, Integer>> category: categories.entrySet())
    {
      if(Objects.equals(category.getKey(), categoryName))
      {
        for(Map.Entry<String,Integer> item: category.getValue().entrySet())
        {
          if(Objects.equals(item.getKey(), itemName))
          {
            item.setValue(quantity);
          }
        }
      }
    }
  }
  private void printItems(String categoryName, Map<String, Map<String,Integer>> categories)
  {
    if(categories.containsKey(categoryName)){
      for(Map.Entry<String, Map<String, Integer>> category : categories.entrySet()){
        if(Objects.equals(category.getKey(), categoryName)){
          System.out.println("Category: " + categoryName);
          for(Map.Entry<String, Integer> item : category.getValue().entrySet()){
            System.out.printf("- %s (Quantity: %d)", item.getKey(), item.getValue());
            System.out.println();
          }
        }
      }
    }
    else
    {
      System.out.println("Could not find the category");
    }
  }


  private void addItem(String categoryName, String itemName, int quantity, Map<String, Map<String,Integer>> categories)
  {
    // The category map is empty, so add a new category with the
    // Item name and the quantity of 1
    if(categories.isEmpty() || !categories.containsKey(categoryName))
    {
      Map<String,Integer> itemInfo = new HashMap<>();
      itemInfo.put(itemName,quantity);
      categories.put(categoryName,itemInfo);
    }

    // Otherwise, the category is present
    else if(!categories.isEmpty() && categories.containsKey(categoryName))
    {
      for(Map.Entry<String, Map<String, Integer>> category: categories.entrySet())
      {
        boolean isMatch = false;

        Map<String, Integer> itemsInfo = new HashMap<>();
        // Category is found
        if(Objects.equals(category.getKey(), categoryName))
        {
          for(Map.Entry<String,Integer> item: category.getValue().entrySet())
          {
            itemsInfo.put(item.getKey(), item.getValue());
            if(Objects.equals(item.getKey(), itemName))
            {
              int quantityTemp = item.getValue();
              item.setValue(quantityTemp + quantity);
              isMatch = true;
            }
          }
          if(!isMatch)
          {
            itemsInfo.put(itemName,quantity);
            categories.put(categoryName,itemsInfo);
          }
        }
      }
    }
  }


}
