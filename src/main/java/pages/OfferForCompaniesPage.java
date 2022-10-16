package pages;

import config.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OfferForCompaniesPage extends BasePage {

    @FindBy(xpath = "//span[text()='KALKULATOR RAT']")
    WebElement InstallmentCalculatorButton;

    public OfferForCompaniesPage() {
        super();
    }

    public void GoToInstallmentCalculator() {
        InstallmentCalculatorButton.click();
        shortSleep(2);
    }
}
