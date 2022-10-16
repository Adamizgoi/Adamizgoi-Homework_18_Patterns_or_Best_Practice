package card_delivery.services;

import lombok.experimental.UtilityClass;

import static com.codeborne.selenide.Selenide.$;

/**
 * Класс для заполнения полей формы SUT
 */

@UtilityClass
public class FillFieldsService {

    @UtilityClass
    public static class FillFields {
        public static void fillAllFields(String a, String b, String c, String d) {
            $("[data-test-id = 'city'] input").setValue(a);
            $("[data-test-id = 'date'] input").setValue(b);
            $("[data-test-id = 'name'] input").setValue(c);
            $("[data-test-id = 'phone'] input").setValue(d);
        }

        public static void clickSendButtons() {
            $("[data-test-id = 'agreement'] span").click();
            $("[type='button'].button").click();
        }

        public static void clickReplanButton() {
            $("[data-test-id = 'replan-notification'] button").click();
        }
    }
}
