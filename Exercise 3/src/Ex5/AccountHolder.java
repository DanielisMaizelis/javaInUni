package Ex5;

public abstract class AccountHolder
{
  private String name;
  private BankAccount account;

  public AccountHolder(String name, BankAccount account)
  {
    this.name = name;
    this.account = account;
  }

  public void displayAccountDetails()
  {
    System.out.println("Account holder: "+name);
    System.out.println("Account type: "+account.getClass().getSimpleName());
    System.out.println("Current balance: "+account.getBalance());
    System.out.println();
  }
  public BankAccount getAccount()
  {
    return account;
  }

}
