package mentapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {

  @Id
  private Integer code;
  private String name;
  private String surname;
  private Integer age;
  private Integer doc;
  public Patient() {}
  public Patient(Integer id, String name, String surname, Integer age, Integer doc) {
    this.code = id;
    this.name = name;
    this.surname = surname;
    this.age = age;
    this.doc = doc;
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

  public Integer getID() {
    return this.code;
  }

  public String getName() {
    return this.name;
  }

  public String getSurname() {
    return this.surname;
  }

  public Integer getAge() {
    return this.age;
  }
  public Integer getDoc() {
    return this.doc;
  }

  @Override
  public String toString() {
    return String.format("Customer[name='%s', surname='%s', age='%d']", this.name, this.surname, this.age);
  }
}
