package pages;

import com.github.javafaker.Faker;
import config.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class GoogleForm extends BasePage {

    @FindBy(xpath = "//div[@class='o3Dpx']/div[1]/div/div/div[2]/div/div[1]/div/div[1]/input")
    WebElement name;
    @FindBy(xpath = "//div[@class='o3Dpx']/div[2]/div/div/div[2]/div/div[1]/div/div[1]/input")
    WebElement lastName;
    @FindBy(xpath = "//div[@class='o3Dpx']/div[3]/div/div/div[2]/div/div[1]/div/div[1]/input")
    WebElement email;
    @FindBy(xpath = "//span[text()='Kobieta']")
    WebElement sexFemale;
    @FindBy(xpath = "//span[text()='Mężczyzna']")
    WebElement sexMale;
    @FindBy(xpath = "//span[text()='Prześlij']")
    WebElement submitButton;
    @FindBy(xpath = "//div[text()='Twoja odpowiedź została zapisana.']")
    WebElement confirmationMessage;

    public GoogleForm() {
        super();
    }

    public void completeFormWithRandomVlues() {
        Faker faker = new Faker();
        String fakerName = faker.name().firstName();
        String fakerLastName = faker.name().lastName();
        String fakerEmail = faker.internet().emailAddress();
        String sex = faker.demographic().sex();

        name.sendKeys(fakerName);
        sendToReportAndConsole("Wpisano wartość " + fakerName + " w polu Imię");

        lastName.sendKeys(fakerLastName);
        sendToReportAndConsole("Wpisano wartość " + fakerLastName + " w polu Nazwisko");

        email.sendKeys(fakerEmail);
        sendToReportAndConsole("Wpisano wartość " + fakerEmail + " w polu E-mail");

        if (sex == "Male") {
            sexMale.click();
            sendToReportAndConsole("Wybrano wartość Mężczyzna w sekcji Płeć");
        } else {
            sexFemale.click();
            sendToReportAndConsole("Wybrano wartość Kobieta w sekcji Płeć");
        }
    }

    public void submitForm() {
        submitButton.click();
    }

    public boolean formSubmissionConfirmation() {
        try {
            boolean isConfirmationDisplayed = confirmationMessage.isDisplayed();
            return isConfirmationDisplayed;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
