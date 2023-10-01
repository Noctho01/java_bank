package factories;

import modules.dtos.CustomerDto;
import modules.entities.Customer;

public class CustomerToDto {
  public final static CustomerDto execute(Customer customer) {
    return new CustomerDto(
        customer.getName().fullName(),
        customer.getEmail().getEmail(),
        customer.getBalance().format());
  }
}
