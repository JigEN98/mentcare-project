package mentapp;

import mentapp.PO.*;
import mentapp.PO.patient.NotFoundPageObject;
import mentapp.PO.patient.WelcomePagePatientPageObject;
import org.junit.Test;
import static org.junit.Assert.*;

public class PatientTest extends BaseTest {
    @Test
    // Scenario 1: login del paziente
    public void Scenario1_Patient() {
        driver.get("http://localhost:8080/");
        // -------------------- Login paziente --------------------
        LoginPageObject login_page = new LoginPageObject(driver);
        assertEquals("Verifico che sia la pagina corretta","MentCare Login", login_page.Title());
        WelcomePagePatientPageObject welc_page = login_page.welcomepat("mariorossi", "mario");
        assertEquals("Verifico che sia la pagina corretta","MENTCARE patient", welc_page.Title());
        //assertEquals("Verifico di aver fatto l'accesso con il paziente corretto","Hello Mr: Rossi", welc_page.Message());

        // -------------------- Errori possibili --------------------
        NotFoundPageObject NotFound_page = login_page.UserNotFound("mariorossi", "rossi");
        login_page = NotFound_page.ShowLogin();
        assertEquals("Verifico che sia la pagina corretta","Mentcare", login_page.Title());
    }
}