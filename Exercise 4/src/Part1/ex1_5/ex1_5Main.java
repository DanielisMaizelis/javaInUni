package Part1.ex1_5;
import java.util.ArrayList;
import java.util.Collections;

public class ex1_5Main
{
  public void start()
  {
    ArrayList<String> listOfStrings = new ArrayList<>();
    listOfStrings.add("foo");
    listOfStrings.add("hello");
    listOfStrings.add("world");

    listOfStrings.reversed();
    this.reverse(listOfStrings);
  }

  private void reverse(ArrayList<String> list)
  {
    Collections.reverse(list);
    for(String str : list){
      System.out.println(new StringBuilder(str).reverse());
    }
  }
}
