package config;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utility.GlobalMethods;

import java.util.concurrent.TimeUnit;

import static config.WebDriverSingleton.getInstance;
import static config.WebDriverSingleton.quit;

/**
 * Klasa zawierająca podstawę do wszystkich testów. Wskazuje jakie akcje mają się wykonać
 * przed i po wykonaniu metod testowych z bieżącej klasy
 **/

public class TestConfig extends GlobalMethods {


    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = getInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        quit();
        setStepId(1);
    }
}
