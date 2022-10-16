package card_delivery.util;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Класс для очистки полей формы SUT
 */

@UtilityClass
public class CleanerService {

    @UtilityClass
    public static class Cleaner {

        /**
         * Метод для очистки всех полей и чек-бокса "Я соглашаюсь..."
         */
        public static void cleanAll() {
            cleanFields();
            $("[data-test-id = 'agreement'] span").click();
        }

        /**
         * Метод для очистки всех полей (не трогает чек-бокс "Я соглашаюсь...")
         */
        public static void cleanFields() {
            open("http://localhost:9999/");
            $("[data-test-id = 'city'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME));
            $("[data-test-id = 'city'] input").sendKeys(Keys.DELETE);
            cleanDate();
            $("[data-test-id = 'name'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME));
            $("[data-test-id = 'name'] input").sendKeys(Keys.DELETE);
            $("[data-test-id = 'phone'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME));
            $("[data-test-id = 'name'] input").sendKeys(Keys.DELETE);
        }

        /**
         * Метод для очистки поля даты
         */
        public static void cleanDate() {
            $(By.cssSelector("[data-test-id = 'date'] input")).sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME));
            $(By.cssSelector("[data-test-id = 'date'] input")).sendKeys(Keys.DELETE);
        }
    }
}
