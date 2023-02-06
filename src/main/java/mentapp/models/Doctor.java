package mentapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Doctor {
    @Id
    private Integer code;
    private String name;
    private String surname;
    private String specialization;
    public Doctor() {}
    public Doctor(Integer id, String name, String surname, String specialization) {
        this.code = id;
        this.name = name;
        this.surname = surname;
        this.specialization = specialization;
    }
    public Integer getID() {
        return this.code;
    }
}
