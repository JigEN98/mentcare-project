package mentapp.repository;

import mentapp.models.Appointment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
    List<Appointment> findAll();
    Appointment findByCode(int id);
}