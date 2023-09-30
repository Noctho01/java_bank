package utils;

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
}
