package mentapp.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import mentapp.models.Patient;

public interface PatientRepository extends CrudRepository<Patient, Long> {
  List<Patient> findAll();
  
  Patient findById(long id);
  List<Patient> findByDoc(long doc);
}
