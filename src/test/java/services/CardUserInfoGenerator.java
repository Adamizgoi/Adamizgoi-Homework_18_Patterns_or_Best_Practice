package services;

import com.github.javafaker.Faker;
import data.CardCityRepo;
import data.CardUserInfo;

import java.util.Locale;

import static java.lang.String.*;

/** Класс для создания рандомного юзера. При создании объекта класса автоматически скачивается пакет нужных городов (для
 *  генерации рандомного города)
 */
public class CardUserInfoGenerator {

    Faker faker = new Faker(new Locale("ru"));
    CardCityRepo cityFaker =  new CardCityRepo();

    public CardUserInfoGenerator(String upload) {
        if (upload.equals("upload")) {
            cityFaker.uploadCities();
        }
    }

    public CardUserInfo createUser () {
        String name = valueOf(faker.name().fullName());
        String phone = valueOf(faker.phoneNumber().phoneNumber());
        String city = cityFaker.getCity();
        return new CardUserInfo(city, name, phone);
    }
}
