package mentapp.repository;

import java.util.List;

import mentapp.models.Doctor;
import org.springframework.data.repository.CrudRepository;


public interface DoctorRepository extends CrudRepository<Doctor, Long> {
    List<Doctor> findAll();
    Doctor findById(long id);
}
