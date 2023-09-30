package modules.dtos;

public class CustomerToCreationDto {
  private String _firstName;
  private String _lastName;
  private String _emailtPath;
  private String _emailDomain;
  private float _valueAccount;
  private String _coin;

  public CustomerToCreationDto(
      String firstName,
      String lastName,
      String emailtPath,
      String emailDomain,
      float valueAccount,
      String coin) {
    this._firstName = firstName;
    this._lastName = lastName;
    this._emailtPath = emailtPath;
    this._emailDomain = emailDomain;
    this._valueAccount = valueAccount;
    this._coin = coin;
  }

  public String firstName() {
    return _firstName;
  }

  public String lastName() {
    return _lastName;
  }

  public String emailtPath() {
    return _emailtPath;
  }

  public String emailDomain() {
    return _emailDomain;
  }

  public float valueAccount() {
    return _valueAccount;
  }

  public String coin() {
    return _coin;
  }
}
