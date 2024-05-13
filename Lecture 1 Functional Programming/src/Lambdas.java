import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.DoubleConsumer;
import java.util.function.Predicate;

import static java.lang.StringTemplate.STR;
import static java.util.FormatProcessor.FMT;

public class Lambdas
{
  public static void main(String[] args)
  {
    // Lambdas and streams
    var students = List.of(
            new Student("Daniel",12,"U"),
            new Student("Anna",13,"3"),
            new Student("Max",14,"4"),
            new Student("Antoine",15,"5"),
            new Student("Alexander",16,"U")
            );

      // 1st way:
    System.out.println("1st way:");
    for(Student student: students)
    {
      if(student.grade().equals("4"))
      {
        System.out.println(student.name());
      }
    }

    // 2nd way:
    // Assigning values:
    System.out.println("2nd way:");
    var withGrade4 = students.stream().filter(s -> s.grade().equals("4")).toList();

    // Map is only keep
    var names = withGrade4.stream().map(s -> s.name()).toList();
    names.forEach(System.out::println);

    // 3rd way:
    System.out.println("3rd way:");
    // Filter the s variable with grade 4 and retrieve the name from it
    students.stream().filter(s-> s.grade().equals("4")).map(s -> s.name()).forEach(System.out::println);

    // Prints just the objects
    students.stream().filter(s-> s.grade().equals("4")).forEach(System.out::println);

    // Prints their ages:
    // Variable names don't make a difference:
    students.stream().filter(t-> t.grade().equals("4")).map(n -> n.age()).forEach(System.out::println);

    var totalYears = students.stream().filter(a -> a.grade().equals("4")).map(a -> a.age()).reduce(0, (a,b) -> a+b);
    var counter = students.stream().filter(a -> a.grade().equals("4")).count();
    var averageAge = totalYears / counter;
    System.out.println(STR."The average age is: \{averageAge} years");

    System.out.println("---------------");
    System.out.println("Best way:");
    Predicate<Student> hasGradeU       = s       -> s.grade().equals("U");
    DoubleConsumer     printAverage    = average -> System.out.println(FMT."The average age is :%.0f\{average} years");
    Runnable           noStudentsFound = ()      -> System.out.println("No students found");

    students.stream().filter(hasGradeU).mapToInt(Student::age).average().ifPresentOrElse(printAverage,noStudentsFound);
  }
}

record Student(String name, int age, String grade)
{
  @Override
  public String toString()
  {
    return String.format("(Age: %d) %-10s Grade:%s", age, name, grade);
  }
}