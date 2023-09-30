package usecases;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import modules.entities.Customer;

public class GetCustomerUseCase {
  ArrayList<Customer> customers;

  public GetCustomerUseCase(ArrayList<Customer> customers) {
    this.customers = customers;
  }

  public int execute(Scanner input) {
    int flow = 0;

    if (this.customers.size() == 0) {
      System.out.println("\nNenhum cliente foi cadastrado no sistema...\n");

    } else {
      System.out.println("Digite o email do cliente que deseja buscar");

      System.out.print("email: ");
      final String customerEmail = input.next();

      final Optional<Customer> findedCustomer = this.customers.stream()
          .filter(customer -> customer.getEmail().getEmail().equals(customerEmail))
          .findFirst();

      if (findedCustomer.isPresent()) {
        Customer customer = findedCustomer.get();
        System.out.println(
            String.format(
                "\nCliente: %s", customer.getName().fullName().toUpperCase()));

        System.out.println(
            String.format(
                "\nEmail: %s\nSaldo: %s\n",
                customer.getEmail().getEmail(),
                customer.getBalance().format()));

      } else {
        System.out.println("\nUsuario não encontrado\n");
      }
    }

    return flow;
  }
}
