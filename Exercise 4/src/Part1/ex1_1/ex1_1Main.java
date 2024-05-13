package Part1.ex1_1;

import java.util.*;



public class ex1_1Main
{
  public void partA()
  {
    ArrayList<Integer> numbers = new ArrayList<Integer>();

    for(int i=10;i<=50; i+=10)
    {
      numbers.add(i);

    }
    System.out.println("ArrayList: "+numbers);
  }

  public void partB()
  {
    List<Integer> numbers = List.of(10,20,30,40,50);
    System.out.println("List: "+numbers);
  }
}
