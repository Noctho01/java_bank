package usecases;

import java.util.Scanner;
import java.util.ArrayList;

import modules.entities.Customer;

public class GetCustomersUseCase {

  ArrayList<Customer> customers;

  public GetCustomersUseCase(ArrayList<Customer> customers) {
    this.customers = customers;
  }

  public int execute(Scanner input) {
    int flow = 0;

    if (this.customers.size() == 0) {
      System.out.println("\nNenhum cliente foi cadastrado no sistema...\n");

    } else {
      System.out.println("\nClientes:\n");

      for (Customer customer : customers) {
        System.out.println(String.format(
            "%s %s %s",
            customer.getName().fullName().toUpperCase(),
            customer.getEmail().getEmail(),
            customer.getBalance().format()));
      }

      System.out.println("\n");
    }

    return flow;
  }
}
