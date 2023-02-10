package mentapp.PO.doctor;

import mentapp.PO.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ModifyPatientPageObject extends PageObject {

    public ModifyPatientPageObject(WebDriver driver){
        super(driver);
    }

    // ---------- Locators ----------
    @FindBy(xpath = "/html[1]/body[1]/div[1]/h2[1]")
    private WebElement h2_modify;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[1]/input[1]")
    private WebElement name;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[2]/input[1]")
    private WebElement surname;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[3]/input[1]")
    private WebElement date;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/form[1]/div[4]/input[1]")
    private WebElement submitBTN;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/a[1]/input[1]")
    private WebElement listBTN;

    // ---------- Methods ----------
    public String Title(){
        return h2_modify.getText();
    }

    public WelcomePageDoctorPageObject update_patient() {

        name.sendKeys("Charles");
        surname.sendKeys("Leclerc");
        LocalDate date_pat = LocalDate.of(1997, 10, 16);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.date.clear();
        this.date.sendKeys(date_pat.format(formatter));
        this.submitBTN.click();
        return new WelcomePageDoctorPageObject(driver);
    }
}
