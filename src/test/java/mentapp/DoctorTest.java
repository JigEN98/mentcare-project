package mentapp;

import mentapp.PO.ErrorPageObject;
import mentapp.PO.LoginPageObject;
import mentapp.PO.doctor.*;
import mentapp.PO.NotFoundPageObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DoctorTest extends BaseTest {

    @Test
    // Scenario 2: dashboard
    public void Scenario2_dashboard() {
        driver.get("http://localhost:8080/");
        // -------------------- Premesse --------------------
        LoginPageObject login_page = new LoginPageObject(driver);
        WelcomePageDoctorPageObject docPage = login_page.welcomedoc("lucaciano", "luca");

        // -------------------- dashboard dottore --------------------
        assertEquals("Verifico che sia la pagina corretta","Hello Dr. Ciano", docPage.Title());
        assertEquals("check size list patient", 6, docPage.getSizeAppointments());
        assertEquals("2024-10-02 09:00", docPage.getDateAppointment());
        assertEquals("Visita glicemia", docPage.getDescriptionAppointment());
        assertEquals("Mario Rossi", docPage.getNamePatientAppointment());

        assertEquals("check size list patient", 3, docPage.getSizePatients());
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
    //Scenario 3: inserimento paziente
    public void Scenario3_insertpatient() {
        driver.get("http://localhost:8080/");
        // -------------------- Login dottore --------------------
        LoginPageObject login_page = new LoginPageObject(driver);
        WelcomePageDoctorPageObject docPage = login_page.welcomedoc("lucaciano", "luca");
        assertEquals("Verifico che sia la pagina corretta","Hello Dr. Ciano", docPage.Title());
        assertEquals("check size list patients", 3, docPage.getSizePatients());


        // -------------------- inserimento paziente --------------------
        InsertPatientPageObject insertPatient = docPage.showInsertPatient();
        assertEquals("Insert Patient:", insertPatient.Title());
        WelcomePageDoctorPageObject retPage = insertPatient.submit_new_pat();
        assertEquals("Verifico che sia la pagina corretta","Hello Dr. Ciano", retPage.Title());
        assertEquals("check size list patients", 4, docPage.getSizePatients());
        assertEquals("Verifico che il nome inserito sia corretto","Luca", retPage.getLnamepatient());
        assertEquals("Verifico che il cognome inserito sia corretto","Toni", retPage.getLsurnamepatient());
        assertEquals("Verifico che la data inserita sia corretta","1990-03-18", retPage.getLdatepatient());

        // -------------------- Errori possibili --------------------
        //Campo vuoto
        insertPatient  = docPage.showInsertPatient();
        ErrorPageObject empty_field = insertPatient.submit_empty();
        assertEquals("Verifico che sia l'errore mostrato sia corretto","ERROR: Empty field", empty_field.MessageError());
        docPage = empty_field.ShowList();
        //Paziente nato dopo la data odierna
        insertPatient  = docPage.showInsertPatient();
        ErrorPageObject date_format = insertPatient.submit_date();
        assertEquals("Verifico che sia l'errore mostrato sia corretto","ERROR: Date format", date_format.MessageError());
        docPage = date_format.ShowList();

        // -------------------- Logout --------------------
        login_page = retPage.logout();
        assertEquals("Verifico che sia la pagina corretta","MentCare Login", login_page.Title());

    }


    @Test
    // Scenario 4: modifica paziente
    public void Scenario4_modifyPatient() {
        driver.get("http://localhost:8080/");
        // -------------------- premesse --------------------
        LoginPageObject login_page = new LoginPageObject(driver);
        WelcomePageDoctorPageObject docPage = login_page.welcomedoc("lucaciano", "luca");
        assertEquals("Verifico che sia la pagina corretta","Hello Dr. Ciano", docPage.Title());

        // -------------------- modifica paziente--------------------
        ModifyPatientPageObject modifyPatient = docPage.showModifyPatient();
        assertEquals("Verifico che sia la pagina corretta","Edit a patient", modifyPatient.Title());
        WelcomePageDoctorPageObject retPage = modifyPatient.update_patient();
        assertEquals("Verifico che sia la pagina corretta","Hello Dr. Ciano", retPage.Title());
        assertEquals("Verifico che il nome sia aggiornato","Charles", retPage.getNamePatient());
        assertEquals("Verifico che il cognome sia aggiornato","Leclerc", retPage.getSurnamePatient());
        assertEquals("Verifico che il cognome sia aggiornato","1997-10-16", retPage.getBirthDatePatient());

        // -------------------- Errori possibili --------------------
        //Campo vuoto
        modifyPatient = docPage.showModifyPatient();
        ErrorPageObject empty_field = modifyPatient.update_empty();
        assertEquals("Verifico che sia l'errore mostrato sia corretto","ERROR: Empty field", empty_field.MessageError());
        docPage = empty_field.ShowList();
        //Paziente nato dopo la data odierna
        modifyPatient   = docPage.showModifyPatient();
        ErrorPageObject date_format = modifyPatient.update_date();
        assertEquals("Verifico che sia l'errore mostrato sia corretto","ERROR: Date format", date_format.MessageError());
        docPage = date_format.ShowList();

        // -------------------- Logout --------------------
        login_page = retPage.logout();
        assertEquals("Verifico che sia la pagina corretta","MentCare Login", login_page.Title());

    }

    @Test
    // Scenario 5: eliminazione paziente
    public void Scenario5_deletePatient() {
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


    @Test
    // Scenario 6: inserimento appuntamento
    public void Scenario6_insertAppointment() {
        driver.get("http://localhost:8080/");
        // -------------------- Login dottore --------------------
        LoginPageObject login_page = new LoginPageObject(driver);
        WelcomePageDoctorPageObject docPage = login_page.welcomedoc("lucaciano", "luca");
        assertEquals("Verifico che sia la pagina corretta","Hello Dr. Ciano", docPage.Title());
        assertEquals("check size list appointment", 6, docPage.getSizeAppointments());

        // -------------------- inserimento appuntamento --------------------
        InsertAppointmentPageObject insertAppointment = docPage.showInsertAppointment();
        assertEquals("Insert Appointment:", insertAppointment.Title());
        WelcomePageDoctorPageObject retPage = insertAppointment.submit_new_app();
        assertEquals("Verifico che sia la pagina corretta","Hello Dr. Ciano", retPage.Title());
        assertEquals("check size list appointment", 7, docPage.getSizeAppointments());
        assertEquals("Verifico che sia la data sia corretta","2023-03-18 10:55", retPage.getLDateAppointment());
        assertEquals("Verifico che sia la descrizione sia corretta","TEST", retPage.getLDescriptionAppointment());
        assertEquals("Verifico che sia il paziente sia corretto","Mario Rossi", retPage.getLNamePatientAppointment());

        // -------------------- Errori possibili --------------------
        //Campo vuoto
        insertAppointment  = docPage.showInsertAppointment();
        ErrorPageObject empty_field = insertAppointment.submit_empty();
        assertEquals("Verifico che sia l'errore mostrato sia corretto","ERROR: Empty field", empty_field.MessageError());
        docPage = empty_field.ShowList();
        //2 appuntamenti coincidono
        insertAppointment  = docPage.showInsertAppointment();
        ErrorPageObject same_date = insertAppointment.submit_same();
        assertEquals("Verifico che sia l'errore mostrato sia corretto","ERROR: Date format", same_date.MessageError());
        docPage = same_date.ShowList();
        //Appuntamento nel passato
        insertAppointment  = docPage.showInsertAppointment();
        ErrorPageObject past_date = insertAppointment.submit_past();
        assertEquals("Verifico che sia l'errore mostrato sia corretto","ERROR: Date format", past_date.MessageError());
        docPage = past_date.ShowList();
        //Appuntamento sovrapposto post
        insertAppointment  = docPage.showInsertAppointment();
        ErrorPageObject close_date = insertAppointment.submit_close();
        assertEquals("Verifico che sia l'errore mostrato sia corretto","ERROR: Slot is already occupied! Visits last 1 hour", close_date.MessageError());
        docPage = close_date.ShowList();
        //Appuntamento sovrapposto pre
        insertAppointment  = docPage.showInsertAppointment();
        ErrorPageObject close_date_2 = insertAppointment.submit_close_2();
        assertEquals("Verifico che sia l'errore mostrato sia corretto","ERROR: Slot is already occupied! Visits last 1 hour", close_date_2.MessageError());
        docPage = close_date_2.ShowList();
        //Ambulatorio chiuso
        insertAppointment  = docPage.showInsertAppointment();
        ErrorPageObject closed = insertAppointment.closed();
        assertEquals("Verifico che sia l'errore mostrato sia corretto","ERROR: Structure close! You can only book appointments from 8am to 18pm!", closed.MessageError());
        docPage = closed.ShowList();



        // -------------------- Logout --------------------
        login_page = docPage.logout();
        assertEquals("Verifico che sia la pagina corretta","MentCare Login", login_page.Title());
    }

    @Test
    // Scenario 7: modifica appuntamento
    public void Scenario7_modifyAppointment() {
        driver.get("http://localhost:8080/");
        // -------------------- premesse --------------------
        LoginPageObject login_page = new LoginPageObject(driver);
        WelcomePageDoctorPageObject docPage = login_page.welcomedoc("lucaciano", "luca");
        assertEquals("Verifico che sia la pagina corretta","Hello Dr. Ciano", docPage.Title());

        // -------------------- modifica appuntamento--------------------
        ModifyAppointmentPageObject modifyAppointment = docPage.showModifyAppointment();
        assertEquals("Verifico che sia la pagina corretta","Edit an appointment", modifyAppointment.Title());
        WelcomePageDoctorPageObject retPage = modifyAppointment.update_appointment();
        assertEquals("Verifico che sia la pagina corretta","Hello Dr. Ciano", retPage.Title());
        assertEquals("Verifico che la data sia aggiornata","2025-10-11 10:00", retPage.getDateAppointment());
        assertEquals("Verifico che la descrizione sia aggiornata","TEST", retPage.getDescriptionAppointment());
        assertEquals("Verifico che il nome sia aggiornato","Gianluca Verdi", retPage.getNamePatientAppointment());

        // -------------------- Errori possibili --------------------
        //Campo vuoto
        modifyAppointment  = docPage.showModifyAppointment();
        ErrorPageObject empty_field = modifyAppointment.submit_empty();
        assertEquals("Verifico che sia l'errore mostrato sia corretto","ERROR: Empty field", empty_field.MessageError());
        docPage = empty_field.ShowList();
        //Appuntamento nel passato
        modifyAppointment  = docPage.showModifyAppointment();
        ErrorPageObject past_date = modifyAppointment.submit_past();
        assertEquals("Verifico che sia l'errore mostrato sia corretto","ERROR: Date format", past_date.MessageError());
        docPage = past_date.ShowList();
        //2 appuntamenti coincidono
        modifyAppointment  = docPage.showModifyAppointment();
        ErrorPageObject same_date = modifyAppointment.submit_same();
        assertEquals("Verifico che sia l'errore mostrato sia corretto","ERROR: Slot is already occupied! Visits last 1 hour", same_date.MessageError());
        docPage = same_date.ShowList();
        //Appuntamento sovrapposto post
        modifyAppointment  = docPage.showModifyAppointment();
        ErrorPageObject close_date = modifyAppointment.submit_close();
        assertEquals("Verifico che sia l'errore mostrato sia corretto","ERROR: Slot is already occupied! Visits last 1 hour", close_date.MessageError());
        docPage = close_date.ShowList();
        //Appuntamento sovrapposto pre
        modifyAppointment  = docPage.showModifyAppointment();
        ErrorPageObject close_date_2 = modifyAppointment.submit_close_2();
        assertEquals("Verifico che sia l'errore mostrato sia corretto","ERROR: Slot is already occupied! Visits last 1 hour", close_date_2.MessageError());
        docPage = close_date_2.ShowList();
        //Ambulatorio chiuso
        modifyAppointment   = docPage.showModifyAppointment();
        ErrorPageObject closed = modifyAppointment .closed();
        assertEquals("Verifico che sia l'errore mostrato sia corretto","ERROR: Structure close! You can only book appointments from 8am to 18pm!", closed.MessageError());
        docPage = closed.ShowList();

        // -------------------- Logout --------------------
        login_page = docPage.logout();
        assertEquals("Verifico che sia la pagina corretta","MentCare Login", login_page.Title());
    }

    @Test
    // Scenario 8: eliminazione appuntamento
    public void Scenario8_deleteAppointment() {
        driver.get("http://localhost:8080/");
        // -------------------- premesse --------------------
        LoginPageObject login_page = new LoginPageObject(driver);
        WelcomePageDoctorPageObject docPage = login_page.welcomedoc("lucaciano", "luca");
        assertEquals("Verifico che sia la pagina corretta","Hello Dr. Ciano", docPage.Title());
        assertEquals("check size list appointment", 6, docPage.getSizeAppointments());

        // -------------------- eliminazione appuntamento--------------------
        docPage.getDateAppointment();
        assertEquals("2024-10-02 09:00", docPage.getDateAppointment());
        docPage.deleteApp();
        assertEquals("2024-09-02 10:00", docPage.getDateAppointment());
        assertEquals("check size list appointment", 5, docPage.getSizeAppointments());

        // -------------------- Logout --------------------
        login_page = docPage.logout();
        assertEquals("Verifico che sia la pagina corretta","MentCare Login", login_page.Title());
    }


}
