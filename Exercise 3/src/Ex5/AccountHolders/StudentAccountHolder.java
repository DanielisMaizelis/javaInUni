package Ex5.AccountHolders;

import Ex5.AccountHolder;
import Ex5.BankAccount;

public class StudentAccountHolder extends AccountHolder
{
  private String studentId;

  public StudentAccountHolder(String name, BankAccount account, String studentId)
  {
    super(name,account);
    this.studentId = studentId;
  }

  @Override
  public void displayAccountDetails()
  {
    super.displayAccountDetails();
  }
}
