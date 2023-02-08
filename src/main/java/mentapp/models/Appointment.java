package mentapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

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

    @Override
    public String toString() {
        return String.format("Appointment[id='%d', date='%s', doc='%d', pat='%d']", this.id, this.date.toString(), this.idDoctor, this.idPatient);
    }

}

