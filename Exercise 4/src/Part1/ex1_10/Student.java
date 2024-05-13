package Part1.ex1_10;

import java.util.Objects;

public record Student(String name, int rollNumber)
{

  // ???
  @Override
  public boolean equals(Object o) {
    return o instanceof Student s && rollNumber == s.rollNumber;
  }

  @Override
  public int hashCode() {
    return Objects.hash(rollNumber);
  }
}
