package mentapp.PO.doctor;

import mentapp.PO.ErrorPageObject;
import mentapp.PO.LoginPageObject;
import mentapp.PO.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InsertPatientPageObject extends PageObject {
    public InsertPatientPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html[1]/body[1]/div[1]/h2[1]")
    private WebElement h2;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[1]/input[1]")
    private WebElement name;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[2]/input[1]")
    private WebElement surname;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[3]/input[1]")
    private WebElement date;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[4]/input[1]")
    private WebElement BTNsubmit;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/a[1]/input[1]")
    private WebElement BTNshow;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/a[1]/input[1]")
    private WebElement BTNlogout;

    public String Title(){
        return h2.getText();
    }

    public WelcomePageDoctorPageObject submit_new_pat() {
        LocalDate date_pat = LocalDate.of(1990, 03, 18);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.date.clear();
        this.date.sendKeys(date_pat.format(formatter));
        this.name.sendKeys("Luca");
        this.surname.sendKeys("Toni");
        this.BTNsubmit.click();
        return new WelcomePageDoctorPageObject(driver);
    }

    public ErrorPageObject submit_empty() {
        LocalDate date_pat = LocalDate.of(1990, 03, 18);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.date.clear();
        this.date.sendKeys(date_pat.format(formatter));
        this.name.sendKeys("");
        this.surname.sendKeys("Toni");
        this.BTNsubmit.click();
        return new ErrorPageObject(driver);
    }

    public ErrorPageObject submit_date() {
        LocalDate date_pat = LocalDate.of(2024, 03, 18);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.date.clear();
        this.date.sendKeys(date_pat.format(formatter));
        this.name.sendKeys("Luca");
        this.surname.sendKeys("Toni");
        this.BTNsubmit.click();
        return new ErrorPageObject(driver);
    }

    public  WelcomePageDoctorPageObject showList() {
        this.BTNshow.click();
        return new WelcomePageDoctorPageObject(driver);
    }

    public LoginPageObject logout() {
        this.BTNlogout.click();
        return new LoginPageObject(driver);
    }
}
