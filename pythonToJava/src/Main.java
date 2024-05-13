// "package" tells the

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
  public static void main(String[] args)
  {
    Main myApp = new Main();
    fileRead file = new fileRead();
    fileRead.start("text.txt");
    //    myApp.ep4();
    //    myApp.ep5(1, true);
    //    myApp.ep6();
    //    myApp.ep7();
    myApp.ex8();

  }

  private void ep4()
  {
    // bool value:
    boolean isPoor = true;

    // float value:
    double balance = 12.5;

    // string value:
    String name = "Danielis";

    // int value:
    int age = 21;

    // Printing using printf
    System.out.printf("%s%n", name);
    System.out.printf("%f%n", balance);
    System.out.printf("%d%n", age);
  }
  private void ep5(int numOfErrors, boolean tryTheOldWay)
  {
    if (tryTheOldWay)
    {
      switch(numOfErrors)
      {
        case 0:
          System.out.println("No errors detected");
          break;
        case 1:
          System.out.println("One error detected");
          break;
        default:
          System.out.println("Many errors are detected");
          break;
      }
    }
    else
    {
      String message = switch(numOfErrors){
        case 0  -> "No errors detected";
        case 1  -> "One error detected";
        default -> "Many errors are detected";
      };
      System.out.println(message);
    }
  }
  private void ep6()
  {
    // For loops
    for(int i = 0; i < 10; i++)
    {
      System.out.println("i = " + i);
    }

    // do - while loop
    int i = 0;
    do
    {
      System.out.println(i++);

    } while(i < 10);

    System.out.println("Other incementation: ");
    i = 0;
    do
    {
      System.out.println(++i);
    } while(i < 10);
  }

  private void ep7()
  {
    // arrays are fixed size, and array lists are dynamic size
    ArrayList<String> names = new ArrayList<>();
    names.add("Anna");
    names.add("Kalle");

    // For loop:
    System.out.println("--------------------");
    System.out.println("Simple for loop");
    for(int i=0; i<names.size(); i++)
    {
      System.out.println(names.get(i));
    }

    System.out.println("--------------------");
    System.out.println("Enhanced for loop:");
    // Enhanced for loop:
    for(String name : names){
      System.out.println(name);
    }

    String[] moreNames = new String[2];
    moreNames[0] = "Hello1";
    moreNames[1] = "Hello2";

    System.out.println("--------------------");
    System.out.println("Enhanced for loop No2:");
    for(int i=0; i<moreNames.length; i++)
    {
      System.out.println(moreNames[i]);
    }
  }

  private void ex8()
  {
    // Creating an object:
    Scanner input = new Scanner(System.in);

    System.out.print("What is your age: ");
    int age = Integer.parseInt(input.nextLine());

    // The <enter> has to be got rid of
    System.out.print("What is your name: ");
    String name = input.nextLine();

    System.out.println(name);
    System.out.println(age);
  }


}