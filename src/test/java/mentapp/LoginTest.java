package mentapp;

import mentapp.PO.LoginPageObject;
import mentapp.PO.patient.NotFoundPageObject;
import mentapp.PO.patient.WelcomePagePatientPageObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest  {
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

        NotFoundPageObject NotFound_page2 = login_page.UserNotFound("guest", "guest");
        login_page = NotFound_page2.ShowLogin();
        assertEquals("Verifico che sia la pagina corretta","MentCare Login", login_page.Title());
    }
}
