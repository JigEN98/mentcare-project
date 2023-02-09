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

    @FindBy(xpath = "//body/div[1]/div[2]/a[1]/input[1]")
    private WebElement app_list;

    @FindBy(xpath = "//body/div/table/tbody/tr[1]/td[1]")
    private WebElement dateAppointment;

    @FindBy(xpath = "//body/div/table/tbody/tr[1]/td[2]")
    private WebElement descriptionAppointment;

    @FindBy(xpath = "//body/div/table/tbody/tr[1]/td[3]")
    private WebElement namePatientAppointment;

    @FindAll(@FindBy(name = "appointments"))
    private List<WebElement> listAppointments;

    @FindAll(@FindBy(name = "patients"))
    private List<WebElement> listPatients;

    @FindBy(name = "insertAppointment")
    private WebElement insertAppointment;

    @FindBy(name = "insertPatient")
    private WebElement insertPatient;

    @FindBy(name = "logout")
    private WebElement logout;


    // ---------- Methods ----------
    public String Title(){
        return h1.getText();
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

    public int getSizeAppointments() {
        return this.listAppointments.size();
    }

    public int getSizePatients() {
        return this.listPatients.size();
    }

    public LoginPageObject logout() {
        this.logout.click();
        return new LoginPageObject(driver);
    }
}
