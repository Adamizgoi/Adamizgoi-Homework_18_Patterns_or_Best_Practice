package card_delivery.util;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/** Класс для очистки полей формы SUT
 */

@UtilityClass
public class CleanerService {

    @UtilityClass
    public static class Cleaner {
        public static void cleanAll() {
            open("http://localhost:9999/");
            $("[data-test-id = 'city'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME));
            $("[data-test-id = 'city'] input").sendKeys(Keys.DELETE);
            $(By.cssSelector("[data-test-id = 'date'] input")).sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME));
            $(By.cssSelector("[data-test-id = 'date'] input")).sendKeys(Keys.DELETE);
            $("[data-test-id = 'name'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME));
            $("[data-test-id = 'name'] input").sendKeys(Keys.DELETE);
            $("[data-test-id = 'phone'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME));
            $("[data-test-id = 'name'] input").sendKeys(Keys.DELETE);
            $("[data-test-id = 'agreement'] span").click();
        }

        public static void cleanFields() {
            open("http://localhost:9999/");
            $("[data-test-id = 'city'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME));
            $("[data-test-id = 'city'] input").sendKeys(Keys.DELETE);
            $(By.cssSelector("[data-test-id = 'date'] input")).sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME));
            $(By.cssSelector("[data-test-id = 'date'] input")).sendKeys(Keys.DELETE);
            $("[data-test-id = 'name'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME));
            $("[data-test-id = 'name'] input").sendKeys(Keys.DELETE);
            $("[data-test-id = 'phone'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME));
            $("[data-test-id = 'name'] input").sendKeys(Keys.DELETE);
        }

        public static void cleanDate() {
            $(By.cssSelector("[data-test-id = 'date'] input")).sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME));
            $(By.cssSelector("[data-test-id = 'date'] input")).sendKeys(Keys.DELETE);
        }
    }
}
