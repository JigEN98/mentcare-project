package mentapp.PO.doctor;

import mentapp.PO.LoginPageObject;
import mentapp.PO.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InsertAppointment extends PageObject {
    public InsertAppointment(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h2")
    private WebElement h2;

    @FindBy(name = "date")
    private WebElement date;

    @FindBy(name = "description")
    private WebElement description;

    @FindBy(name = "id_pat")
    private WebElement patient;

    @FindBy(name = "sub")
    private WebElement BTNsubmit;

    @FindBy(name = "show")
    private WebElement BTNshow;

    @FindBy(name = "logout")
    private WebElement BTNlogout;

    public String getTitle(){
        return h2.getText();
    }

    public void setDate() {
        this.date.sendKeys("10/02/2023 20:42");
    }
    public void setDescription() {
        this.description.sendKeys("descrizione di test");
    }

    public void setPatient() {
        this.patient.sendKeys("Mario Rossi");
    }

    public WelcomePageDoctorPageObject submitPat() {
        this.patient.submit();
        return new WelcomePageDoctorPageObject(driver);
    }

    public  WelcomePageDoctorPageObject showList() {
        this.BTNshow.click();
        return new WelcomePageDoctorPageObject(driver);
    }

    public LoginPageObject logout() {
        this.BTNlogout.click();
        return new LoginPageObject(driver);
    }
}
