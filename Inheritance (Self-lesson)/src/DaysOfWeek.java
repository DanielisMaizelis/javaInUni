public enum DaysOfWeek
{
  // You can have more than 1 value assigned to each enum
  DaysOfWeek_MONDAY(10),
  DaysOfWeek_TUESDAY(20),
  DaysOfWeek_WEDNESDAY(60),
  DaysOfWeek_THURSDAY(70),
  DaysOfWeek_FRIDAY(70),
  DaysOfWeek_SATURDAY(80),
  DaysOfWeek_SUNDAY(90);

  // Usage of int cannot be changed, like a constant
  final int moneySpent;
  DaysOfWeek(int moneySpent)
  {
    this.moneySpent = moneySpent;
  }

}
