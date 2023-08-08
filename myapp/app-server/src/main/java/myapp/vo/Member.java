package myapp.vo;

import java.io.Serializable; // 인터페이스 (직렬화 가능하기위해선 해당 인터페이스 상속)
import java.sql.Timestamp;
import java.util.Objects;

public class Member implements Serializable {


  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public static final char MALE = 'M';
  public static final char FEMALE = 'W';

  private int no;
  private String name;
  private String email;
  private String password;
  private char gender;
  private Timestamp createdDate;

  //  public Member() {
  //    this.no = userId++;
  //  }
  public Member() {}

  public Member(int no) {
    this.no = no;
  }

  @Override
  public int hashCode() {
    return Objects.hash(no);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Member other = (Member) obj;
    return no == other.no;
  }

  // 겟터/셋터는 인스턴스 필드의 값을 설정하고 꺼내는 메서드다.
  // 보통 외부에서 직접 필드에 접근하는 것을 막았을 때, 사용한다.
  public int getNo() {
    return this.no;
  }

  public String getName() {
    return this.name;
  }

  public String getEmail() {
    return this.email;
  }


  public String getPassword() {
    return this.password;
  }

  public char getGender() {
    return this.gender;
  }

  public void setNo(int number) {
    no = number;
  }

  public void setName(String str) {
    name = str;
  }

  public void setEmail(String str) {
    email = str;
  }

  public void setPassword(String str) {
    password = str;
  }

  public void setGender(char gen) {
    gender = gen;
  }

  public Timestamp getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Timestamp createdDate) {
    this.createdDate = createdDate;
  }



}

