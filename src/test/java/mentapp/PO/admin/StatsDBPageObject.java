package mentapp.PO.admin;

import mentapp.PO.LoginPageObject;
import mentapp.PO.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StatsDBPageObject extends PageObject {

    public StatsDBPageObject(WebDriver driver){
        super(driver);
    }

    // ---------- Locators ----------
    @FindBy(tagName = "h2")
    private WebElement h2stats;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/ul[1]/li[1]")
    private WebElement ct_users;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/ul[1]/li[2]")
    private WebElement ct_patients;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/ul[1]/li[3]")
    private WebElement ct_doctors;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/ul[1]/li[4]")
    private WebElement ct_appointments;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/a[1]/input[1]")
    private WebElement panel;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/a[1]/input[1]")
    private WebElement logout;

    // ---------- Methods ----------
    public String Title(){
        return h2stats.getText();
    }
    public String checkUsers(){
        return ct_users.getText();
    }
    public String checkPatients(){
        return ct_patients.getText();
    }
    public String checkDoctors(){
        return ct_doctors.getText();
    }
    public String checkAppointments(){
        return ct_appointments.getText();
    }
    public WelcomePageOfficePageObject panel() {
        this.panel.click();
        return new WelcomePageOfficePageObject(driver);
    }
    public LoginPageObject logout() {
        this.logout.click();
        return new LoginPageObject(driver);
    }

}
