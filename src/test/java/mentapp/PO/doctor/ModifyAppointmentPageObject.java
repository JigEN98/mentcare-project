package mentapp.PO.doctor;

import mentapp.PO.ErrorPageObject;
import mentapp.PO.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class ModifyAppointmentPageObject extends PageObject {

    public ModifyAppointmentPageObject(WebDriver driver){
        super(driver);
    }

    // ---------- Locators ----------
    @FindBy(xpath = "/html[1]/body[1]/div[1]/h2[1]")
    private WebElement h2_modify;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[1]/input[1]")
    private WebElement date;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[2]/input[1]")
    private WebElement descrizione;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[3]/select[1]")
    private WebElement p_name;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[4]/input[1]")
    private WebElement submitBTN;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/a[1]/input[1]")
    private WebElement listBTN;

    // ---------- Methods ----------
    public String Title(){
        return h2_modify.getText();
    }

    public WelcomePageDoctorPageObject update_appointment() {
        LocalDateTime date_app = LocalDateTime.of(2025, 10, 11, 10, 00);
        this.date.clear();
        this.date.sendKeys(date_app.format(DateTimeFormatter.ofPattern("dd/MM/yyyy\tHH:mm")));
        this.descrizione.clear();
        this.descrizione.sendKeys("TEST");
        Select select = new Select(this.p_name);
        select.selectByVisibleText("Gianluca Verdi");
        this.submitBTN.click();
        return new WelcomePageDoctorPageObject(driver);
    }

    public ErrorPageObject submit_empty() {
        LocalDateTime date_app = LocalDateTime.of(2025, 10, 11, 10, 00);
        this.date.clear();
        this.date.sendKeys(date_app.format(DateTimeFormatter.ofPattern("dd/MM/yyyy\tHH:mm")));
        this.descrizione.clear();
        this.submitBTN.click();
        return new ErrorPageObject(driver);
    }

    public ErrorPageObject submit_past() {
        LocalDateTime date_app = LocalDateTime.of(2020, Month.MARCH, 18, 10, 55);
        this.date.clear();
        this.date.sendKeys(date_app.format(DateTimeFormatter.ofPattern("dd/MM/yyyy\tHH:mm")));
        this.descrizione.sendKeys("TEST");
        Select select = new Select(this.p_name);
        select.selectByVisibleText("Gianluca Verdi");
        this.submitBTN.click();
        return new ErrorPageObject(driver);
    }

    public ErrorPageObject submit_same() {
        LocalDateTime date_app = LocalDateTime.of(2024,9,2,10,00);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy\tHH:mm");
        this.date.clear();
        this.date.sendKeys(date_app.format(formatter));
        this.descrizione.sendKeys("TEST");
        Select select = new Select(this.p_name);
        select.selectByVisibleText("Gianluca Verdi");
        this.submitBTN.click();
        return new ErrorPageObject(driver);
    }

    public ErrorPageObject submit_close() {
        LocalDateTime date_app = LocalDateTime.of(2024,9,2,10,10);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy\tHH:mm");
        this.date.clear();
        this.date.sendKeys(date_app.format(formatter));
        this.descrizione.sendKeys("TEST");
        Select select = new Select(this.p_name);
        select.selectByVisibleText("Gianluca Verdi");
        this.submitBTN.click();
        return new ErrorPageObject(driver);
    }

    public ErrorPageObject submit_close_2() {
        LocalDateTime date_app = LocalDateTime.of(2024,9,2,9,50);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy\tHH:mm");
        this.date.clear();
        this.date.sendKeys(date_app.format(formatter));
        this.descrizione.sendKeys("TEST");
        Select select = new Select(this.p_name);
        select.selectByVisibleText("Gianluca Verdi");
        this.submitBTN.click();
        return new ErrorPageObject(driver);
    }
    public  WelcomePageDoctorPageObject showList() {
        this.listBTN.click();
        return new WelcomePageDoctorPageObject(driver);
    }
}
