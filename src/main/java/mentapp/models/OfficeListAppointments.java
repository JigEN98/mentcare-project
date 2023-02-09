package mentapp.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class OfficeListAppointments {
    @Id
    private Long id;
    private LocalDate date;
    private String time;
    private String description;
    private String namePatient;
    private String surnamePatient;
    private String nameDoctor;
    private String surnameDoctor;
    public OfficeListAppointments() {}
    public OfficeListAppointments(LocalDate date, String time, String description, String namePatient, String surnamePatient, String nameDoctor, String surnameDoctor) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.namePatient = namePatient;
        this.surnamePatient = surnamePatient;
        this.nameDoctor = nameDoctor;
        this.surnameDoctor = surnameDoctor;
    }
}
