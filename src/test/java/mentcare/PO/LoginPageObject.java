package mentcare.PO;

import mentcare.PO.patient.NotFoundPageObject;
import mentcare.PO.patient.WelcomePagePatientPageObject;
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

    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    @FindBy(id = "login")
    private WebElement submitButton;


    // ---------- Methods ----------
    public String Title(){
        return h2loginpage.getText();
    }

    public WelcomePagePatientPageObject welcomepat(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.submitButton.click();
        return new WelcomePagePatientPageObject(driver);
    }

    /*public ReceptionistPatientListPageObject UserReceptionist(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.submitButton.click();
        return new ReceptionistPatientListPageObject(driver);
    }*/

    public NotFoundPageObject UserNotFound(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.submitButton.click();
        return new NotFoundPageObject(driver);
    }
}

