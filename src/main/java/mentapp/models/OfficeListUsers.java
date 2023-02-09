package mentapp.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OfficeListUsers {
    @Id
    private String username;
    private String role;
    private String name;
    private String surname;
    public OfficeListUsers() {}
    public OfficeListUsers(String username, String role, String name, String surname) {
        this.username = username;
        this.role = role;
        this.name = name;
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }
    public String getRole() {
        return this.role;
    }
    public String getName() {
        return this.name;
    }
    public String getSurname() {
        return this.surname;
    }
    @Override
    public String toString() {
        return String.format("OfficeListUser[username='%s', role='%s', name='%s', surname='%s']", this.username, this.role, this.name, this.surname);
    }
}
