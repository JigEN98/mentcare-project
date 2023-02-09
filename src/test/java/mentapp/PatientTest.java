package mentapp;

import mentapp.PO.*;
import mentapp.PO.patient.NotFoundPageObject;
import mentapp.PO.patient.ProfilePatientPageObject;
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
        assertEquals("Verifico che sia la pagina corretta","Hello Mr Rossi", welc_page.Title());

        // -------------------- Logout --------------------
        login_page = welc_page.logout();
        assertEquals("Verifico che sia la pagina corretta","MentCare Login", login_page.Title());

        // -------------------- Errori possibili --------------------
        NotFoundPageObject NotFound_page = login_page.UserNotFound("mariorossi", "rossi");
        login_page = NotFound_page.ShowLogin();
        assertEquals("Verifico che sia la pagina corretta","MentCare Login", login_page.Title());
    }
    @Test
    // Scenario 2: profilo paziente
    public void Scenario2_Patient() {
        driver.get("http://localhost:8080/");
        // -------------------- Premesse --------------------
        LoginPageObject login_page = new LoginPageObject(driver);
        WelcomePagePatientPageObject welc_page = login_page.welcomepat("mariorossi", "mario");
        assertEquals("Verifico che sia la pagina corretta","Hello Mr Rossi", welc_page.Title());

        // -------------------- profilo paziente --------------------
        ProfilePatientPageObject profile_page = new ProfilePatientPageObject(driver);
        profile_page.showProfile();
        assertEquals("Verifico che sia la pagina corretta","Profile", profile_page.Title());
    }
}