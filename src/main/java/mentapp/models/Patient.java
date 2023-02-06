package mentapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String name;
  private String surname;
  private Integer age;
  private String username;
  public Patient() {}
  public Patient(String name, String surname, Integer age, String username) {
    this.name = name;
    this.surname = surname;
    this.age = age;
    this.username = username;
  }
  
  public void setName(String name) {
    this.name = name;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Long getID() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String getSurname() {
    return this.surname;
  }

  public String getUserName() {
    return this.username;
  }

  public Integer getAge() {
    return this.age;
  }

  @Override
  public String toString() {
    return String.format("Customer[name='%s', surname='%s', age='%d']", this.name, this.surname, this.age);
  }
}
