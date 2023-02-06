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
        
        patientRepository.save(new Patient(1, "Mario", "Rossi", 20, 1));
        patientRepository.save(new Patient(2, "Gianluca", "Verdi", 20, 2));
        patientRepository.save(new Patient(3, "Fabrizio", "Viola", 20, 2));

        doctorRepository.save(new Doctor(1, "Luca", "Ciano", "Pediatria"));

        userRepository.save(new User("mariorossi", "mario", "patient", 1));
        userRepository.save(new User("lucaciano", "luca", "doctor", 1));
        userRepository.save(new User("admin", "admin", "admin", 1));

        appointmentRepository.save(new Appointment(1, new Date(2020,10,02), "9:00-10:00", "TEST", 1, 1));
        
        return true;
    }

}