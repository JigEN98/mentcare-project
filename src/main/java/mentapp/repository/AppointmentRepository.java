package mentapp.repository;

import mentapp.models.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    List<Appointment> findAll();
    Appointment findById(long id);
    List<Appointment> findByIdDoctor(long idDoctor);
    List<Appointment> findByIdPatient(long idPatient);

    void deleteByIdPatient(Long idPatient);
    List<Appointment> findAll(Sort date);
}