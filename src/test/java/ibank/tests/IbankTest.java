package ibank.tests;

import com.codeborne.selenide.Configuration;
import ibank.data.RegistrationInfo;
import ibank.services.RegistrationInfoGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static ibank.util.RegistratorUtil.Registrator.*;

public class IbankTest {
    static RegistrationInfoGenerator generator = new RegistrationInfoGenerator();

    // тексты ошибок при регистрации
    String errorText = "Ошибка!";
    String errorTextLogin = "Неверно указан логин или пароль";
    String errorTextEmptyField = "Поле обязательно для заполнения";
    String errorTextPassword = "Неверно указан логин или пароль";

    static RegistrationInfo user; // рандомно генерируемые юзеры
    static RegistrationInfo user1;
    static RegistrationInfo user2;
    static RegistrationInfo user3blocked;

    @BeforeAll
        // создаем и регистрируем в системе новых пользователей (набор уникален для каждого прогона тест-кейсов)
    static void registrationOfUsers() {
        // изменить настройки для rest-assured можно в классе RegistrationUtil
        setUpWebApi();
        user = generator.generateUser("no");
        user1 = generator.generateUser("no");
        user2 = generator.generateUser("no");
        user3blocked = generator.generateUser("yes");
        registrateUser(user);
        registrateUser(user1);
        registrateUser(user2);
        registrateUser(user3blocked);
    }

    @BeforeEach
    void setUp() {
        Configuration.headless=true;
        open("http://localhost:9999/");
    }

    @AfterEach
    void teardown() {
        closeWebDriver();
    }

    @Test
    void shouldLoginIfUserInfoCorrect() {
        $("[data-test-id = 'login'] input").setValue(user.getLogin());
        $("[data-test-id = 'password'] input").setValue(user.getPassword());
        $("[data-test-id = 'action-login']").click();
        $(byText("Личный кабинет")).shouldBe(visible);
    }

    @Test
    void shouldNotLoginIfUserNameIsIncorrect() {
        $("[data-test-id = 'login'] input").setValue(user.getLogin() + "error");
        $("[data-test-id = 'password'] input").setValue(user.getPassword());
        $("[data-test-id = 'action-login']").click();
        $(byText(errorTextLogin)).shouldBe(visible);
    }

    @Test
    void shouldNotLoginIfUserNameIsEmpty() {
        $("[data-test-id = 'password'] input").setValue(user.getPassword());
        $("[data-test-id = 'action-login']").click();
        $("[data-test-id = 'login'] .input__sub").shouldHave(text(errorTextEmptyField));
        $("[data-test-id = 'login'] .input__sub").shouldBe(visible);
    }

    @Test
    void shouldNotLoginIfUserPasswordIsIncorrect() {
        $("[data-test-id = 'login'] input").setValue(user.getLogin());
        $("[data-test-id = 'password'] input").setValue(user.getPassword() + "error");
        $("[data-test-id = 'action-login']").click();
        $(byText(errorTextPassword)).shouldBe(visible);
    }

    @Test
    void shouldNotLoginIfUserPasswordIsEmpty() {
        $("[data-test-id = 'login'] input").setValue(user.getLogin());
        $("[data-test-id = 'action-login']").click();
        $("[data-test-id = 'password'] .input__sub").shouldHave(text(errorTextEmptyField));
        $("[data-test-id = 'password'] .input__sub").shouldBe(visible);
    }
}
