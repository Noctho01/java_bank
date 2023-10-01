package utils;

import modules.dtos.CustomerToCreationDto;

public class Util {
  public final static void clearConsole() {
    try {
      if (System.getProperty("os.name").contains("Windows")) {
        ProcessBuilder process = new ProcessBuilder("cmd", "/c", "cls");
        process.inheritIO().start().waitFor();
      } else {
        ProcessBuilder process = new ProcessBuilder("clear");
        process.inheritIO().start().waitFor();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public final static CustomerToCreationDto[] getPreCustomers() {
    CustomerToCreationDto[] dtos = new CustomerToCreationDto[5];

    dtos[0] = new CustomerToCreationDto(
        "Vanessa",
        "Ferreira",
        "vanessa123",
        "gmail.com",
        2800,
        "BRL");
    dtos[1] = new CustomerToCreationDto(
        "Pedro",
        "Carlos",
        "pdutra",
        "outlook.com",
        2550,
        "BRL");
    dtos[2] = new CustomerToCreationDto(
        "Lucas",
        "Game",
        "lucke",
        "outlook.com",
        3250,
        "BRL");
    dtos[3] = new CustomerToCreationDto(
        "Dina",
        "Ferreira",
        "olindina321",
        "gmail.com",
        3000,
        "BRL");
    dtos[4] = new CustomerToCreationDto(
        "Isaac",
        "Melquior",
        "isaaak",
        "gmail.com",
        1050,
        "BRL");

    return dtos;
  }
}
