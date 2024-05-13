package Part2.ex2_3;

import java.util.*;

public class ex2_3Main
{
  public void start()
  {
    Map<String, Set<String>> genres = new HashMap<>();
    addGenre("H","fekl", genres);
    addGenre("H","lkgner", genres);
    addGenre("Thriller","Crime and Punishment", genres);
    addGenre("Thriller","Prisoners", genres);
    listByGenre("Thriller", genres);
    listByGenre("H", genres);

    System.out.println(bookExists("Crime and Punishment", genres));
  }
  private void addGenre(String genre,  String book, Map<String, Set<String>> genres)
  {
    boolean isMatch = false;

    for(Map.Entry<String, Set<String>> gen : genres.entrySet()){
      if(Objects.equals(gen.getKey(), genre))
      {
        isMatch = true;
        gen.getValue().add(book);
      }
    }
    if(genres.isEmpty() || !isMatch){
      Set<String> books = new HashSet<>();
      books.add(book);
      genres.put(genre, books);
    }
  }


  private void listByGenre(String genre, Map<String, Set<String>> genres)
  {
    boolean isMatch = false;
    for(Map.Entry<String, Set<String>> gen : genres.entrySet())
    {
      if(Objects.equals(gen.getKey(), genre))
      {
        isMatch = true;
        System.out.println(gen.getKey());
        for(String b: gen.getValue())
        {
          System.out.println(b);
        }
      }
    }
    if(genres.isEmpty() || !isMatch)
    {
      System.out.println("Not found");
    }
  }

  private boolean bookExists(String book, Map<String, Set<String>> genres)
  {
    for(Set<String> b : genres.values())
    {
      if(b.contains(book))
      {
        return true;
      }
    }
    return false;
  }
}
