package Part2.ex2_1;

import java.util.Map;

public class ex2_1Main
{
  public void start()
  {

    Map<String, String> courses1 = Map.of("Maths", "A", "Lithuanian", "B");
    Map<String, String> courses2 = Map.of("IT", "A", "English", "B");

    Map<String, Map<String,String>> students = Map.of( "Danielis", courses1, "Alice", courses2);

    for(Map.Entry<String, Map<String,String>> student: students.entrySet() )
    {
      System.out.println(student.getKey());
      System.out.println("Courses: ");
      for(Map.Entry<String, String>  course: student.getValue().entrySet())
      {
        System.out.println(course.getKey() + ": " + course.getValue());
      }
    }
  }
}
