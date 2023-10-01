package modules.valueObjects;

public class Email {
  private String path;
  private String domain;

  public Email(String path, String domain) throws Exception {
    if (path == null || path.trim().length() <= 0) {
      System.out.println("oii");
      throw new Exception(String.format("VO.Email.path '%s' is invalid or not provided", path));
    }

    if (domain == null || domain.trim().length() <= 0) {
      throw new Exception(String.format("VO.Email.domain '%s' is invalid or not provided", domain));
    }

    this.path = path;
    this.domain = domain;
  }

  public String getPath() {
    return path;
  }

  public String getDomain() {
    return domain;
  }

  public String getEmail() {
    return String.format("%s@%s", this.path, this.domain);
  }
}
