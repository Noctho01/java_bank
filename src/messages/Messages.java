package messages;

import modules.dtos.CustomerDto;

public class Messages {

  public static void wellCome() {
    System.out.println("""
            well come - java_bank 1.0.0 - 2023
        """);
  }

  public static void card(CustomerDto customerDto) {
    System.out.println(String.format("""
        ************************************************************
            Nome:                 %s
            Email:                %s
        ************************************************************
            Saldo em conta:       %s
        ************************************************************
        """,
        customerDto.name(), customerDto.email(), customerDto.balance()));
  }

  public static void firstMenu() {
    String message = """
        * Menu *
        1 - cadastrar cliente
        2 - consultar cliente
        3 - listar clientes
        4 - acessar cliente
        5 - sair
        """;
    System.out.println(message);
  }

  public static void menuInAccount() {
    System.out.println("""
        * Menu *
        1 - receber valor
        """);
  }
}
