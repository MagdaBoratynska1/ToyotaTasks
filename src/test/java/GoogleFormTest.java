import config.TestConfig;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.GoogleForm;

import static config.WebDriverSingleton.getInstance;

public class GoogleFormTest extends TestConfig {

    @Parameters({"url"})
    @Test(description = "Wypełnienie i wysłanie Formularza Google - Toyota")
    public void Testy(String url) {
        reportStep("Wchodzę na stronę " + url);
        getInstance().get(url);

        reportStep("Uzupełniam dane formularza wygenerowanymi danymi");
        GoogleForm googleForm = new GoogleForm();
        googleForm.completeFormWithRandomVlues();
        takeScreenshot();

        reportStep("Przyciskam przycisk Prześlij");
        googleForm.submitForm();
        takeScreenshot();

        reportStep("Sprawdzam czy formularz został pomyślnie wysłany");
        Assert.assertTrue(googleForm.formSubmissionConfirmation(), "Błąd wysyłki formularza");

    }
}
