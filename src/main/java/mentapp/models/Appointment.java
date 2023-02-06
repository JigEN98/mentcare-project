package mentapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String time;
    private String description;
    private Date date;
    private Long idPatient;
    private Long idDoctor;
    public Appointment() {}
    public Appointment(Date date, String time, String description, Long idPatient, Long idDoctor) {
        this.time = time;
        this.description = description;
        this.date = date;
        this.idPatient = idPatient;
        this.idDoctor = idDoctor;
    }
    public Long getID() {
        return this.id;
    }
    public Date getDate() {
        return date;
    }

    public Long getIdDoctor() {
        return this.idDoctor;
    }

    public Long getIdPatient() {
        return this.idPatient;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("Appointment[id='%d', date='%s', doc='%d', pat='%d']", this.id, this.date.toString(), this.idDoctor, this.idPatient);
    }

}

