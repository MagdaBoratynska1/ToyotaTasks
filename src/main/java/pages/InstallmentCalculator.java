package pages;

import config.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InstallmentCalculator extends BasePage {
    @FindBy(xpath = "//iframe[@class='iframe-overlay']")
    WebElement iframeOverlay;

    @FindBy(xpath = "//div[@class='range-group__wrapper']/div[1]/div[@class ='range-group__slide']/div[@data-value='24']")
    WebElement financingPeriod24;
    @FindBy(xpath = "//div[@class='range-group__wrapper']/div[1]/div[@class ='range-group__slide']/div[@data-value='36']")
    WebElement financingPeriod36;
    @FindBy(xpath = "//div[@class='range-group__wrapper']/div[1]/div[@class ='range-group__slide']/div[@data-value='48']")
    WebElement financingPeriod48;

    @FindBy(xpath = "//div[@class='range-group__wrapper']/div[2]/div[@class ='range-group__slide']/div[@data-value='0']")
    WebElement initalFee0;
    @FindBy(xpath = "//div[@class='range-group__wrapper']/div[2]/div[@class ='range-group__slide']/div[@data-value='10']")
    WebElement initalFee10;
    @FindBy(xpath = "//div[@class='range-group__wrapper']/div[2]/div[@class ='range-group__slide']/div[@data-value='20']")
    WebElement initalFee20;
    @FindBy(xpath = "//div[@class='range-group__wrapper']/div[2]/div[@class ='range-group__slide']/div[@data-value='30']")
    WebElement initalFee30;

    @FindBy(xpath = "//div[@class='range-group__wrapper']/div[3]/div[@class ='range-group__slide']/div[@data-value='20']")
    WebElement kilometerLimit20;
    @FindBy(xpath = "//div[@class='range-group__wrapper']/div[3]/div[@class ='range-group__slide']/div[@data-value='30']")
    WebElement kilometerLimit30;
    @FindBy(xpath = "//div[@class='range-group__wrapper']/div[3]/div[@class ='range-group__slide']/div[@data-value='40']")
    WebElement kilometerLimit40;

    @FindBy(xpath = "//div[@class = 'car__buttons']/a[text()='Generuj ofertę w PDF ']")
    WebElement reportGeneratorButton;

    public InstallmentCalculator() {
        super();
    }

    public void selectCar(String car) {
        switchToFrame(iframeOverlay);
        String carXpath = "//div[@class = 'group-car__cars']/div/a/p[text()='" + car + "']";
        findByVarXpath(carXpath).click();
        shortSleep(2);
    }

    public void fillCalculator(int financingPeriod, int initalFee, int kilometerLimit) {

        switch (financingPeriod) {
            case 24:
                financingPeriod24.click();
                break;
            case 36:
                financingPeriod36.click();
                break;
            case 48:
                financingPeriod48.click();
                break;
            default:
                throw new IllegalArgumentException("Wskazano nieobsługiwaną wartość Okresu finansowania: " + financingPeriod);
        }

        switch (initalFee) {
            case 0:
                initalFee0.click();
                break;
            case 10:
                initalFee10.click();
                break;
            case 20:
                initalFee20.click();
                break;
            case 30:
                initalFee30.click();
                break;
            default:
                throw new IllegalArgumentException("Wskazano nieobsługiwaną wartość Opłaty wstępnej: " + initalFee);
        }

        switch (kilometerLimit) {
            case 20:
                kilometerLimit20.click();
                break;
            case 30:
                kilometerLimit30.click();
                break;
            case 40:
                kilometerLimit40.click();
                break;
            default:
                throw new IllegalArgumentException("Wskazano nieobsługiwaną wartość Rocznego limitu kilometrów: " + kilometerLimit);
        }
    }

    public void downloadReport() {
        reportGeneratorButton.click();
        shortSleep(4);
    }
}
