package unit;

import mentapp.models.Appointment;
import mentapp.models.Doctor;
import mentapp.models.Patient;
import mentcare.BaseTest;
import org.junit.Test;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class TestAppointment extends BaseTest {


    @Test
    public void testGetterSetter() throws ParseException {
        Doctor doc = new Doctor("Mirco", "Magalli", "DERMATOLOGY");
        Patient pat = new Patient("Rico", "Moretti", LocalDate.of(1970, 12, 12), doc.getID());
        Appointment app = new Appointment(LocalDateTime.of(2024,10,2,9,00), "Visita glicemia", pat.getID(), doc.getID());

        app.setId(55L);
        assertEquals(55L, app.getID(), "Appointment ID was not updated");
        app.setDate(LocalDateTime.of(2023, 11, 11, 10,00));
        assertEquals(LocalDateTime.of(2023, 11, 11, 10,00), app.getDate(), "Appointment date was not updated");
        app.setDescription("Visita oculistica");
        assertEquals("Visita oculistica", app.getDescription(), "Appointment desc was not updated");
        app.setIdDoctor(54L);
        assertEquals(54L, app.getIdDoctor(), "Appointment ID_doc was not updated");
        app.setIdPatient(53L);
        assertEquals(53L, app.getIdPatient(), "Appointment ID_pat was not updated");
    }

    @Test
    public void testConstructor(){
        Appointment app = new Appointment(null, null, null, null);
        assertNull(app.getID(),"Appointment ID is not null");
        assertNull(app.getIdDoctor(),"Appointment ID_doc is not null");
        assertNull(app.getIdPatient(),"Appointment ID_pat is not null");
        assertNull(app.getDate(),"Appointment date is not null");
        assertNull(app.getDescription(),"Appointment desc is not null");

        Appointment app2 = new Appointment();
        assertNull(app2.getID(),"Appointment ID is not null");
        assertNull(app2.getIdDoctor(),"Appointment ID_doc is not null");
        assertNull(app2.getIdPatient(),"Appointment ID_pat is not null");
        assertNull(app2.getDate(),"Appointment date is not null");
        assertNull(app2.getDescription(),"Appointment desc is not null");
    }
}