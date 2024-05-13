package Part2.ex2_5;

import java.util.*;

public class ex2_5Main
{
  public void start()
  {
    Map<String, List<String>> classAttendances = new HashMap<>();
    addAttendance("Daniel","2023-11-27",classAttendances);
    addAttendance("Daniel","2023-11-28",classAttendances);
    addAttendance("Berta","2023-11-28",classAttendances);
    addAttendance("Berta","2023-11-29",classAttendances);
    addAttendance("Berta","2023-11-30",classAttendances);
    calculateAttendance("Berta",classAttendances);
    calculateAttendance("Daniel", classAttendances);

    listAttendance("Daniel",classAttendances);
    listAttendance("Berta",classAttendances);
    listAttendance("John",classAttendances);
  }

  private void listAttendance(String name, Map<String, List<String>> classAttendances)
  {
    if(classAttendances.containsKey(name))
    {
      List<String> l = classAttendances.get(name);
      System.out.println(name+":");
      for(String a : l)
      {
        System.out.println(a);
      }
    }
    else
    {
      System.out.println("Name not found");
    }

  }

  private void calculateAttendance(String name, Map<String, List<String>> classAttendances)
  {

    if(classAttendances.containsKey(name))
    {
      List<String> l = classAttendances.get(name);
      System.out.println(name+" attended: "+l.size()+" times");
    }
    else
    {
      System.out.println("Person not found");
    }
  }

  private void addAttendance(String name, String date, Map<String,List<String>> classAttendances)
  {
    if(classAttendances.isEmpty() || !classAttendances.containsKey(name))
    {
      ArrayList<String> dates = new ArrayList<>();
      dates.add(date);
      classAttendances.put(name,dates);
    }
    else
    {
      List<String> dates = classAttendances.get(name);
      dates.add(date);
      classAttendances.put(name,dates);
    }
  }

}
