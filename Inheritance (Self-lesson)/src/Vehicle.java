public class Vehicle
{
  // Same in Car class as in the Motorcycle class:
  protected String name;
  protected String color;
  protected String style;

  protected String make;
  protected boolean isOk;
  // ---------

  public Vehicle(String name, String color, String style, String make, boolean isOk)
  {
    this.name = name;
    this.color = color;
    this.style= style;
    this.make= make;
    this.isOk = isOk;
  }

  public void setIsOk(boolean isOk){this.isOk = isOk;}
  public boolean getIsOk()
  {
    return this.isOk;
  }
  public void setColor(String color){this.color = color;}
  public String getColor()
  {
    return this.color;
  }
  public void setStyle(String style){this.style = style;}
  public String getStyle()
  {
    return this.style;
  }
  public void setMake(String make){this.make = make;}
  public String getMake()
  {
    return this.make;
  }



  public void printAll()
  {
    if(this.isOk)
    {
      System.out.println("Printing: "+this.name);
      System.out.println("-------------------------");
      System.out.println("Color is: "+this.color);
      System.out.println("Style is: "+this.style);
      System.out.println("Make is: "+this.make);
      System.out.println("--------------------------\n");
    }
    else
    {
      System.out.println(this.name+" is not ok, sorry...:(");
    }
  }
}
