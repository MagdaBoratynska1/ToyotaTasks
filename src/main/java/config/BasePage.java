package config;

import org.openqa.selenium.support.PageFactory;
import utility.GlobalMethods;

import static config.WebDriverSingleton.getInstance;

/**
 * Klasa podstawowa posiadająca konstruktor, w którym inicjalizowane są elementy danego Page’a
 **/

public class BasePage extends GlobalMethods {
    public BasePage() {
        PageFactory.initElements(getInstance(), this);
        shortSleep(1);
    }
}
