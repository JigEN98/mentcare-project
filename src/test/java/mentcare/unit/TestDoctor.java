package mentcare.unit;

import mentapp.models.Doctor;
import mentcare.BaseTest;
import org.junit.Test;
import java.text.ParseException;
import static org.junit.jupiter.api.Assertions.*;

public class TestDoctor extends BaseTest {


    @Test
    public void testGetterSetter() throws ParseException {
        Doctor doc = new Doctor("Mirco", "Magalli", "DERMATOLOGY");

        doc.setName("Marco");
        assertEquals("Marco", doc.getName(), "Doctor name was not updated");
        doc.setSurname("Marotta");
        assertEquals("Marotta", doc.getSurname(), "Doctor surname was not updated");
        doc.setSpecialization("CORONA");
        assertEquals("CORONA", doc.getSpecialization(), "Doctor specialization was not updated");
        doc.setId(20L);
        assertEquals(20L, doc.getID(), "Doctor ID was not updated");
    }

    @Test
    public void testConstructor(){
        Doctor doc= new Doctor(null, null, null);
        assertNull(doc.getName(),"Doctor username is not null");
        assertNull(doc.getSurname(),"Doctor surname is not null");
        assertNull(doc.getSpecialization(),"Doctor spec is not null");
        assertNull(doc.getID(),"Doctor ID is not null");

        Doctor doc2 = new Doctor();
        assertNull(doc2.getName(),"Doctor name is not null");
        assertNull(doc2.getSurname(),"Doctor surname is not null");
        assertNull(doc2.getSpecialization(),"Doctor spec is not null");
        assertNull(doc2.getID(),"Doctor ID is not null");
    }
}