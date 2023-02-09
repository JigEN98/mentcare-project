package mentapp;

import mentapp.PO.LoginPageObject;
import mentapp.PO.NotFoundPageObject;
import mentapp.PO.admin.WelcomePageOfficePageObject;
import mentapp.PO.doctor.WelcomePageDoctorPageObject;
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

        NotFoundPageObject NotFound_page3 = login_page.UserNotFound("isaialucco", "isaia");
        login_page = NotFound_page3.ShowLogin();
        assertEquals("Verifico che sia la pagina corretta","MentCare Login", login_page.Title());
    }

    @Test
    // Scenario 1: login dell'admin
    public void Scenario1_Admin() {
        driver.get("http://localhost:8080/");
        // -------------------- Login admin--------------------
        LoginPageObject login_page = new LoginPageObject(driver);
        assertEquals("Verifico che sia la pagina corretta","MentCare Login", login_page.Title());
        WelcomePageOfficePageObject welc_page = login_page.welcomeadmin("admin", "admin");
        assertEquals("Verifico che sia la pagina corretta","ADMIN PANEL", welc_page.Title());

        // -------------------- Logout --------------------
        login_page = welc_page.logout();
        assertEquals("Verifico che sia la pagina corretta","MentCare Login", login_page.Title());

        // -------------------- Errori possibili --------------------
        NotFoundPageObject NotFound_page = login_page.UserNotFound("admin", "office");
        login_page = NotFound_page.ShowLogin();
        assertEquals("Verifico che sia la pagina corretta","MentCare Login", login_page.Title());

        NotFoundPageObject NotFound_page2 = login_page.UserNotFound("guest", "guest");
        login_page = NotFound_page2.ShowLogin();
        assertEquals("Verifico che sia la pagina corretta","MentCare Login", login_page.Title());
    }

    @Test
    // scenario 1: login del dottore
    public void loginDoctor() {
        driver.get("http://localhost:8080/");
        // -------------------- Login dottore --------------------
        LoginPageObject login_page = new LoginPageObject(driver);
        assertEquals("Verifico di essere nella Home","MentCare Login", login_page.Title());
        WelcomePageDoctorPageObject welc_page = login_page.welcomedoc("lucaciano", "luca");
        assertEquals("Verifico di aver fatto il login con il dottore ed essere nella sua Dashboard","Hello Dr. Ciano", welc_page.Title());

        // -------------------- Logout --------------------
        login_page = welc_page.logout();
        assertEquals("Verifico di essere di nuovo nella Home","MentCare Login", login_page.Title());

        // -------------------- Errori possibili --------------------
        NotFoundPageObject NotFound_page = login_page.UserNotFound("mariorossi", "rossi");
        login_page = NotFound_page.ShowLogin();
        assertEquals("Verifico di essere ancora nella pagina login dopo l'autenticazione errata","MentCare Login", login_page.Title());

        NotFoundPageObject NotFound_page2 = login_page.UserNotFound("guest", "guest");
        login_page = NotFound_page2.ShowLogin();
        assertEquals("Verifico che sia la pagina corretta","MentCare Login", login_page.Title());

        NotFoundPageObject NotFound_page3 = login_page.UserNotFound("isaialucco", "isaia");
        login_page = NotFound_page3.ShowLogin();
        assertEquals("Verifico che sia la pagina corretta","MentCare Login", login_page.Title());
    }
}
