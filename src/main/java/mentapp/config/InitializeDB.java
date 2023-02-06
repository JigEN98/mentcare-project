package mentapp.config;

import mentapp.models.Doctor;
import mentapp.models.User;
import mentapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mentapp.repository.PatientRepository;
import mentapp.repository.DoctorRepository;
import mentapp.models.Patient;

@Component
public class InitializeDB {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorRepository doctorRepository;

    public boolean initDB() {
        System.out.println("Initialize database");
        
        patientRepository.save(new Patient(1, "Mario", "Rossi", 20));
        patientRepository.save(new Patient(2, "Gianluca", "Verdi", 20));
        patientRepository.save(new Patient(3, "Fabrizio", "Viola", 20));

        doctorRepository.save(new Doctor(1, "Luca", "Ciano", "Pediatria"));

        userRepository.save(new User("mariorossi", "mario", "patient", 1));
        userRepository.save(new User("lucaciano", "luca", "doctor", 1));
        userRepository.save(new User("admin", "admin", "admin", 1));
        
        return true;
    }

}