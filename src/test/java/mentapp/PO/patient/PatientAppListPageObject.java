package mentapp.PO.patient;

import mentapp.PO.LoginPageObject;
import mentapp.PO.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PatientAppListPageObject extends PageObject {

    public PatientAppListPageObject(WebDriver driver){
        super(driver);
    }

    // ---------- Locators ----------
    @FindBy(xpath = "/html[1]/body[1]/div[1]/h2[1]")
    private WebElement h1_app;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")
    private WebElement date;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]")
    private WebElement doctor;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]")
    private WebElement desc;

    @FindBy(xpath = "//body/div[1]/div[1]/a[1]/input[1]")
    private WebElement profile;

    @FindBy(xpath = "//body/div[1]/div[2]/a[1]/input[1]")
    private WebElement app_list;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/a[1]/input[1]")
    private WebElement logout;

    // ---------- Methods ----------
    public String Title(){
        return h1_app.getText();
    }
    public String CheckDateApp(){return date.getText();}
    public String CheckDoctorApp(){return doctor.getText();}
    public String CheckDescApp(){return desc.getText();}
    public ProfilePatientPageObject showProfile() {
        this.profile.click();
        return new ProfilePatientPageObject(driver);
    }
    public PatientAppListPageObject showAppList() {
        this.app_list.click();
        return new PatientAppListPageObject(driver);
    }
    public LoginPageObject logout() {
        this.logout.click();
        return new LoginPageObject(driver);
    }

}