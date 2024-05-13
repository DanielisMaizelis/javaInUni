package Ex5.BankAccounts;

import Ex5.BankAccount;

public class SavingsAccount implements BankAccount
{
  private double balance;
  @Override
  public void deposit(double amount)
  {
    balance+=amount;
  }

  @Override
  public void withdraw(double amount)
  {
    balance-=amount;
  }

  @Override
  public double getBalance()
  {
    return balance;
  }
}
