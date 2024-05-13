package Ex5;

import Ex5.AccountHolders.RetireeAccountHolder;
import Ex5.AccountHolders.StudentAccountHolder;
import Ex5.BankAccounts.CheckingAccount;
import Ex5.BankAccounts.SavingsAccount;

public class Exercise5
{
  public void start()
  {
    SavingsAccount savingsAccount   = new SavingsAccount();
    CheckingAccount checkingAccount = new CheckingAccount();
    AccountHolder student           = new StudentAccountHolder("Alice Johnson", savingsAccount, "S12345");
    AccountHolder retiree           = new RetireeAccountHolder("Bob Smith", checkingAccount, 65);
    Transaction transaction1        = new Transaction("Deposit", 1000, "2023-08-25");
    Transaction transaction2        = new Transaction("Withdrawal", 500, "2023-08-26");


    student.getAccount().deposit(transaction1.amount());
    retiree.getAccount().withdraw(transaction2.amount());
    student.displayAccountDetails();
    retiree.displayAccountDetails();

  }
}
