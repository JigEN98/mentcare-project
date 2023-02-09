package mentapp.PO.doctor;

import mentapp.PO.LoginPageObject;
import mentapp.PO.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePageDoctorPageObject extends PageObject {

    public WelcomePageDoctorPageObject(WebDriver driver){
        super(driver);
    }

    // ---------- Locators ----------
    @FindBy(tagName = "h1")
    private WebElement h1patient;

    @FindBy(xpath = "//body/div[1]/div[1]/a[1]/input[1]")
    private WebElement profile;

    @FindBy(xpath = "//body/div[1]/div[2]/a[1]/input[1]")
    private WebElement app_list;

    @FindBy(xpath = "//body/div[1]/div[3]/a[1]/input[1]")
    private WebElement logout;


    // ---------- Methods ----------
    public String Title(){
        return h1patient.getText();
    }

    public LoginPageObject logout() {
        this.logout.click();
        return new LoginPageObject(driver);
    }
}
