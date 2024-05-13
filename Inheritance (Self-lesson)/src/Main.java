import java.util.Scanner;

/*
--------------------------------------------
    Questions:
    1. Typecasting
    2. Static method purpose
    3. Public, Private, Protected variables
---------------------------------------------
*/


public class Main
{
    public static void main(String[] args)
    {
        Learning1 l1 = new Learning1();
        l1.switchCase1();
        // inheritance();
    }
    private static void inheritance()
    {
        // Declaration:
        // Moto:
        Motorcycle moto  = new Motorcycle("Motorcycle", "Blue", "Cool", "Honda", false,222);

        // Moto 2:
        Motorcycle moto2 = new Motorcycle("Motorcycle", "Red", "Nice", "Yamaha", true,12);

        // Auto:
        Car auto = new Car("Car", "Black", "Shit", "BMW", false);

        // Showing values:
        // Moto:
        System.out.println(moto.getColor());
        moto.setColor("Green (modified)");
        moto.setIsOk(true);
        moto.printAll();

        // Moto 2:
        moto2.printAll();

        // Auto
        auto.setAutoPark(true);
        System.out.println(auto.getAutoPark());
        //auto.printAll();
        auto.setIsOk(true);
        auto.printAll();

        // Printing values inside of this class method
        System.out.println("Printing values inside of this class method ");
        int num = 4;
        printNum(num);
        printNum(num+55);
        System.out.println("--------------------------\n");
    }

    private static void printNum(int number) // What is a static method?
    {
        System.out.println(number);
    }
}


