package card_delivery.services;

import static com.codeborne.selenide.Selenide.$;

/** Класс для заполнения полей формы SUT
 */
public class FillFieldsService {

    public void fillAllFields(String a, String b, String c, String d) {
        $("[data-test-id = 'city'] input").setValue(a);
        $("[data-test-id = 'date'] input").setValue(b);
        $("[data-test-id = 'name'] input").setValue(c);
        $("[data-test-id = 'phone'] input").setValue(d);
    }

    public void clickSendButtons() {
        $("[data-test-id = 'agreement'] span").click();
        $("[type='button'].button").click();
    }
}
