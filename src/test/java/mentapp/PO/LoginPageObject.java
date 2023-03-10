package mentapp.PO;


import mentapp.PO.admin.WelcomePageOfficePageObject;
import mentapp.PO.doctor.WelcomePageDoctorPageObject;
import mentapp.PO.patient.WelcomePagePatientPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObject extends PageObject {

    public LoginPageObject(WebDriver driver){
        super(driver);
    }
    // ---------- Locators ----------
    @FindBy(tagName = "h2")
    private WebElement h2loginpage;

    @FindBy(xpath = "//body/div[1]/form[1]/div[1]/input[1]")
    private WebElement username;

    @FindBy(xpath = "//body/div[1]/form[1]/div[2]/input[1]")
    private WebElement password;

    @FindBy(xpath = "//body/div[1]/form[1]/div[3]/input[1]")
    private WebElement submitButton;


    // ---------- Methods ----------
    public String Title(){
        return h2loginpage.getText();
    }

    public WelcomePagePatientPageObject welcomepat(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.submitButton.click();
        return new WelcomePagePatientPageObject(driver);
    }

    public WelcomePageOfficePageObject welcomeadmin(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.submitButton.click();
        return new WelcomePageOfficePageObject(driver);
    }

    public NotFoundPageObject UserNotFound(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.submitButton.click();
        return new NotFoundPageObject(driver);
    }

    public WelcomePageDoctorPageObject welcomedoc(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.submitButton.click();
        return new WelcomePageDoctorPageObject(driver);
    }
}

