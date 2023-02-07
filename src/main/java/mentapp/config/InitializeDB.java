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

import java.util.Calendar;
import java.util.Date;

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

        userRepository.save(new User("mariorossi", "mario", "patient", p1.getID()));
        userRepository.save(new User("lucaciano", "luca", "doctor", d1.getID()));
        userRepository.save(new User("admin", "admin", "admin", p1.getID()-1));

        appointmentRepository.save(new Appointment(new Date(2020,10,02), "9:00-10:00", "TEST 1", p1.getID(), d1.getID()));
        appointmentRepository.save(new Appointment(new Date(2020,9,02), "10:00-11:00", "TEST 2", p1.getID(), d1.getID()));

        System.out.println("All initialized!");
        return true;
    }

}