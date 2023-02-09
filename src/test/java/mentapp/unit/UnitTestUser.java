package mentapp.unit;

import mentapp.models.Doctor;
import mentapp.models.User;
import mentapp.BaseTest;
import org.junit.Test;
import java.text.ParseException;
import static org.junit.jupiter.api.Assertions.*;

public class UnitTestUser extends BaseTest {


    @Test
    public void testGetterSetter() throws ParseException {
        Doctor doc = new Doctor("Mirco", "Magalli", "DERMATOLOGY");
        User user = new User("mircomagalli", "mirco", "doctor", doc.getID() );

        user.setUsername("mircomagalli");
        assertEquals("mircomagalli", user.getUsername(), "User username was not updated");
        user.setPassword("mirco");
        assertEquals("mirco", user.getPassword(), "User password was not updated");
        user.setRole("doctor");
        assertEquals("doctor", user.getRole(), "User role was not updated");
        user.setId(70L);
        assertEquals(70L, user.getID(), "User docID was not updated");


    }

    @Test
    public void testConstructor(){
        User user= new User(null, null, null, null);
        assertNull(user.getUsername(),"User username is not null");
        assertNull(user.getPassword(),"User password is not null");
        assertNull(user.getRole(),"User role is not null");
        assertNull(user.getID(),"User docID is not null");

        User user2 = new User();
        assertNull(user2.getUsername(),"User username is not null");
        assertNull(user2.getPassword(),"User password is not null");
        assertNull(user2.getRole(),"User role is not null");
        assertNull(user2.getID(),"User docID is not null");
    }
}