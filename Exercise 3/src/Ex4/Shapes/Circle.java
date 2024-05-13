package Ex4.Shapes;

import Ex4.Shape;

public class Circle extends Shape
{
    private double radius;

    public Circle(double radius)
    {
        this.radius = radius;
    }

    @Override
    public double calculateArea()
    {
        return 3.14*radius*radius;
    }

    @Override
    public double calculatePerimeter()
    {
        return 3.14*2*radius;
    }

    @Override
    public String toString()
    {
      return String.format("Shape: %s Radius : %f", this.getClass().getSimpleName(), radius);
    }
}
