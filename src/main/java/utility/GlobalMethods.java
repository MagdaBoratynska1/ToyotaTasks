package utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.IOException;
import java.time.Duration;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;

import static config.WebDriverSingleton.getInstance;

/**
 * Klasa zawierająca szereg metod użytych w projekcie
 **/

public class GlobalMethods {
    private static int stepId = 1;
    private static int screenshotId = 1;

    static final int WAIT_TIMEOUT = 20;
    private static WebDriverWait wait = new WebDriverWait(getInstance(), Duration.ofSeconds(WAIT_TIMEOUT));

    public void switchToFrame(WebElement frameElement) {
        getInstance().switchTo().frame(frameElement);
    }

    public static WebElement findByVarXpath(String varXpath) {
        WebElement webElement = getInstance().findElement(By.xpath(varXpath));
        return webElement;
    }

    public boolean isFileDownloaded(String fileName) {
        String downloadPath = System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "downloadFiles";
        String fileNamePattern = "(.*)" + fileName + "(.*)";
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().matches(fileNamePattern)) {
                return true;
            }
        }
        return false;
    }

    public void shortSleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void takeScreenshot() {
        String fileName = "Screenshot_" + screenshotId + "_" + LocalDate.now() + "_" + LocalTime.now().getHour() + "_" + LocalTime.now().getMinute() + ".png";
        File screenshot = ((TakesScreenshot) getInstance()).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshot, new File(".\\test-output\\ScreenShots\\" + fileName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        attachScreenShotToReport(fileName);
        screenshotId++;
    }

    public static void attachScreenShotToReport(String fileName) {
        String path = "<img src=\"ScreenShots\\" + fileName + "\" style=\"width: 45%; height: 45%\"/>";
        Reporter.log(path);
    }

    public static void reportStep(String message) {
        Reporter.log("<b>" + stepId + ". " + message + "</b>");
        System.out.println(stepId + ". " + message);
        stepId++;
    }

    public static void sendToReportAndConsole(String message) {
        Reporter.log("<i>" + "  " + message + "</i>");
        System.out.println("   " + message);
    }

    public void setStepId(int newStepId) {
        stepId = newStepId;
    }

}
