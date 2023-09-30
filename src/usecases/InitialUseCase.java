package usecases;

import messages.Messages;
import static utils.Util.*;

import java.util.Scanner;

public class InitialUseCase {
  public int execute(Scanner input) {
    Messages.firstMenu();

    int flow = 0;
    int option = input.nextInt();

    switch (option) {
      case 1:
        clearConsole();
        flow = 1;
        break;

      case 2:
        clearConsole();
        flow = 2;
        break;

      case 3:
        clearConsole();
        flow = 3;
        break;

      case 4:
        clearConsole();
        flow = 4;
        break;

      case 5:
        flow = 5;
        clearConsole();
        break;

      default:
        flow = 0;
        break;
    }

    return flow;
  }
}
