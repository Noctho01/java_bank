package modules.entities;

import modules.valueObjects.Balance;
import modules.valueObjects.Email;
import modules.valueObjects.Name;

public class Customer {
  private Name name;
  private Email email;
  private Balance balance;

  public Customer(Name name, Email email, Balance balance) {

    if (name == null) new Exception("Customer.name is null");
    if (email == null) new Exception("Customer.email is null");
    if (balance == null) new Exception("Customer.balance is null");

    this.name = name;
    this.email = email;
    this.balance = balance;
  }

  public Name getName() {
    return name;
  }

  public Email getEmail() {
    return email;
  }

  public Balance getBalance() {
    return balance;
  }

  public void transfer(Balance valueToTransfer) {
    if (valueToTransfer.getValue() >= this.balance.getValue())
      new Exception("saldo insuficiente");

    float resto = this.balance.getValue() - valueToTransfer.getValue();
    Balance newBalance = new Balance(resto, this.balance.getCoin());

    this.balance = newBalance;
  }

  public void receive(Balance valueToReceive) {
    if (valueToReceive.getValue() <= 0)
      new Exception("impossivel receber um valor igual ou menor a zero");

    float total = this.balance.getValue() + valueToReceive.getValue();
    Balance newBalance = new Balance(total, this.balance.getCoin());
    
    this.balance = newBalance;
  }
}
