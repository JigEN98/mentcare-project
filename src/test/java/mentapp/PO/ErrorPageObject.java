package mentapp.PO;

import mentapp.PO.LoginPageObject;
import mentapp.PO.PageObject;
import mentapp.PO.doctor.WelcomePageDoctorPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ErrorPageObject extends PageObject {
    public ErrorPageObject(WebDriver driver){super(driver);}

    // ---------- Locators ----------
    @FindBy(xpath = "/html[1]/body[1]/div[1]/b[1]/div[1]/p[1]")
    private WebElement Error;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/p[1]/a[1]/button[1]")
    private WebElement ReturnList;

    // ---------- Methods ----------
    public String MessageError(){return Error.getText();}

    public WelcomePageDoctorPageObject ShowList(){
        this.ReturnList.click();
        return new WelcomePageDoctorPageObject(driver);
    }
}
