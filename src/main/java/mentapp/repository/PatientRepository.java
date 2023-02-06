package mentapp.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import mentapp.models.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer> {
  List<Patient> findAll();
  Patient findByCode(int id);
  List<Patient> findByDoc(int doc);
}
