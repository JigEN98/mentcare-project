package mentapp.config;

import mentapp.models.Appointment;
import mentapp.models.Doctor;
import mentapp.models.User;
import mentapp.repository.AppointmentRepository;
import mentapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import mentapp.repository.PatientRepository;
import mentapp.repository.DoctorRepository;
import mentapp.models.Patient;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class InitializeDB {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    AppointmentRepository appointmentRepository;

    public boolean initDB() {
        System.out.println("Initialize database");

        Doctor d1 = new Doctor("Luca", "Ciano", "Pediatria");
        doctorRepository.save(d1);
        Doctor d2 = new Doctor("Rosario", "Pelli", "Oculistica");
        doctorRepository.save(d2);
        Doctor d3 = new Doctor("Alice", "Leblanc", "Dermatologia");
        doctorRepository.save(d3);
        Doctor d4 = new Doctor("Giorgio", "Frizzi", "Cardiologia");
        doctorRepository.save(d4);
        Doctor d5 = new Doctor("Livia", "Picci", "Oculistica");
        doctorRepository.save(d5);

        Patient p1 = new Patient("Mario", "Rossi", LocalDate.of(1987, 3, 1), d1.getID());
        patientRepository.save(p1);
        Patient p2 = new Patient("Gianluca", "Verdi", LocalDate.of(1990, 1, 20), d2.getID());
        patientRepository.save(p2);
        Patient p3 = new Patient("Fabrizio", "Viola", LocalDate.of(2000, 8, 15), d3.getID());
        patientRepository.save(p3);
        Patient p4 = new Patient("Marco", "Celeste", LocalDate.of(1995, 1, 1), d1.getID());
        patientRepository.save(p4);
        Patient p5 = new Patient("Ettore", "Marroni", LocalDate.of(1997, 8, 30), d1.getID());
        patientRepository.save(p5);

        userRepository.save(new User("mariorossi", "mario", "patient", p1.getID()));
        userRepository.save(new User("glucaverdi", "gluca", "patient", p2.getID()));
        userRepository.save(new User("fabrizioviola", "fabrizio", "patient", p3.getID()));
        //userRepository.save(new User("marcoceleste", "marco", "patient", p4.getID()));
        //userRepository.save(new User("ettoremarroni", "ettore", "patient", p5.getID()));

        userRepository.save(new User("lucaciano", "luca", "doctor", d1.getID()));
        userRepository.save(new User("rosariopelli", "rosario", "doctor", d2.getID()));
        userRepository.save(new User("aliceleblanc", "alice", "doctor", d3.getID()));
        userRepository.save(new User("giorgiofrizzi", "giorgio", "doctor", d4.getID()));
        userRepository.save(new User("liviapicci", "livia", "doctor", d5.getID()));


        userRepository.save(new User("admin", "admin", "admin", p1.getID()+93));

        appointmentRepository.save(new Appointment(LocalDateTime.of(2024,10,2,9,00), "Visita glicemia", p1.getID(), d1.getID()));
        appointmentRepository.save(new Appointment(LocalDateTime.of(2024,9,2,10,00), "Controllo dieta", p2.getID(), d1.getID()));
        appointmentRepository.save(new Appointment(LocalDateTime.of(2023,9,22,11,00), "Visita di controllo", p1.getID(), d1.getID()));
        appointmentRepository.save(new Appointment(LocalDateTime.of(2023,11,2,12,00), "Controllo esami sangue", p4.getID(), d1.getID()));
        appointmentRepository.save(new Appointment(LocalDateTime.of(2023,5,12,13,00), "Visita dermatologica", p5.getID(), d1.getID()));




        System.out.println("All initialized!");
        return true;
    }

}