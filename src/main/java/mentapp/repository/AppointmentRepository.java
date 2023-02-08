package mentapp.repository;

import mentapp.models.Appointment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    List<Appointment> findAll();
    Appointment findById(long id);
    List<Appointment> findByIdDoctor(long idDoctor);
    List<Appointment> findByIdPatient(long idPatient);

    void deleteByIdPatient(Long idPatient);
}