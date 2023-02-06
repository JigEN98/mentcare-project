package mentapp.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Doctor {
    @Id
    private Integer code;
    private String name;
    private String surname;
    private String specialization;
    public Doctor() {}
    public Doctor(Integer code, String name, String surname, String specialization) {
        this.code = code;
        this.name = name;
        this.surname = surname;
        this.specialization = specialization;
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
    public String getSpecialization() {
        return this.specialization;
    }
}
