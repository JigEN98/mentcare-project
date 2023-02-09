package mentapp;

import mentapp.PO.LoginPageObject;
import mentapp.PO.doctor.WelcomePageDoctorPageObject;
import mentapp.PO.patient.NotFoundPageObject;
import mentapp.PO.patient.WelcomePagePatientPageObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DoctorTest extends BaseTest {
    @Test
    public void Scenario1() {
        driver.get("http://localhost:8080/");
        // -------------------- Login paziente --------------------
        LoginPageObject login_page = new LoginPageObject(driver);
        assertEquals("Verifico che sia la pagina corretta","MentCare Login", login_page.Title());
        WelcomePageDoctorPageObject welc_page = login_page.welcomedoc("lucaciano", "luca");
        assertEquals("Verifico che sia la pagina corretta","Hello Dot. Ciano", welc_page.Title());

        // -------------------- Logout --------------------
        login_page = welc_page.logout();
        assertEquals("Verifico che sia la pagina corretta","MentCare Login", login_page.Title());

        // -------------------- Errori possibili --------------------
        NotFoundPageObject NotFound_page = login_page.UserNotFound("mariorossi", "rossi");
        login_page = NotFound_page.ShowLogin();
        assertEquals("Verifico che sia la pagina corretta","MentCare Login", login_page.Title());
    }
}
