import java.util.ArrayList;
import java.util.Scanner;

import messages.Messages;
import modules.dtos.CustomerToCreationDto;
import modules.entities.Customer;
import services.CustomerService;
import usecases.*;
import static utils.Util.*;

/**
 * Flows
 * 
 * 0 > menu inicial
 * 1 > cadastrar cliente
 * 2 > listar clientes
 * 3 > acessar cliente
 * 
 */

public class App {

  public static void main(String[] args) throws Exception {
    final Scanner input = new Scanner(System.in);
    final ArrayList<Customer> customers = new ArrayList<Customer>();

    for (CustomerToCreationDto preCustomer : getPreCustomers()) {
      customers.add(CustomerService.create(preCustomer));
    }

    InitialUseCase initial = new InitialUseCase();
    CreateCustomerUseCase createCustomer = new CreateCustomerUseCase(customers);
    GetCustomersUseCase getCustomers = new GetCustomersUseCase(customers);
    AccessCustomerUseCase accessCustomer = new AccessCustomerUseCase(customers);

    int flow = 0;

    clearConsole();

    while (flow != 4) {

      switch (flow) {
        case 0:
          Messages.wellCome();
          flow = initial.execute(input);
          clearConsole();
          break;

        case 1:
          flow = createCustomer.execute(input);
          break;

        case 2:
          flow = getCustomers.execute(input);
          break;

        case 3:
          flow = accessCustomer.execute(input);
          break;

        default:
          flow = 0;
          clearConsole();
          System.out.println("fluxo invalido...\n");
          break;
      }
    }
  }
}
