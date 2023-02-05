package mentapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import mentapp.models.User;

public interface UserRepository extends CrudRepository<User, String> {
    List<User> findAll();
    User findByUsername(String username);
}
