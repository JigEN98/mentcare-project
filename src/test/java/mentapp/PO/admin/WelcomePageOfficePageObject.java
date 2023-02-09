package mentapp.PO.admin;

import mentapp.PO.LoginPageObject;
import mentapp.PO.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePageOfficePageObject extends PageObject{

    public WelcomePageOfficePageObject(WebDriver driver){
        super(driver);
    }

    // ---------- Locators ----------
    @FindBy(tagName = "h2")
    private WebElement h2admin;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/a[1]/input[1]")
    private WebElement stats;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/a[1]/input[1]")
    private WebElement users_list;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/a[1]/input[1]")
    private WebElement logout;

    // ---------- Methods ----------
    public String Title(){
        return h2admin.getText();
    }
    public StatsDBPageObject statsDB() {
        this.stats.click();
        return new StatsDBPageObject(driver);
    }
    public UserListPageObject showUserList() {
        this.users_list.click();
        return new UserListPageObject(driver);
    }
    public LoginPageObject logout() {
        this.logout.click();
        return new LoginPageObject(driver);
    }

}
