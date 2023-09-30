package services;

import modules.dtos.CustomerToCreationDto;
import modules.entities.Customer;
import modules.valueObjects.Balance;
import modules.valueObjects.Email;
import modules.valueObjects.Name;

public class CustomerService {

  public final static Customer create(CustomerToCreationDto customerDto) {
    Name name = new Name(customerDto.firstName(), customerDto.lastName());
    Email email = new Email(customerDto.emailtPath(), customerDto.emailDomain());
    Balance balance = new Balance(customerDto.valueAccount(), customerDto.coin());

    return new Customer(name, email, balance);
  }

  public final static void transaction(Customer protractor, Customer receiver, float value) {
    Balance valueToTransaction = new Balance(value, protractor.getBalance().getCoin());

    protractor.transfer(valueToTransaction);
    receiver.receive(valueToTransaction);
  }
}
