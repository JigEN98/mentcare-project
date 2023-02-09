package mentapp.PO.doctor;

import mentapp.PO.LoginPageObject;
import mentapp.PO.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WelcomePageDoctorPageObject extends PageObject {

    public WelcomePageDoctorPageObject(WebDriver driver){
        super(driver);
    }

    // ---------- Locators ----------
    @FindBy(tagName = "h1")
    private WebElement h1;

    // appuntamenti
    @FindAll(@FindBy(name = "appointments"))
    private List<WebElement> listAppointments;

    @FindBy(xpath = "//body/div/table[1]/tbody/tr[1]/td[1]")
    private WebElement dateAppointment;

    @FindBy(xpath = "//body/div/table[1]/tbody/tr[1]/td[2]")
    private WebElement descriptionAppointment;

    @FindBy(xpath = "//body/div/table[1]/tbody/tr[1]/td[3]")
    private WebElement namePatientAppointment;

    @FindBy(name = "insertAppointment")
    private WebElement insertAppointment;

    // dopo inserimento
    @FindBy(xpath = "//body/div/table[1]/tbody/tr[6]/td[1]")
    private WebElement ldateAppointment;

    @FindBy(xpath = "//body/div/table[1]/tbody/tr[6]/td[2]")
    private WebElement ldescriptionAppointment;

    @FindBy(xpath = "//body/div/table[1]/tbody/tr[6]/td[3]")
    private WebElement lnamePatientAppointment;

    // pazienti
    @FindBy(xpath = "//body/div/table[2]/tbody/tr[1]/td[1]")
    private WebElement namePatient;

    @FindBy(xpath = "//body/div/table[2]/tbody/tr[1]/td[2]")
    private WebElement surnamePatient;

    @FindBy(xpath = "//body/div/table[2]/tbody/tr[1]/td[3]")
    private WebElement birthDatePatient;

    @FindAll(@FindBy(name = "patients"))
    private List<WebElement> listPatients;

    @FindBy(name = "insertPatient")
    private WebElement insertPatient;

    // logout
    @FindBy(name = "logout")
    private WebElement logout;


    // ---------- Methods ----------
    public String Title(){
        return h1.getText();
    }

    public int getSizeAppointments() {
        return this.listAppointments.size();
    }

    public String getDateAppointment() {
        return this.dateAppointment.getText();
    }

    public String getDescriptionAppointment() {
        return this.descriptionAppointment.getText();
    }

    public String getNamePatientAppointment() {
        return this.namePatientAppointment.getText();
    }

    public String getLDateAppointment() {
        return this.ldateAppointment.getText();
    }

    public String getLDescriptionAppointment() {
        return this.ldescriptionAppointment.getText();
    }

    public String getLNamePatientAppointment() {
        return this.lnamePatientAppointment.getText();
    }

    public int getSizePatients() {
        return this.listPatients.size();
    }
    public String getNamePatient() {
        return this.namePatient.getText();
    }
    public String getSurnamePatient() {
        return this.surnamePatient.getText();
    }
    public String getBirthDatePatient() {
        return this.birthDatePatient.getText();
    }

    public InsertAppointment showInsertAppointment() {
        this.insertAppointment.click();
        return new InsertAppointment(driver);
    }

    public LoginPageObject logout() {
        this.logout.click();
        return new LoginPageObject(driver);
    }
}
