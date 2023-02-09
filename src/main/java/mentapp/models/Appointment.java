package mentapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String description;
    private LocalDateTime date;
    private Long idPatient;
    private Long idDoctor;
    public Appointment() {}
    public Appointment(LocalDateTime date, String description, Long idPatient, Long idDoctor) {
        this.description = description;
        this.date = date;
        this.idPatient = idPatient;
        this.idDoctor = idDoctor;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setIdDoctor(Long idDoctor) {
        this.idDoctor = idDoctor;
    }
    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }
    public Long getID() {
        return this.id;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public Long getIdDoctor() {
        return this.idDoctor;
    }
    public Long getIdPatient() {
        return this.idPatient;
    }
    public String getDescription() {
        return description;
    }

}

