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
        flow = 1;
        break;

      case 2:
        flow = 2;
        break;

      case 3:
        flow = 3;
        break;

      case 4:
        flow = 4;
        break;

      case 5:
        flow = 5;
        break;

      default:
        flow = 0;
        break;
    }

    clearConsole();

    return flow;
  }
}
