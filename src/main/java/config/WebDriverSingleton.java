package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Klasa implementująca driver'a oparta na wzorcu projektowym Singleton. Zastosowanie tego rozwiązania
 * powoduje, że w danej chwili uruchomiona będzie wyłącznie jedna instancja przeglądarki
 **/

public class WebDriverSingleton {
    private static WebDriver driver;

    private WebDriverSingleton() {}

    public static WebDriver getInstance() {
        if (null == driver) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "downloadFiles");
            prefs.put("plugins.plugins_disabled", new String[]{"Chrome PDF Viewer"});
            prefs.put("plugins.always_open_pdf_externally", true);
            options.setExperimentalOption("prefs", prefs);

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quit() {
        if (null != driver) {
            driver.quit();
        }
        driver = null;
    }
}
