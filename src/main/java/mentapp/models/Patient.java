package mentapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Patient {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String name;
  private String surname;
  private LocalDate birthDate;
  private Long doc;
  public Patient() {}
  public Patient(String name, String surname, LocalDate birthDate, Long doc) {
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

  public LocalDate getBirthDate() {
    return this.birthDate;
  }
  public Long getDoc() {
    return this.doc;
  }

  }
