package Part1.ex1_4;
import java.util.List;
public class ex1_4Main
{
  public void start()
  {
    int sum = 0;
    List<Integer> numbers = List.of(10,20,30,40,50);
    for(int number: numbers)
    {
      sum+=number;
    }
    System.out.println("Sum (Autoboxing): "+sum);
  }
}
