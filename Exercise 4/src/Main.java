// Pert 1:
import Part1.ex1_1.ex1_1Main;
import Part1.ex1_2.ex1_2Main;
import Part1.ex1_3.ex1_3Main;
import Part1.ex1_4.ex1_4Main;
import Part1.ex1_5.ex1_5Main;
import Part1.ex1_6.ex1_6Main;
import Part1.ex1_7.ex1_7Main;
import Part1.ex1_8.ex1_8Main;
import Part1.ex1_10.ex1_10Main;

// Part 2:
import Part2.ex2_1.ex2_1Main;
import Part2.ex2_2.ex2_2Main;
import Part2.ex2_3.ex2_3Main;
import Part2.ex2_4.ex2_4Main;
import Part2.ex2_5.ex2_5Main;

public class Main
{
  public static void main(String[] args)
  {
    // Part 1:
    ex1_1Main ex1_1 = new ex1_1Main();
    ex1_2Main ex1_2 = new ex1_2Main();
    ex1_3Main ex1_3 = new ex1_3Main();
    ex1_6Main ex1_6 = new ex1_6Main();
    ex1_7Main ex1_7 = new ex1_7Main();
    ex1_4Main ex1_4 = new ex1_4Main();
    ex1_5Main ex1_5 = new ex1_5Main();
    ex1_8Main ex1_8 = new ex1_8Main();
    ex1_10Main ex1_10 = new ex1_10Main();     // ?? Check again

    // Part 2:
    ex2_1Main ex2_1 = new ex2_1Main(); // Make a different way
    ex2_2Main ex2_2 = new ex2_2Main(); // Make a different way
    ex2_3Main ex2_3 = new ex2_3Main(); // Make a different way
    ex2_4Main ex2_4 = new ex2_4Main(); // Make a different way, which is more simple
    ex2_5Main ex2_5 = new ex2_5Main();
    ex2_5.start();
  }
}