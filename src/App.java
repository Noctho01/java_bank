import java.util.ArrayList;
import java.util.Scanner;
import messages.Messages;
import modules.entities.Customer;
import usecases.*;
import static utils.Util.*;

/**
 * Flows
 * 
 * 0 > menu inicial
 * 1 > cadastrar cliente
 * 2 > consultar cliente
 * 3 > listar clientes
 * 4 > acessar cliente
 * 
 */

public class App {

  public static void main(String[] args) throws Exception {
    Scanner input = new Scanner(System.in);

    ArrayList<Customer> customers = new ArrayList<Customer>();

    InitialUseCase initial = new InitialUseCase();
    CreateCustomerUseCase createCustomer = new CreateCustomerUseCase(customers);
    GetCustomersUseCase getCustomers = new GetCustomersUseCase(customers);
    GetCustomerUseCase getCustomer = new GetCustomerUseCase(customers);

    int flow = 0;

    clearConsole();
    Messages.wellCome();

    while (flow != 5) {

      switch (flow) {
        case 0:
          flow = initial.execute(input);
          break;

        case 1:
          flow = createCustomer.execute(input);
          break;

        case 2:
          flow = getCustomer.execute(input);
          break;

        case 3:
          flow = getCustomers.execute(input);
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
