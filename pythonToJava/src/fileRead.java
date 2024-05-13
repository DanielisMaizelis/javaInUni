import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class fileRead
{
  public static void start(String filename)
  {
    ArrayList<String> lines = new ArrayList<>();
    lines.add("Hello");
    lines.add("It is me");


    Path path = Paths.get(filename);
    System.out.println("");


    try
    {
      // Write the file:
      Files.write(path, lines, StandardOpenOption.CREATE);

      // Read the file:
      var readLines = Files.readAllLines(path);

      // Print the values:
      for(String line : readLines)
      {
        System.out.println(line);
      }
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
  }
}
