package Ex4;

import Ex4.Shapes.Circle;
import Ex4.Shapes.Rectangle;
import Ex4.Shapes.Triangle;

public class Exercise4
{
    public void start()
    {
        Shape[] shapes = {
                new Circle(5),
                new Rectangle(4, 6),
                new Triangle(3, 4, 5)
        };
        for (Shape shape : shapes)
        {
            System.out.println("Shape: " + shape);
            System.out.println("Area: " + shape.calculateArea());
            System.out.println("Perimeter: " + shape.calculatePerimeter());
            System.out.println();
        }
    }
}
