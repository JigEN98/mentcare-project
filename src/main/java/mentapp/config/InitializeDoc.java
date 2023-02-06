package mentapp.config;

import mentapp.models.Doctor;
import mentapp.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitializeDoc {
    @Autowired
    DoctorRepository doctorRepository;

    public boolean initDoc() {
        System.out.println("initialize doctor");
        doctorRepository.save(new Doctor(2, "Rosario", "Pelli", "Oculistica"));
        doctorRepository.save(new Doctor(3, "Alice", "Leblanc", "Dermatologia"));
        doctorRepository.save(new Doctor(4, "Giorgio", "Frizzi", "Cardiologia"));
        doctorRepository.save(new Doctor(5, "Livia", "Picci", "Oculistica"));
        return true;
    }
}
