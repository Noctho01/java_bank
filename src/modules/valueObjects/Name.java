package modules.valueObjects;

public class Name {
  private String firstName;
  private String lastName;

  public Name(String firstName, String lastName) {
    if (firstName == null || firstName.trim().length() <= 0) {
      new Exception(String.format("VO.Name.firstName '%s' is invalid or not provided", firstName));
    }

    if (lastName == null || lastName.trim().length() <= 0) {
      new Exception(String.format("VO.Name.lastName '%s' is invalid or not provided", lastName));
    }

    this.firstName = firstName.trim();
    this.lastName = lastName.trim();
  }


  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String fullName() {
    return String.format("%s %s", this.firstName, this.lastName);
  }
}
