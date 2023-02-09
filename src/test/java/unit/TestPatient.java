package unit;

import mentapp.models.Doctor;
import mentcare.BaseTest;
import org.junit.jupiter.api.Test;
import java.text.ParseException;
import java.time.LocalDate;
import mentapp.models.Patient;
import static org.junit.jupiter.api.Assertions.*;

public class TestPatient extends BaseTest {


    @Test
    public void testGetterSetter() throws ParseException {
        Doctor doc = new Doctor("Mirco", "Magalli", "DERMATOLOGY");
        Patient pat = new Patient("Rico", "Moretti", LocalDate.of(1970, 12, 12), doc.getID());

        pat.setName("Marcello");
        assertEquals("Marcello", pat.getName(), "Patient name was not updated");
        pat.setSurname("Morati");
        assertEquals("Morati", pat.getSurname(), "Patient surname was not updated");
        pat.setBirthDate(LocalDate.of(1970, 11, 11));
        assertEquals("1970-11-11", pat.getBirthDate(), "Patient birth date was not updated");


    }

    @Test
    public void testConstructor(){
        Patient pat = new Patient(null, null, null, null);
        assertNull(pat.getName(),"Patient Name is not null");
        assertNull(pat.getSurname(),"Patient Surname is not null");
        assertNull(pat.getBirthDate(),"Patient birth date is not null");
        assertNull(pat.getDoc(),"Patient doctor id is not null");
    }
}