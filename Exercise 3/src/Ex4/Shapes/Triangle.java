package Ex4.Shapes;

import Ex4.Shape;


public class Triangle extends Shape
{
    private double width;
    private double height;
    private double side;
    public Triangle(double width, double height, double side)
    {
        this.width  = width;
        this.height = height;
        this.side   = side;
    }

    @Override
    public double calculateArea()
    {
        return 0.5*(width*height);
    }

    @Override
    public double calculatePerimeter()
    {
        return width+height+side;
    }
}
