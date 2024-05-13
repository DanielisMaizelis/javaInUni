package Part1.ex1_8;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ex1_8Main
{
  public void start()
  {
    Set<String> hello = new LinkedHashSet();
    hello.add("A");
    hello.add("B");
    hello.add("C");
    hello.add("D");
    hello.add("E");
    System.out.println(hello);

    Map<Integer, String> hello2 = new TreeMap();
    hello2.put(1, "One");
    hello2.put(2, "Two");
    hello2.put(4, "Three");
    hello2.put(5, "Four");
    hello2.put(3, "Five");

    System.out.println("Tree Map");
    for(Map.Entry<Integer, String> entry: hello2.entrySet())
    {
      System.out.println("  "+entry.getKey() + ":" + entry.getValue());
    }
  }
}
