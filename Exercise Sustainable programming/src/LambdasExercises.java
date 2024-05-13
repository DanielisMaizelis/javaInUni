import jdk.jfr.FlightRecorder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.SecureRandom;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

import static java.lang.StringTemplate.STR;
import static java.util.FormatProcessor.FMT;

record DirectoryRecord(String name, String surname, String phoneNum){}
record Person(String firstName, String lastName){}

public class LambdasExercises
{
  public static void main(String[] args) throws IOException
  {
    ex17_13();
//    ex17_16();
//    ex17_23();
  }
  public static void ex17_3()
  {
    // a) Use of a consumer, Consumer returns a void
    IntConsumer c = a -> {System.out.println(STR."a) The number is: \{a}");};
    c.accept(2);

    // b) Function<String, String> b =  s -> {return s.toUpperCase();};
    Function<String, String> b = String::toUpperCase;
    System.out.println(STR."b) The uppercase string: \{b.apply("Hello")}");

    // c)
    Runnable d = () -> System.out.println("c) Welcome to Lambdas!");
    d.run();

    // d)
    IntConsumer e = num -> {System.out.println(STR."d) The sqrt value is: \{Math.sqrt(num)}");};
    e.accept(144);

    // e) Function<String, String> b =  s -> {return s.toUpperCase();};
    Function<Integer, Integer> f = a -> {return a*a*a;};
    System.out.println(STR."e) Cubed value is: \{f.apply(4)}");
  }
  public static void ex17_6()
  {
    // a) and b) and c)?
    BinaryOperator<Double> a = (c,b) -> c*b;
    System.out.println(STR."a) and b) and c) Product is: \{a.apply(12.1,13.2)}");

    // d)
    Consumer<String> b = System.out::println;
    b.accept("Welcome to lambdas!");

    // e)?
    Supplier<ArrayList<Integer>> c = ArrayList::new;
    System.out.println(c.get());

    // f)?
  }

  public static void ex17_12()
  {
    Invoice[] invoices = {
            new Invoice(83, "Electric sander", 7, 57.98),
            new Invoice(24, "Power saw", 18, 99.99),
            new Invoice(7, "Sledge hammer", 11, 21.50),
            new Invoice(77, "Hammer", 76, 11.99),
            new Invoice(39, "Lawn mower", 3, 79.50),
            new Invoice(68, "Screwdriver", 106, 6.99),
            new Invoice(56, "Jig saw", 21, 11.00),
            new Invoice(3, "Wrench", 34, 7.50)
    };


    // a)
    System.out.println("a)");
    //    Arrays.stream(invoices).toList().stream().filter(in -> Objects.equals(in.getPartDescription(),"Hammer"))
    //            .forEach(System.out::println);

    Arrays.stream(invoices).toList().stream()
            .sorted(Comparator.comparing(Invoice::getPartDescription))
            .forEach(System.out::println);

    // b)
    System.out.println("b)");
    //    Arrays.stream(invoices).toList().stream().filter(in -> in.getPrice() <= 10)
    //            .forEach(System.out::println);

    Arrays.stream(invoices).toList().stream()
            .sorted(Comparator.comparing(Invoice::getPrice))
            .forEach(System.out::println);



    // d)
    System.out.println("d)");
    Arrays.stream(invoices).toList().stream()
            .map(obj -> new AbstractMap.SimpleEntry<>(obj.getPartDescription(),obj.getPrice()* obj.getQuantity()))
            .sorted(Comparator.comparing(AbstractMap.SimpleEntry::getValue))
            .forEach(a -> System.out.println(FMT."%-20s\{a.getKey()} $%,6.2f\{a.getValue()}"));

    // e)
    System.out.println("e)");
    Function<Invoice, Double > invoicePrice = a -> {return a.getPrice()* a.getQuantity();};
    Arrays.stream(invoices)
            .toList().stream()
            .filter(obj -> invoicePrice.apply(obj) <= 500 && invoicePrice.apply(obj) >= 200)
            .map(obj -> new AbstractMap.SimpleEntry<>(obj.getPartDescription(),invoicePrice.apply(obj)))
            .sorted(Comparator.comparing(AbstractMap.SimpleEntry::getValue))
            .forEach(a -> System.out.println(FMT."%-20s\{a.getKey()} $%,6.2f\{a.getValue()}"));

    // f)
    System.out.println("f)");
    Arrays.stream(invoices)
            .toList().stream()
            .filter(obj -> obj.getPartDescription().contains("saw"))
            .map(obj -> new AbstractMap.SimpleEntry<>(obj.getPartDescription(),invoicePrice.apply(obj)))
            .sorted(Comparator.comparing(AbstractMap.SimpleEntry::getValue))
            .forEach(a -> System.out.println(FMT."%-20s\{a.getKey()} $%,6.2f\{a.getValue()}"));

  }

  public static void ex17_13()
  {
    Random rand        = new Random();
    List<Integer>  randomNums = rand.ints(3,0,1000).boxed().toList();

    int oddNums  = randomNums.stream().filter(num -> num%2 != 0).reduce(0, Integer::sum);
    int evenNums = randomNums.stream().filter(num -> num%2 == 0).reduce(0, Integer::sum);

    System.out.println(STR."Sum of all numbers: \{oddNums+evenNums}");
    System.out.println(STR."Sum of odd numbers: \{oddNums}");
    System.out.println(STR."Sum of even numbers: \{evenNums}");

    randomNums.stream()
            .filter(num -> num%2 == 0)
            .mapToInt(a -> a).average()
            .ifPresentOrElse(System.out::println, () -> System.out.println("None found"));

    randomNums.stream()
            .filter(num -> num%2 != 0)
            .mapToInt(a -> a).average()
            .ifPresentOrElse(System.out::println, () -> System.out.println("None Found"));
  }
  public static void ex17_14() throws IOException
  {
    final var READ_FILE_NAME   = Paths.get( "DRr1.txt");
    final var WRITE_FILE_NAME1 = Paths.get("DRw1.txt");
    final var WRITE_FILE_NAME2 = Paths.get("DRw2.txt");

    Function<String, String[]> spl = a -> {return a.split(" ");};

    List<DirectoryRecord> records = Files.lines(READ_FILE_NAME)
            .toList().stream()
            .distinct().map(a -> new DirectoryRecord(spl.apply(a)[0],spl.apply(a)[1], spl.apply(a)[2])).toList();

    // a)
    List<String> aExercise = records.stream()
            .sorted(Comparator.comparing(DirectoryRecord::phoneNum))
            .map(DirectoryRecord::toString)
            .toList();
    System.out.println("a) - created");

    // b)
    List<String> bExercise = records.stream()
            .sorted(Comparator.comparing(DirectoryRecord::surname).thenComparing(DirectoryRecord::name))
            .map(DirectoryRecord::toString)
            .toList();
    System.out.println("b) - created");


    Files.write(WRITE_FILE_NAME1, aExercise, StandardOpenOption.CREATE);
    Files.write(WRITE_FILE_NAME2, bExercise, StandardOpenOption.CREATE);
  }
  public static void ex17_16()
  {
    SecureRandom rand = new SecureRandom();
    System.out.println();

    rand.ints(50,1,999)
            .filter(a -> a%2==0)
            .sorted()
            .forEach(System.out::println);
  }
  public static void ex17_18()
  {

  }
  public static void ex17_23()
  {
    ArrayList<Person> people = new ArrayList<>();
    people.add(new Person("Emanuel", "Macron"));
    people.add(new Person("Jack", "Jones"));
    people.add(new Person("Michael", "Jackson"));
    people.add(new Person("Freddie", "Jones"));
    people.stream().filter(a -> a.lastName().equals("Jones"))
            .findFirst()
            .ifPresentOrElse(System.out::println, () -> System.out.println("Not found!"));
  }
}


