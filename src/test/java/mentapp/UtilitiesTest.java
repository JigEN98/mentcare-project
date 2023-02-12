package mentapp;

import mentapp.PO.*;
import mentapp.PO.admin.StatsDBPageObject;
import mentapp.PO.admin.UserListPageObject;
import mentapp.PO.admin.WelcomePageOfficePageObject;
import mentapp.PO.patient.PatientAppListPageObject;
import mentapp.PO.patient.ProfilePatientPageObject;
import mentapp.PO.patient.WelcomePagePatientPageObject;
import org.junit.Test;
import static org.junit.Assert.*;

public class UtilitiesTest extends BaseTest {

    //serie di test su utilities sviluppate nell'applicativo ma non utilizzate negli scenari
    @Test
// profilo paziente
    public void Profile_Patient() {
        driver.get("http://localhost:8080/");
        // -------------------- Premesse --------------------
        LoginPageObject login_page = new LoginPageObject(driver);
        WelcomePagePatientPageObject welc_page = login_page.welcomepat("mariorossi", "mario");
        assertEquals("Verifico che sia la pagina corretta", "Hello Mr Rossi", welc_page.Title());

        // -------------------- profilo paziente --------------------
        ProfilePatientPageObject profile_page = welc_page.showProfile();
        assertEquals("Verifico che sia la pagina corretta", "Profile", profile_page.Title());
        assertEquals("Verifico che il nome del pz sia corretto", "Nome: Mario", profile_page.CheckName());
        assertEquals("Verifico che il cognome del pz sia corretto", "Cognome: Rossi", profile_page.CheckSurname());
        assertEquals("Verifico che la data di nascita del pz sia corretta", "Data di nascita: 1987-03-01", profile_page.CheckDate());

        // -------------------- Logout --------------------
        login_page = profile_page.logout();
        assertEquals("Verifico che sia la pagina corretta", "MentCare Login", login_page.Title());
    }

    @Test
    // lista appuntamenti paziente
    public void Appointments_Patient() {
        driver.get("http://localhost:8080/");
        // -------------------- Premesse --------------------
        LoginPageObject login_page = new LoginPageObject(driver);
        WelcomePagePatientPageObject welc_page = login_page.welcomepat("mariorossi", "mario");
        assertEquals("Verifico che sia la pagina corretta", "Hello Mr Rossi", welc_page.Title());

        // -------------------- lista appuntamenti paziente --------------------
        PatientAppListPageObject app_page = welc_page.showAppList();
        assertEquals("Verifico che sia la pagina corretta", "Detail of appointments:", app_page.Title());
        assertEquals("Verifico che la data dell'appuntamento sia corretta", "2024-10-02 09:00", app_page.CheckDateApp());
        assertEquals("Verifico che il nome del dottore sia corretto", "Ciano", app_page.CheckDoctorApp());
        assertEquals("Verifico che la descrizione dell'appuntamento sia corretta", "Visita glicemia", app_page.CheckDescApp());

        // -------------------- Logout --------------------
        login_page = app_page.logout();
        assertEquals("Verifico che sia la pagina corretta", "MentCare Login", login_page.Title());
    }

    @Test
    //admin user list
    public void admin_userlist() {
        driver.get("http://localhost:8080/");
        // -------------------- Premesse --------------------
        LoginPageObject login_page = new LoginPageObject(driver);
        WelcomePageOfficePageObject welc_page = login_page.welcomeadmin("admin", "admin");
        assertEquals("Verifico che sia la pagina corretta","ADMIN PANEL", welc_page.Title());

        // -------------------- lista users --------------------
        UserListPageObject users = welc_page.showUserList();
        assertEquals("Verifico che la pagina sia corretta", "Users Details:", users.Title());
        assertEquals("Verifico il numero di utenti",13, users.rowTable());


        // -------------------- back to panel --------------------
        welc_page = users.panel();
        assertEquals("Verifico che sia la pagina corretta", "ADMIN PANEL", welc_page.Title());
    }
}