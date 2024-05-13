public class Motorcycle extends Vehicle
{
  private int howManyCcs;

  public Motorcycle(String name, String color, String style, String make, boolean isOk, int howManyCcs)
  {
    super(name, color, style, make, isOk);
    this.howManyCcs = howManyCcs;
  }


  public void setHowManyCcs(int howManyCcs)
  {
    this.howManyCcs = howManyCcs;
  }

  public int getHowManyCcs()
  {
    return howManyCcs;
  }
  @Override
  public void printAll()
  {
    if(this.isOk)
    {
      System.out.println("Printing: "+this.name);
      System.out.println("-------------------------");
      System.out.println("Color is: "+this.color);
      System.out.println("Style is: "+this.style);
      System.out.println("Make is: "+this.make);
      System.out.println(+this.howManyCcs+" CCS");
      System.out.println("--------------------------\n");
    }
    else
    {
      System.out.println(this.name+" is not ok, sorry...:(");
    }
  }


}
