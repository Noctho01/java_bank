package services;

import modules.entities.Customer;
import modules.valueObjects.Balance;

public class CustomerService {

  public static void transaction(Customer protractor, Customer receiver, float value) {
    Balance valueToTransaction = new Balance(value, protractor.getBalance().getCoin());

    protractor.transfer(valueToTransaction);
    receiver.receive(valueToTransaction);
  }
}
