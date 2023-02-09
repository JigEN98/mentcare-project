package mentapp;

import mentapp.PO.LoginPageObject;
import mentapp.PO.doctor.InsertAppointment;
import mentapp.PO.doctor.WelcomePageDoctorPageObject;
import mentapp.PO.NotFoundPageObject;
import mentapp.PO.patient.WelcomePagePatientPageObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DoctorTest extends BaseTest {
    @Test
    // scenario 4 login del dottore
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
    }

    @Test
    // scenario 5 dashboard
    public void lists() {
        driver.get("http://localhost:8080/");
        // -------------------- Login dottore --------------------
        LoginPageObject login_page = new LoginPageObject(driver);
        WelcomePageDoctorPageObject docPage = login_page.welcomedoc("lucaciano", "luca");

        assertEquals("check size list patient", 5, docPage.getSizeAppointments());
        assertEquals("2024-10-02 09:00", docPage.getDateAppointment());
        assertEquals("Visita glicemia", docPage.getDescriptionAppointment());
        assertEquals("Mario Rossi", docPage.getNamePatientAppointment());

        assertEquals("check size list patient", 2, docPage.getSizePatients());
        assertEquals("Mario", docPage.getNamePatient());
        assertEquals("Rossi", docPage.getSurnamePatient());
        assertEquals("1987-03-01", docPage.getBirthDatePatient());

        // -------------------- Logout --------------------
        login_page = docPage.logout();
        assertEquals("Verifico che sia la pagina corretta","MentCare Login", login_page.Title());

        // -------------------- Errori possibili --------------------
        NotFoundPageObject NotFound_page = login_page.UserNotFound("mariorossi", "rossi");
        login_page = NotFound_page.ShowLogin();
    }

    @Test
    // scenario 6 inserimento appuntamento
    public void insertAppointment() {
        driver.get("http://localhost:8080/");
        // -------------------- Login dottore --------------------
        LoginPageObject login_page = new LoginPageObject(driver);
        WelcomePageDoctorPageObject docPage = login_page.welcomedoc("lucaciano", "luca");

        InsertAppointment insertAppointment = docPage.showInsertAppointment();
        assertEquals("Insert Appointment:", insertAppointment.getTitle());
        insertAppointment.setDate();
        insertAppointment.setDescription();
        insertAppointment.setPatient();
        /*WelcomePageDoctorPageObject retPage = insertAppointment.submitPat();
        assertEquals("check size list patient", 6, retPage.getSizeAppointments());
        //assertEquals("10/02/2023 20:42", retPage.getLDateAppointment());
        assertEquals("descrizione di test", retPage.getLDescriptionAppointment());
        assertEquals("Mario Rossi", retPage.getLNamePatientAppointment());*/
    }

    @Test
    // scenario 11 modifica appuntamento
    public void modifyAppointment() {
        driver.get("http://localhost:8080/");
        // -------------------- Login dottore --------------------
        LoginPageObject login_page = new LoginPageObject(driver);
        WelcomePageDoctorPageObject docPage = login_page.welcomedoc("lucaciano", "luca");
    }

    @Test
    // scenario 12 eliminazione appuntamento
    public void deleteAppointment() {
        driver.get("http://localhost:8080/");
        // -------------------- Login dottore --------------------
        LoginPageObject login_page = new LoginPageObject(driver);
        WelcomePageDoctorPageObject docPage = login_page.welcomedoc("lucaciano", "luca");
    }

    @Test
    // scenario 7 inserimento paziente
    public void insertPatient() {
        driver.get("http://localhost:8080/");
        // -------------------- Login dottore --------------------
        LoginPageObject login_page = new LoginPageObject(driver);
        WelcomePageDoctorPageObject docPage = login_page.welcomedoc("lucaciano", "luca");
    }


    @Test
    // scenario 8 modifica paziente
    public void modifyPatient() {

    }

    @Test
    // scenario 9 eliminazione paziente
    public void deletePatient() {

    }

}
