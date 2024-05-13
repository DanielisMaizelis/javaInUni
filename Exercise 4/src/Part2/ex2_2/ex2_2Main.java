package Part2.ex2_2;

import java.util.*;

public class ex2_2Main
{
  // Without the use of functions:
  public void method1()
  {
    List<String> tasks1 = List.of("Finish Project", "Send Emails");
    List<String> tasks2 = List.of("Clean room", "Call Mum");
    Map<String, List<String>> categories = Map.of("Work", tasks1, "Home", tasks2);
    for(Map.Entry<String,List<String>> cat : categories.entrySet())
    {
      System.out.println("Category: " + cat.getKey());
      for(String task : cat.getValue())      {
        int index = cat.getValue().indexOf(task);
        System.out.println(index+1 + ". " +cat.getValue().get(index));
      }
    }
  }

  // With the use of functions:
  public void method2()
  {
    Map<String, ArrayList<String>> categories = new HashMap<String, ArrayList<String>>();

    this.addTask("Work", "Finish Project", categories);
    this.addTask("Home", "Call Mum", categories);
    this.addTask("Work", "Eat food", categories);

    this.listTasks("Work", categories);
    this.listTasks("Home", categories);
    this.listTasks("Gym", categories);
  }

  private void listTasks(String categoryName, Map<String, ArrayList<String>> map)
  {
    boolean matchesFound = false;
    for(Map.Entry<String, ArrayList<String>> c : map.entrySet())
    {
      if(Objects.equals(c.getKey(), categoryName))
      {
        matchesFound = true;
        System.out.println("Category: " + c.getKey());
        for(String task : c.getValue())
        {
          int index = c.getValue().indexOf(task);
          System.out.println(index+1 + ". " +c.getValue().get(index));
        }
      }
    }
    if(!matchesFound)
    {
      System.out.println(categoryName + " Category not found");
    }
  }
  private void addTask(String categoryName, String task, Map<String, ArrayList<String>> map)
  {
    boolean matchesFound = false;

    // Lists out the elements of a map:
    for(Map.Entry<String, ArrayList<String>> c : map.entrySet())
    {
      // Match is found, which means the task is added
      // To the existing category
      if(Objects.equals(c.getKey(), categoryName))
      {
        c.getValue().add(task);
        matchesFound = true;
      }
    }

    // However, if the map does not have elements
    // or there aren't any matches, it will create a new category
    // With the tasks given
    if(map.isEmpty() || !matchesFound)
    {
      ArrayList<String> a = new ArrayList<String>();
      a.add(task);
      map.put(categoryName,a);
    }
  }
}
