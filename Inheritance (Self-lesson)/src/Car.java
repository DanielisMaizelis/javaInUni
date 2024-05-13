public class Car extends Vehicle
{
  private boolean autoPark;

  public Car(String name, String color, String style, String make, boolean isOk)
  {
    super(name, color, style, make, isOk);
  }

  public void setAutoPark(boolean autoPark)
  {
    this.autoPark = autoPark;
  }

  public boolean getAutoPark()
  {
    return this.autoPark;
  }
}
