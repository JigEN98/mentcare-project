package mentapp.config;

import mentapp.models.User;
import mentapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mentapp.repository.PatientRepository;
import mentapp.models.Patient;

@Component
public class InitializeDB {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PatientRepository patientRepository;

    public boolean initDB() {
        System.out.println("Initialize database");
        
        patientRepository.save(new Patient("Mario", "Rossi", 20, "mariorossi"));
        patientRepository.save(new Patient("Gianluca", "Verdi", 20, "gianlucaverdi"));
        patientRepository.save(new Patient("Fabrizio", "Viola", 20, "fabrizioviola"));

        userRepository.save(new User("mariorossi", "password1", "patient"));
        
        return true;
    }

}