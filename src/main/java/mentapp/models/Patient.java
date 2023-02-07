package mentapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Patient {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String name;
  private String surname;
  private Date birthDate;
  private Long doc;
  public Patient() {}
  public Patient(String name, String surname, Date birthDate, Long doc) {
    this.name = name;
    this.surname = surname;
    this.birthDate = birthDate;
    this.doc = doc;
  }
  
  public void setName(String name) {
    this.name = name;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public void setBirthDate(Integer age) {
    this.birthDate = birthDate;
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

  public Date getBirthDate() {
    return this.birthDate;
  }
  public Long getDoc() {
    return this.doc;
  }

  }
