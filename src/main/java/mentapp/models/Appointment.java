package mentapp.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Appointment {
    @Id
    private Integer code;
    private String time;
    private String description;
    private Date date;
    private Integer id_pat;
    private Integer id_doc;
    public Appointment() {}
    public Appointment(Integer code, Date date, String time, String description, Integer id_doc, Integer id_pat) {
        this.code = code;
        this.time = time;
        this.description = description;
        this.date = date;
        this.id_pat = id_pat;
        this.id_doc = id_doc;
    }
    public Integer getID() {
        return this.code;
    }
    public Date getDate() {
        return date;
    }

    public Integer getId_doc() {
        return id_doc;
    }

    public Integer getId_pat() {
        return id_pat;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public Integer getCode() {
        return code;
    }
}

