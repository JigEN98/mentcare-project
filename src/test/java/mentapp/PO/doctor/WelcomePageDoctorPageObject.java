package mentapp.PO.doctor;

import mentapp.PO.LoginPageObject;
import mentapp.PO.PageObject;
import org.openqa.selenium.By;
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
    @FindBy(xpath = "/html[1]/body[1]/div[1]/h2[1]")
    private WebElement h1_dash;

    // appuntamenti
    @FindBy(name="table_app")
    private WebElement table_app;

    @FindBy(name ="table_pat")
    private WebElement table_pat;

    @FindBy(xpath = "//body/div/table[1]/tbody/tr[1]/td[1]")
    private WebElement dateAppointment;

    @FindBy(xpath = "//body/div/table[1]/tbody/tr[1]/td[2]")
    private WebElement descriptionAppointment;

    @FindBy(xpath = "//body/div/table[1]/tbody/tr[1]/td[3]")
    private WebElement namePatientAppointment;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/a[1]/input[1]")
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

    @FindBy(name = "insertPatient")
    private WebElement insertPatient;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/a[1]")
    private WebElement delete_app;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/table[2]/tbody[1]/tr[1]/td[5]/a[1]")
    private WebElement delete_pat;

    // logout
    @FindBy(name = "logout")
    private WebElement logout;


    // ---------- Methods ----------
    public String Title(){
        return h1_dash.getText();
    }

    public int getSizeAppointments() {
        return table_app.findElements(By.tagName("tr")).size();
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
        return table_app.findElements(By.tagName("tr")).size();
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

    public InsertAppointmentPageObject showInsertAppointment() {
        this.insertAppointment.click();
        return new InsertAppointmentPageObject(driver);
    }

    public WelcomePageDoctorPageObject deleteApp() {
        this.delete_app.click();
        return new WelcomePageDoctorPageObject(driver);
    }

    public WelcomePageDoctorPageObject deletePat() {
        this.delete_pat.click();
        return new WelcomePageDoctorPageObject(driver);
    }

    public LoginPageObject logout() {
        this.logout.click();
        return new LoginPageObject(driver);
    }
}
