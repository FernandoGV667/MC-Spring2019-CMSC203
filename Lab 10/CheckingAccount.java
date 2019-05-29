package com.fgonzalesv;

public class CheckingAccount extends BankAccount {
  private static final double FEE = 0.12;
  
  public CheckingAccount(String name, double amount) {
    super(name, amount);
    super.setAccountNumber(super.getAccountNumber() + "-10");
  }
  
  public boolean withdraw(double amount) {   
    return super.withdraw(amount+FEE);
  }
}
