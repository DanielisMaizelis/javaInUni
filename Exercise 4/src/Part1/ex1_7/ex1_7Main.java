package Part1.ex1_7;
import java.util.Map;
public class ex1_7Main
{
  public void start()
  {
    Person p1 = new Person("19900101-1234", "Danielis Maizelis",1111);
    Person p2 = new Person("19850214-5678", "Max Kimmel",2222);
    Person p3 = new Person("19780325-4321", "Frederick Cock",9999);
    Person p4 = new Person("19780325-1111", "Frederick Cock 2nd",9999);

    Map<String, Person> taxBase = Map.of("19900101-1234",p1,
                                         "19850214-5678",p2,
                                         "19780325-4321",p3,
                                         "19780325-1111",p4);

    String pnum = "19900101-1234";

    if(taxBase.get(pnum) == null)
    {
      System.out.println("No person present with this person number");
    }
    else
    {
      System.out.println(taxBase.get(pnum).name());
      System.out.println(taxBase.get(pnum).pnumber());
      System.out.println(taxBase.get(pnum).income());
    }
  }
}
