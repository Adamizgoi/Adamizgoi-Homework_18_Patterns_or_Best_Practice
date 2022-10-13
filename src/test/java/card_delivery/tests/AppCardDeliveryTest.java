package card_delivery.tests;

import card_delivery.data.CardUserInfo;
import card_delivery.services.CardUserInfoGenerator;
import card_delivery.services.FillFieldsService;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static card_delivery.util.CleanerService.Cleaner.cleanDate;
import static card_delivery.util.CleanerService.Cleaner.cleanFields;
import static card_delivery.util.DateGenerationService.DateGenerator.generateDate;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.time.Duration.ofSeconds;

public class AppCardDeliveryTest {

    //Ключевое слово "upload" говорит генератору при создании сразу скачать список городов, подходящих под требования
    CardUserInfoGenerator generator = new CardUserInfoGenerator("upload");

    //Бот для заполнения формы. Не делала класс утилитным, чтобы синтаксис тестов подсвечивался и был понятным
    FillFieldsService bot = new FillFieldsService();

    @BeforeEach
    protected void setUp() {
        Configuration.headless = true;
        open("http://localhost:9999/");
        cleanDate();
    }

    @AfterEach
    void teardown() {
        Selenide.closeWebDriver();
    }

    /** Задача №1
     */

    /**
     * Проверяет, что форма отправляется и показывает правильный текст после отправки, если все поля заполнены правильно (согласно требованиям)
     * <p>
     * Требования:
     * Город — один из административных центров субъектов РФ.
     * Дата — не ранее трёх дней с текущей даты.
     * В поле фамилии и имени разрешены только русские буквы, дефисы и пробелы.
     * В поле телефона — только 11 цифр, символ + на первом месте.
     * Флажок согласия должен быть выставлен.
     */

    @Test
    void shouldResendFormWithEqualDataAndGetReplanNotification() {
        CardUserInfo user = generator.createUser();
        bot.fillAllFields(user.getCity(), generateDate(3), user.getName(), user.getPhone());
        bot.clickSendButtons();
        cleanFields();
        bot.fillAllFields(user.getCity(), generateDate(4), user.getName(), user.getPhone());
        bot.clickSendButtons();
        $("[data-test-id = 'replan-notification'] .notification__content").shouldBe(visible, ofSeconds(15));
    }
}
