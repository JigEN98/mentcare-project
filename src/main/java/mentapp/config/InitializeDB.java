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
        
        patientRepository.save(new Patient("Mario", "Rossi", 20, "mariorossi"));
        patientRepository.save(new Patient("Gianluca", "Verdi", 20, "gianlucaverdi"));
        patientRepository.save(new Patient("Fabrizio", "Viola", 20, "fabrizioviola"));

        doctorRepository.save(new Doctor("Luca", "Ciano", 30, "lucaciano"));

        userRepository.save(new User("mariorossi", "mario", "patient"));
        userRepository.save(new User("lucaciano", "luca", "doctor"));
        userRepository.save(new User("admin", "admin", "admin"));
        
        return true;
    }

}