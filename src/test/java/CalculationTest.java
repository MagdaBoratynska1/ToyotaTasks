import config.BasePage;
import config.TestConfig;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.InstallmentCalculator;
import pages.LandingPage;
import pages.OfferForCompaniesPage;

import static config.WebDriverSingleton.getInstance;

public class CalculationTest extends TestConfig {

    @Parameters({"url", "carModel", "financingPeriod", "initalFee", "kilometerLimit"})
    @Test(description = "Generowanie raportu kalkulacji dla Firm")
    public void Testy(String url, String carModel, int financingPeriod, int initalFee, int kilometerLimit) {
        reportStep("Wchodzę na stronę " + url);
        getInstance().get(url);

        LandingPage landingPage = new LandingPage();
        landingPage.AcceptAllCookies();
        takeScreenshot();

        reportStep("Wybieram Oferta dla firm");
        landingPage.GoToOfferForCompanies();
        takeScreenshot();

        reportStep("Wybieram Kalkulator rat");
        OfferForCompaniesPage offerForCompaniesPage = new OfferForCompaniesPage();
        offerForCompaniesPage.GoToInstallmentCalculator();
        takeScreenshot();

        reportStep("Wybieram model samochodu: " + carModel);
        InstallmentCalculator installmentCalculator = new InstallmentCalculator();
        installmentCalculator.selectCar(carModel);

        reportStep("Uzupełniam dane kalkulatora");
        installmentCalculator.fillCalculator(financingPeriod, initalFee, kilometerLimit);
        takeScreenshot();

        reportStep("Generuję ofertę PDF");
        installmentCalculator.downloadReport();

        reportStep("Sprawdzam, czy PDF został pomyślnie pobrany");
        Boolean fileDownloadCheck = isFileDownloaded("Oferta_KINTO_ONE");
        Assert.assertTrue(fileDownloadCheck, "Załącznik nie został wysłany");
    }
}
