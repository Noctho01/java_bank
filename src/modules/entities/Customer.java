package modules.entities;

import modules.valueObjects.*;

public class Customer {
  private Name name;
  private Email email;
  private Balance balance;

  public Customer(Name name, Email email, Balance balance) throws Exception {
    if (name == null)
      throw new Exception("Customer.name is null");

    if (email == null)
      throw new Exception("Customer.email is null");

    if (balance == null)
      throw new Exception("Customer.balance is null");

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

  public void transfer(Balance valueToTransfer) throws Exception {
    if (valueToTransfer.getValue() >= this.balance.getValue())
      throw new Exception("saldo insuficiente");

    float resto = this.balance.getValue() - valueToTransfer.getValue();
    Balance newBalance = new Balance(resto, this.balance.getCoin());

    this.balance = newBalance;
  }

  public void receive(Balance valueToReceive) throws Exception {
    if (valueToReceive.getValue() <= 0)
      throw new Exception("impossivel receber um valor igual ou menor a zero");

    float total = this.balance.getValue() + valueToReceive.getValue();
    Balance newBalance = new Balance(total, this.balance.getCoin());

    this.balance = newBalance;
  }
}
