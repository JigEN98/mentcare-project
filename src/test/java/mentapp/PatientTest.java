package mentapp;

import mentapp.PO.*;
import mentapp.PO.patient.NotFoundPageObject;
import mentapp.PO.patient.PatientAppListPageObject;
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

        NotFoundPageObject NotFound_page2 = login_page.UserNotFound("guest", "guest");
        login_page = NotFound_page2.ShowLogin();
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
        ProfilePatientPageObject profile_page = welc_page.showProfile();
        assertEquals("Verifico che sia la pagina corretta","Profile", profile_page.Title());
        assertEquals("Verifico che il nome del pz sia corretto","Nome: Mario", profile_page.CheckName());
        assertEquals("Verifico che il cognome del pz sia corretto","Cognome: Rossi", profile_page.CheckSurname());
        assertEquals("Verifico che la data di nascita del pz sia corretta","Data di nascita: 1987-03-01", profile_page.CheckDate());

        // -------------------- Logout --------------------
        login_page = profile_page.logout();
        assertEquals("Verifico che sia la pagina corretta","MentCare Login", login_page.Title());

        // -------------------- Errori possibili --------------------
        NotFoundPageObject NotFound_page = login_page.UserNotFound("mariorossi", "rossi");
        login_page = NotFound_page.ShowLogin();
        assertEquals("Verifico che sia la pagina corretta","MentCare Login", login_page.Title());
    }

    @Test
    // Scenario 3: lista appuntamenti paziente
    public void Scenario3_Patient() {
        driver.get("http://localhost:8080/");
        // -------------------- Premesse --------------------
        LoginPageObject login_page = new LoginPageObject(driver);
        WelcomePagePatientPageObject welc_page = login_page.welcomepat("mariorossi", "mario");
        assertEquals("Verifico che sia la pagina corretta","Hello Mr Rossi", welc_page.Title());

        // -------------------- lista appuntamenti paziente --------------------
        PatientAppListPageObject app_page = welc_page.showAppList();
        assertEquals("Verifico che sia la pagina corretta","Detail of appointments:", app_page.Title());
        assertEquals("Verifico che la data dell'appuntamento sia corretta","2024-10-02 09:00", app_page.CheckDateApp());
        assertEquals("Verifico che il nome del dottore sia corretto","Ciano", app_page.CheckDoctorApp());
        assertEquals("Verifico che la descrizione dell'appuntamento sia corretta","Visita glicemia", app_page.CheckDescApp());

        // -------------------- Logout --------------------
        login_page = app_page.logout();
        assertEquals("Verifico che sia la pagina corretta","MentCare Login", login_page.Title());

        // -------------------- Errori possibili --------------------
        NotFoundPageObject NotFound_page = login_page.UserNotFound("mariorossi", "rossi");
        login_page = NotFound_page.ShowLogin();
        assertEquals("Verifico che sia la pagina corretta","MentCare Login", login_page.Title());
    }
}