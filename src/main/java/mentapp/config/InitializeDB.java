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

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.sql.Date;

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

        Patient p1 = new Patient("Mario", "Rossi", new Date(87, Calendar.MARCH, 02), d1.getID());
        patientRepository.save(p1);
        Patient p2 = new Patient("Gianluca", "Verdi", new Date(90, Calendar.JANUARY, 20), d2.getID());
        patientRepository.save(p2);
        Patient p3 = new Patient("Fabrizio", "Viola", new Date(100, Calendar.AUGUST, 15), d3.getID());
        patientRepository.save(p3);
        Patient p4 = new Patient("Marco", "Celeste", new Date(95, Calendar.JANUARY, 01), d1.getID());
        patientRepository.save(p4);
        Patient p5 = new Patient("Ettore", "Marroni", new Date(97, Calendar.AUGUST, 30), d1.getID());
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


        userRepository.save(new User("admin", "admin", "admin", p1.getID()-1));

        appointmentRepository.save(new Appointment(new Date(2020-1900,10-1,02), "9:00", "Visita glicemia", p1.getID(), d1.getID()));
        appointmentRepository.save(new Appointment(new Date(2020-1900,9-1,02), "10:00", "Controllo dieta", p2.getID(), d1.getID()));
        appointmentRepository.save(new Appointment(new Date(2020-1900,9-1,22), "12:00", "Visita di controllo", p1.getID(), d1.getID()));
        appointmentRepository.save(new Appointment(new Date(2020-1900,11-1,02), "15:00", "Controllo esami sangue", p4.getID(), d1.getID()));
        appointmentRepository.save(new Appointment(new Date(2020-1900,5-1,12), "11:00", "Visita dermatologica", p5.getID(), d1.getID()));




        System.out.println("All initialized!");
        return true;
    }

}