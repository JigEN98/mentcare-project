package mentapp.demopr;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

        List<Person> findByLastName(String lastName);

        Person findById(long id);
    }
