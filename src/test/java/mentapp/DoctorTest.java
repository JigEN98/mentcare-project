package mentapp;

import mentapp.PO.LoginPageObject;
import mentapp.PO.doctor.InsertAppointmentPageObject;
import mentapp.PO.doctor.WelcomePageDoctorPageObject;
import mentapp.PO.NotFoundPageObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DoctorTest extends BaseTest {

    @Test
    // scenario 5 dashboard
    public void lists() {
        driver.get("http://localhost:8080/");
        // -------------------- Premesse --------------------
        LoginPageObject login_page = new LoginPageObject(driver);
        WelcomePageDoctorPageObject docPage = login_page.welcomedoc("lucaciano", "luca");

        // -------------------- dashboard dottore --------------------
        assertEquals("Verifico che sia la pagina corretta","Lista appuntamenti", docPage.Title());
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

        NotFoundPageObject NotFound_page2 = login_page.UserNotFound("guest", "guest");
        login_page = NotFound_page2.ShowLogin();
        assertEquals("Verifico che sia la pagina corretta","MentCare Login", login_page.Title());

        NotFoundPageObject NotFound_page3 = login_page.UserNotFound("isaialucco", "isaia");
        login_page = NotFound_page3.ShowLogin();
        assertEquals("Verifico che sia la pagina corretta","MentCare Login", login_page.Title());

    }

    @Test
    // scenario 6 inserimento appuntamento
    public void insertAppointment() {
        driver.get("http://localhost:8080/");
        // -------------------- Login dottore --------------------
        LoginPageObject login_page = new LoginPageObject(driver);
        WelcomePageDoctorPageObject docPage = login_page.welcomedoc("lucaciano", "luca");
        assertEquals("check size list appointment", 6, docPage.getSizeAppointments());

        // -------------------- inserimento appuntamento --------------------
        InsertAppointmentPageObject insertAppointment = docPage.showInsertAppointment();
        assertEquals("Insert Appointment:", insertAppointment.Title());
        WelcomePageDoctorPageObject retPage = insertAppointment.submit_new_app();
        assertEquals("Verifico che sia la pagina corretta","Lista appuntamenti", retPage.Title());
        assertEquals("check size list patient", 7, retPage.getSizeAppointments());
        assertEquals("2023-10-02 12:30", retPage.getLDateAppointment());
        assertEquals("descrizione di test", retPage.getLDescriptionAppointment());
        assertEquals("1", retPage.getLNamePatientAppointment());

        // -------------------- Logout --------------------
        login_page = retPage.logout();
        assertEquals("Verifico che sia la pagina corretta","MentCare Login", login_page.Title());
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
        // -------------------- premesse --------------------
        LoginPageObject login_page = new LoginPageObject(driver);
        WelcomePageDoctorPageObject docPage = login_page.welcomedoc("lucaciano", "luca");

        // -------------------- eliminazione appuntamento--------------------
        docPage.getDateAppointment();
        assertEquals("2024-10-02 09:00", docPage.getDateAppointment());
        docPage.deleteApp();
        assertEquals("2024-09-02 10:00", docPage.getDateAppointment());

        // -------------------- Logout --------------------
        login_page = docPage.logout();
        assertEquals("Verifico che sia la pagina corretta","MentCare Login", login_page.Title());
    }

    @Test
    // scenario 7 inserimento paziente
    public void insertPatient() {
        driver.get("http://localhost:8080/");
        // -------------------- Login dottore --------------------
        LoginPageObject login_page = new LoginPageObject(driver);
        WelcomePageDoctorPageObject docPage = login_page.welcomedoc("lucaciano", "luca");
        assertEquals("check size list patient", 2, docPage.getSizePatients());

        // -------------------- inserimento paziente --------------------
        /*InsertPatient insert_p= docPage.showInsertPatient();
        assertEquals("Insert Appointment:", insertAppointment.getTitle());


        WelcomePageDoctorPageObject retPage = insert_p.submit_new_pat();
        assertEquals("Verifico che sia la pagina corretta","Lista appuntamenti", retPage.Title());
        assertEquals("check size list patient", 7, retPage.getSizeAppointments());
        assertEquals("2023-10-02 12:30", retPage.getLDateAppointment());
        assertEquals("descrizione di test", retPage.getLDescriptionAppointment());
        assertEquals("1", retPage.getLNamePatientAppointment());*/

        // -------------------- Logout --------------------
        //login_page = retPage.logout();
        assertEquals("Verifico che sia la pagina corretta","MentCare Login", login_page.Title());
    }


    @Test
    // scenario 8 modifica paziente
    public void modifyPatient() {

    }

    @Test
    // scenario 9 eliminazione paziente
    public void deletePatient() {
        driver.get("http://localhost:8080/");
        // -------------------- premesse --------------------
        LoginPageObject login_page = new LoginPageObject(driver);
        WelcomePageDoctorPageObject docPage = login_page.welcomedoc("lucaciano", "luca");

        // -------------------- eliminazione paziente--------------------
        docPage.getDateAppointment();
        assertEquals("Mario", docPage.getNamePatient());
        assertEquals("Rossi", docPage.getSurnamePatient());
        docPage.deletePat();
        assertEquals("Gianluca", docPage.getNamePatient());
        assertEquals("Verdi", docPage.getSurnamePatient());

        // -------------------- Logout --------------------
        login_page = docPage.logout();
        assertEquals("Verifico che sia la pagina corretta","MentCare Login", login_page.Title());

    }

}
