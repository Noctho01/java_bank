package modules.dtos;

public class CustomerDto {
  private String _name;
  private String _email;
  private String _balance;

  public CustomerDto(String name, String email, String balance) {
    this._name = name;
    this._email = email;
    this._balance = balance;
  }

  public String name() {
    return _name;
  }

  public String email() {
    return _email;
  }

  public String balance() {
    return _balance;
  }
}
