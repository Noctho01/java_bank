package usecases;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import static utils.Util.*;
import factories.CustomerToDto;
import messages.Messages;
import modules.dtos.CustomerDto;
import modules.entities.Customer;
import services.CustomerService;

public class AccessCustomerUseCase {
  ArrayList<Customer> customers;

  public AccessCustomerUseCase(ArrayList<Customer> customers) {
    this.customers = customers;
  }

  public int execute(Scanner input) {
    int flow = 0;

    if (this.customers.size() == 0) {
      System.out.println("\nNenhum cliente foi cadastrado no sistema...\n");

    } else {
      System.out.println("\nDigite o email do cliente para accessa-lo");

      System.out.print("email: ");
      final String customerEmail = input.next();

      clearConsole();

      final Optional<Customer> customerOptional = this.customers
          .stream()
          .filter(customer -> customer.getEmail().getEmail().equals(customerEmail))
          .findFirst();

      if (customerOptional.isPresent()) {

        while (flow != 2 && flow != 3) {

          Customer customer = customerOptional.get();
          CustomerDto customerDto = CustomerToDto.execute(customer);

          if (flow == 0) {
            Messages.card(customerDto);
            Messages.menuInAccount();
            flow = input.nextInt();
            System.out.println(flow);

          } else if (flow == 1) {
            clearConsole();
            Messages.card(customerDto);
            System.out.println("\nSelecione o cliente a receber a transferencia..\n");

            final ArrayList<Customer> receivers = this.customers
                .stream()
                .filter(receiver -> !receiver.getEmail().getEmail().equals(customerEmail))
                .collect(Collectors.toCollection(ArrayList::new));

            for (int i = 0; i < receivers.size(); i++) {
              Customer receiver = receivers.get(i);

              System.out.println(
                  String.format(
                      "%d - %s [%s]",
                      i,
                      receiver.getName().fullName().toUpperCase(),
                      receiver.getEmail().getEmail()));
            }

            System.out.print("\nindex: ");
            final int receiverIndex = input.nextInt();

            if (receiverIndex < 0 || receiverIndex >= receivers.size()) {
              System.out.println("\nindex invalido...\n");
              flow = 1;

            } else {
              Customer receiver = receivers.get(receiverIndex);

              System.out.print("valor: ");
              final float value = input.nextFloat();

              try {
                CustomerService.transaction(customer, receiver, value);

                clearConsole();
                System.out.println("\ntransação finalizada!\n");

              } catch (Exception e) {
                clearConsole();
                System.out.println("\nError na transação!!");
                System.out.println(e.getMessage() + "\n");
              }

              flow = 0;
            }

          } else if (flow < 0 || flow > 3) {
            flow = 0;
          }
        }

      } else {
        System.out.println("\nUsuario não encontrado\n");
      }

    }

    return flow == 2 || flow == 0 ? 0 : 4;
  }
}
