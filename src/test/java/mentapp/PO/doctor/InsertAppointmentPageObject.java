package mentapp.PO.doctor;

import mentapp.PO.LoginPageObject;
import mentapp.PO.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InsertAppointmentPageObject extends PageObject {
    public InsertAppointmentPageObject(WebDriver driver) {
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

    @FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[4]/input[1]")
    private WebElement BTNsubmit;

    @FindBy(name = "show")
    private WebElement BTNshow;

    @FindBy(name = "logout")
    private WebElement BTNlogout;

    public String Title(){
        return h2.getText();
    }

    public WelcomePageDoctorPageObject submit_new_app() {
        LocalDateTime date_app = LocalDateTime.of(2023, 03, 18, 10, 55);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        this.date.clear();
        this.date.sendKeys(date_app.format(formatter));
        this.description.sendKeys("TEST");
        this.patient.sendKeys("6");
        this.BTNsubmit.click();
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
