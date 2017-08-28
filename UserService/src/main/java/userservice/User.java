package userservice;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "Users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Integer id;

  private String firstName;

  private String lastName;

  private String email;

  private Integer zipCode;

  private String hashedPassword;

  private String sex;

  private String targetSex;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getZipCode() {
    return zipCode;
  }

  public void setZipCode(Integer zipCode) {
    this.zipCode = zipCode;
  }

  public String getHashedPassword() {
    return hashedPassword;
  }

  public void setHashedPassword(String hashedPassword) {
    this.hashedPassword = hashedPassword;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getTargetSex() {
    return targetSex;
  }

  public void setTargetSex(String targetSex) {
    this.targetSex = targetSex;
  }
}
