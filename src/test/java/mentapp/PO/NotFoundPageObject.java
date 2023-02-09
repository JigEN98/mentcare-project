package mentapp.PO;

import mentapp.PO.LoginPageObject;
import mentapp.PO.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotFoundPageObject extends PageObject {
    public NotFoundPageObject(WebDriver driver){super(driver);}

    // ---------- Locators ----------
    @FindBy(tagName = "b")
    private WebElement Error;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/a[1]/input[1]")
    private WebElement ReturnLoginButton;

    // ---------- Methods ----------
    public String MessageError(){return Error.getText();}

    public LoginPageObject ShowLogin(){
        this.ReturnLoginButton.click();
        return new LoginPageObject(driver);
    }
}
