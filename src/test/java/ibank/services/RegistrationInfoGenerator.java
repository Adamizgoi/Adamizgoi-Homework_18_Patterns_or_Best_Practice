package ibank.services;

import com.github.javafaker.Faker;
import ibank.data.RegistrationInfo;

import static java.lang.String.valueOf;

/**
 * Класс генерирует рандомных юзеров по параметрам, указанных в спецификации.
 * Чтобы получить заблокированного юзера, нужно передать в метод generateUser строку "yes"
 */

public class RegistrationInfoGenerator {
    private RegistrationInfo user;
    private Faker faker = new Faker();

    public RegistrationInfo generateUser(String blocked) {
        String name = valueOf(faker.name().username());
        String password = "password";
        String status = "active";
        if (blocked.equals("yes")) {
            status = "blocked";
        }
        return new RegistrationInfo(name, password, status);
    }
}
