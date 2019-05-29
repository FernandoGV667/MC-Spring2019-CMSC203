package com.fgonzalesv;

public class SavingsAccount extends BankAccount {
  private double rate = 2.5;
  private static int savingsNumber = 0;
  private String accountNumber;
  
  public SavingsAccount(String name, double amount) {
    super(name,amount);
    this.accountNumber = super.getAccountNumber() + "-" + savingsNumber++;
  }
  
  public SavingsAccount(SavingsAccount oldAccount, double amount) {
    super(oldAccount, amount);
    this.accountNumber = super.getAccountNumber() + "-" + savingsNumber++;
  }
  
  public void postInterest() {
    super.deposit(super.getBalance() * (rate / (100 * 12)));
  }
  
  public String getAccountNumber(){
    return accountNumber;
  }
}
