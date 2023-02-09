package mentcare.PO.patient;

import mentcare.PO.LoginPageObject;
import mentcare.PO.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotFoundPageObject extends PageObject {
    public NotFoundPageObject(WebDriver driver){super(driver);}

    // ---------- Locators ----------
    @FindBy(tagName = "b")
    private WebElement Error;

    @FindBy(xpath = "//a/button")
    private WebElement ReturnLoginButton;

    // ---------- Methods ----------
    public String MessageError(){return Error.getText();}

    public LoginPageObject ShowLogin(){
        this.ReturnLoginButton.click();
        return new LoginPageObject(driver);
    }
}
