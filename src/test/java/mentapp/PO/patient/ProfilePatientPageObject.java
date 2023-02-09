package mentapp.PO.patient;

import mentapp.PO.LoginPageObject;
import mentapp.PO.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePatientPageObject extends PageObject {

    public ProfilePatientPageObject(WebDriver driver){
        super(driver);
    }

    // ---------- Locators ----------
    @FindBy(tagName = "h1")
    private WebElement h1profile;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/h4[1]")
    private WebElement p_name;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/h4[2]")
    private WebElement p_surname;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/h4[3]")
    private WebElement p_date;

    @FindBy(xpath = "//body/div[1]/div[1]/a[1]/input[1]")
    private WebElement profile;

    @FindBy(xpath = "//body/div[1]/div[2]/a[1]/input[1]")
    private WebElement app_list;

    @FindBy(xpath = "//body/div[1]/div[3]/a[1]/input[1]")
    private WebElement logout;

    // ---------- Methods ----------
    public String Title(){
        return h1profile.getText();
    }
    public String CheckName(){return p_name.getText();}
    public String CheckSurname(){return p_surname.getText();}
    public String CheckDate(){return p_date.getText();}
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
