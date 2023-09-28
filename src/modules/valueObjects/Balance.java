package modules.valueObjects;

public class Balance {
  private float value;
  private String coin;

  public Balance(float value, String coin) {
    if (value < 0) {
      new Exception(String.format("VO.Balance.value '$.2f' is invalid or not provided", value));
    }

    switch (coin) {
      case "BRL":
      case "USD":
      case "EUR":
       break;
      default:
        new Exception(String.format("VO.Balance.value '$.2f' is invalid or not provided", value));
    }

    this.value = value;
    this.coin = coin;
  }

  public float getValue() {
    return value;
  }

  public String getCoin() {
    return coin;
  }

  public String format() {
    return String.format("%s - %.2f", this.coin, this.value);
  }

}
