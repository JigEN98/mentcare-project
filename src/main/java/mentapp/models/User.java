package mentapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private String username;
    private String password;
    private String role;
    private Long id;
    public User() {}
    public User(String username, String password, String role, Long id) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.id = id;
    }
    public String getUsername() {
        return this.username;
    }
    public String getRole() {
        return this.role;
    }
    public String getPassword() { return this.password;}
    public Long getID() {
        return this.id;
    }
}
