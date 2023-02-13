package mentapp.PO.doctor;

import mentapp.PO.ErrorPageObject;
import mentapp.PO.LoginPageObject;
import mentapp.PO.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class InsertAppointmentPageObject extends PageObject {
    public InsertAppointmentPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h2")
    private WebElement h2;

    @FindBy(name = "date")
    private WebElement date;

    @FindBy(name = "description")
    private WebElement description;

    @FindBy(name = "id_pat")
    private WebElement patient;

    @FindBy(name = "sub")
    private WebElement BTNsubmit;

    @FindBy(name = "show")
    private WebElement BTNshow;

    @FindBy(name = "logout")
    private WebElement BTNlogout;

    public String Title(){
        return h2.getText();
    }

    public WelcomePageDoctorPageObject submit_new_app() {
        LocalDateTime date_app = LocalDateTime.of(2023, Month.MARCH, 18, 10, 55);
        this.date.clear();
        this.date.sendKeys(date_app.format(DateTimeFormatter.ofPattern("dd/MM/yyyy\tHH:mm")));
        this.description.sendKeys("TEST");
        Select select = new Select(this.patient);
        select.selectByVisibleText("Mario Rossi");
        this.BTNsubmit.click();
        return new WelcomePageDoctorPageObject(driver);
    }

    public ErrorPageObject submit_empty() {
        LocalDateTime date_app = LocalDateTime.of(2023, 03, 18, 10, 55);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy\tHH:mm");
        this.date.clear();
        this.date.sendKeys(date_app.format(formatter));
        this.description.sendKeys("");
        Select select = new Select(this.patient);
        select.selectByVisibleText("Mario Rossi");
        this.BTNsubmit.click();
        return new ErrorPageObject(driver);
    }

    public ErrorPageObject submit_same() {
        LocalDateTime date_app = LocalDateTime.of(2024,10,2,9,00);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy\tHH:mm");
        this.date.clear();
        this.date.sendKeys(date_app.format(formatter));
        this.description.sendKeys("TEST");
        Select select = new Select(this.patient);
        select.selectByVisibleText("Mario Rossi");
        this.BTNsubmit.click();
        return new ErrorPageObject(driver);
    }

    public ErrorPageObject submit_past() {
        LocalDateTime date_app = LocalDateTime.of(2020, Month.MARCH, 18, 10, 55);
        this.date.clear();
        this.date.sendKeys(date_app.format(DateTimeFormatter.ofPattern("dd/MM/yyyy\tHH:mm")));
        this.description.sendKeys("TEST");
        Select select = new Select(this.patient);
        select.selectByVisibleText("Mario Rossi");
        this.BTNsubmit.click();
        return new ErrorPageObject(driver);
    }

    public ErrorPageObject submit_close() {
        LocalDateTime date_app = LocalDateTime.of(2024,10,2,9,30);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy\tHH:mm");
        this.date.clear();
        this.date.sendKeys(date_app.format(formatter));
        this.description.sendKeys("TEST");
        Select select = new Select(this.patient);
        select.selectByVisibleText("Mario Rossi");
        this.BTNsubmit.click();
        return new ErrorPageObject(driver);
    }
    public ErrorPageObject submit_close_2() {
        LocalDateTime date_app = LocalDateTime.of(2024,10,2,8,30);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy\tHH:mm");
        this.date.clear();
        this.date.sendKeys(date_app.format(formatter));
        this.description.sendKeys("TEST");
        Select select = new Select(this.patient);
        select.selectByVisibleText("Mario Rossi");
        this.BTNsubmit.click();
        return new ErrorPageObject(driver);
    }

    public ErrorPageObject closed() {
        LocalDateTime date_app = LocalDateTime.of(2024,10,2,2,30);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy\tHH:mm");
        this.date.clear();
        this.date.sendKeys(date_app.format(formatter));
        this.description.sendKeys("TEST");
        Select select = new Select(this.patient);
        select.selectByVisibleText("Mario Rossi");
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

