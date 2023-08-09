package myapp.vo;

public class LoginInformation {
  private String email;
  private Member member;


  public LoginInformation(String email, Member member) {
    this.email = email;
    this.member = member;
  }

  public Member getMember() {
    return member;
  }
  public void setMember(Member member) {
    this.member = member;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
}
