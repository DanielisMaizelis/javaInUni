public class Learning1
{
  public void typeCasting()
  {
    byte b = 69;
    int  a = 200;
    b      = (byte)a; // ???
    System.out.println("Type-casting: ");
    System.out.println(b);
    System.out.println("--------------------------\n");
  }
  public void incrementation()
  {
    int a = 3000;
    // Pre -  increment - makes incrementation after the second time
    System.out.println("Pre-increment: ");
    System.out.println("A1 - "+ ++a);
    System.out.println("--------------------------\n");

    // Post increment - makes incrementation after the second time
    a = 3000;
    System.out.println("Post increment: ");
    System.out.println("A1 - "+ a++);
    System.out.println("A2- "+ a++);
    System.out.println("--------------------------\n");
  }
  public void comparingValues()
  {
    // Comparing values:
    System.out.println("Comparing values: ");
    int c = 3000;
    int d = 3010;
    boolean isBigger = c > d;
    System.out.println(isBigger);
    System.out.println("--------------------------\n");
  }
  public void ternary()
  {
    // Ternary operator:
    System.out.println("Ternary operator: ");
    int n = 4;
    // If it is divisive by 2, assign 10, otherwise - 20
    int result = n % 2 == 0 ?10 :20;
    System.out.println(result);
    System.out.println("--------------------------\n");
  }

  public void switchCase1()
  {
    // Switch case and enums:
    System.out.println("Switch case: ");
    DaysOfWeek day = DaysOfWeek.DaysOfWeek_MONDAY;
    for(int i =0; i<2; i++)
    {
      switch(day)
      {
        case DaysOfWeek_MONDAY:
          System.out.println("It is Monday");
          System.out.println("You spent: "+day.moneySpent+"Eur");
          day = DaysOfWeek.DaysOfWeek_SUNDAY;
          break;

        case DaysOfWeek_SUNDAY:
          System.out.println("It is Sunday");
          System.out.println("You spent: "+day.moneySpent+"Eur");
          break;
      }
    }
    System.out.println("--------------------------\n");
  }
  public void switchCase2()
  {
    // Switch case part 2:


    System.out.println("--------------------------\n");
  }

}
