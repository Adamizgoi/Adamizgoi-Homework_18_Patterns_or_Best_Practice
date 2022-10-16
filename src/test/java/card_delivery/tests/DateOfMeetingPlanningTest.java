package card_delivery.tests;

import card_delivery.data.CardUserInfo;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static card_delivery.services.FillFieldsService.FillFields.*;
import static card_delivery.util.CleanerService.Cleaner.cleanDate;
import static card_delivery.util.CleanerService.Cleaner.cleanFields;
import static card_delivery.util.DataGenerator.DataHelper.createUser;
import static card_delivery.util.DataGenerator.DataHelper.generateDate;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.time.Duration.ofSeconds;

public class DateOfMeetingPlanningTest {

    // Селекторы текста пуш-уведомлений
    String successPlanCssSelector = "[data-test-id = 'success-notification'] .notification__content";
    String replanCssSelector = "[data-test-id = 'replan-notification'] .notification__content";

    // Текст пуш-уведомления
    String textOfReplanNotification = "У вас уже запланирована встреча на другую дату. Перепланировать?";

    @BeforeEach
    protected void setUp() {
        Configuration.headless = true;
        open("http://localhost:9999/");
        cleanDate();
    }

    /** Задача №1
     * Проверяет, что форма отправляется и показывает правильный текст после отправки, если все поля заполнены правильно (согласно требованиям)
     * Требования:
     * Город — один из административных центров субъектов РФ.
     * Дата — не ранее трёх дней с текущей даты.
     * В поле фамилии и имени разрешены только русские буквы, дефисы и пробелы.
     * В поле телефона — только 11 цифр, символ + на первом месте.
     * Флажок согласия должен быть выставлен.
     */

    @Test
    void shouldResendFormWithEqualDataAndGetReplanNotification() {
        CardUserInfo user = createUser();
        fillAllFields(user.getCity(), generateDate(3), user.getName(), user.getPhone());
        clickSendButtons();
        $(By.cssSelector(successPlanCssSelector)).shouldHave(text(generateDate(3)), ofSeconds(15));
        cleanFields();
        fillAllFields(user.getCity(), generateDate(4), user.getName(), user.getPhone());
        clickSendButtons();
        $(By.cssSelector(replanCssSelector)).shouldHave(text(textOfReplanNotification), ofSeconds(15));
        clickReplanButton();
        $(By.cssSelector(successPlanCssSelector)).shouldHave(text(generateDate(4)), ofSeconds(15));
    }
}
