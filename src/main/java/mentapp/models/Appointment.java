package mentapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String time;
    private String description;
    private Date date;
    private Long id_pat;
    private Long id_doc;
    public Appointment() {}
    public Appointment(Date date, String time, String description, Long id_doc, Long id_pat) {
        this.time = time;
        this.description = description;
        this.date = date;
        this.id_pat = id_pat;
        this.id_doc = id_doc;
    }
    public Long getID() {
        return this.id;
    }
    public Date getDate() {
        return date;
    }

    public Long getId_doc() {
        return id_doc;
    }

    public Long getId_pat() {
        return id_pat;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

}

