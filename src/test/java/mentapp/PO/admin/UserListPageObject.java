package mentapp.PO.admin;

import mentapp.PO.LoginPageObject;
import mentapp.PO.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserListPageObject extends PageObject {

    public UserListPageObject(WebDriver driver){
        super(driver);
    }

    // ---------- Locators ----------
    @FindBy(tagName = "h2")
    private WebElement h2list;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/a[1]/input[1]")
    private WebElement panel;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/a[1]/input[1]")
    private WebElement logout;

    // ---------- Methods ----------
    public String Title(){
        return h2list.getText();
    }
    public WelcomePageOfficePageObject statsDB() {
        this.panel.click();
        return new WelcomePageOfficePageObject(driver);
    }
    public LoginPageObject logout() {
        this.logout.click();
        return new LoginPageObject(driver);
    }

}