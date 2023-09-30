package usecases;

import java.util.Scanner;
import java.util.ArrayList;
import modules.dtos.CustomerToCreationDto;
import modules.entities.Customer;
import services.CustomerService;

public class CreateCustomerUseCase {

  ArrayList<Customer> customers;

  public CreateCustomerUseCase(ArrayList<Customer> customers) {
    this.customers = customers;
  }

  public int execute(Scanner input) {
    int flow = 0;

    System.out.println("Cadastrando cliente:");

    System.out.print("Primeiro nome: ");
    String firstName = input.next();

    System.out.print("Segundo nome: ");
    String lastName = input.next();

    System.out.print("Caminho do email: ");
    String emailPath = input.next();

    System.out.print("Dominio do email: ");
    String emailDomain = input.next();

    System.out.print("Saldo inicial: ");
    float valueAccount = input.nextFloat();

    System.out.print("Tipo de moeda: ");
    String coin = input.next();

    final CustomerToCreationDto customerDto = new CustomerToCreationDto(
        firstName,
        lastName,
        emailPath,
        emailDomain,
        valueAccount,
        coin);

    final Customer customer = CustomerService.create(customerDto);

    this.customers.add(customer);
    flow = 0;

    System.out.print("\nCliente criado com sucesso!\n\n");

    return flow;
  }
}
