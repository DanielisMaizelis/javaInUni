package Ex5.AccountHolders;

import Ex5.AccountHolder;
import Ex5.BankAccount;

public class RetireeAccountHolder extends AccountHolder
{
  private double balance;
  private int age;

  public RetireeAccountHolder(String name, BankAccount account, int age)
  {
    super(name, account);
    this.age = age;
  }

  @Override
  public void displayAccountDetails()
  {
    super.displayAccountDetails();
  }
}
