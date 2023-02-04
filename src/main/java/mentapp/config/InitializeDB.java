package mentapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mentapp.repository.PatientRepository;
import mentapp.models.Patient;

@Component
public class InitializeDB {
    @Autowired
    PatientRepository patientRepository;

    public boolean initDB() {
        System.out.println("Initialize database");
        
        Patient patient1 = new Patient("Mario", "Rossi", 20);
        patientRepository.save(patient1);
        
        return true;
    }

}