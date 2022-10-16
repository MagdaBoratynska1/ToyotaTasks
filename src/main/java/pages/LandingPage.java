package pages;

import config.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {
    @FindBy(xpath = "//span[text()='Oferta dla firm']/ancestor::div[contains(@class,'cmp-btn')]")
    WebElement OfferForCompaniesButton;
    @FindBy(id = "onetrust-accept-btn-handler")
    WebElement AcceptCookiesButton;

    public LandingPage() {
        super();
    }

    public void GoToOfferForCompanies() {
        OfferForCompaniesButton.click();
    }

    public void AcceptAllCookies() {
        if (AcceptCookiesButton.isDisplayed()) {
            sendToReportAndConsole("Akceptuję pliki cookies");
            AcceptCookiesButton.click();
        }
    }
}
