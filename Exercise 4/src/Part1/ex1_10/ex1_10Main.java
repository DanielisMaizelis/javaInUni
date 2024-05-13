package Part1.ex1_10;


import java.util.HashSet;
import java.util.Set;

public class ex1_10Main
{
  public void start()
  {
    Student student1 = new Student("Danielis", 100);
    Student student2 = new Student("Anna", 101);
    Student student3 = new Student("Alice", 102);
    Student student4 = new Student("Berta", 103);
    Set<Student> s = new HashSet<Student>();

    s.add(student1);
    s.add(student2);
    s.add(student3);
    s.add(student4);

    System.out.println("Students: ");
    for(Student student: s)
    {
      System.out.println(student.name() + " "+student.rollNumber());
    }

    System.out.println(student1.hashCode());
  }
}
