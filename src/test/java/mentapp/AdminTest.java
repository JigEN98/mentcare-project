package mentapp;

import mentapp.PO.LoginPageObject;
import mentapp.PO.admin.StatsDBPageObject;
import mentapp.PO.admin.WelcomePageOfficePageObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdminTest extends BaseTest {

    @Test
    //Scenario 2: statsDB
    public void Scenario2_StatsDB() {
        driver.get("http://localhost:8080/");
        // -------------------- Premesse --------------------
        LoginPageObject login_page = new LoginPageObject(driver);
        WelcomePageOfficePageObject welc_page = login_page.welcomeadmin("admin", "admin");
        assertEquals("Verifico che sia la pagina corretta","ADMIN PANEL", welc_page.Title());

        // -------------------- statistiche db --------------------
        StatsDBPageObject stats_page = welc_page.statsDB();
        assertEquals("Verifico che sia la pagina corretta", "Database Stats", stats_page.Title());
        assertEquals("Verifico che il numero di utenti sia corretto", "Users: 10", stats_page.checkUsers());
        assertEquals("Verifico che il numero di pazienti sia corretto", "Patients: 5", stats_page.checkPatients());
        assertEquals("Verifico che il numero di dottori sia corretto", "Doctors: 5", stats_page.checkDoctors());
        assertEquals("Verifico che il numero di appuntamenti sia corretto", "Appointments: 7", stats_page.checkAppointments());

        // -------------------- back to panel --------------------
        welc_page = stats_page.panel();
        assertEquals("Verifico che sia la pagina corretta", "ADMIN PANEL", welc_page.Title());
    }
}
