package card_delivery.util;

import card_delivery.data.CardUserInfo;
import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Map;

import static java.lang.String.valueOf;
import static java.time.format.DateTimeFormatter.ofPattern;
import static java.util.Map.entry;

@UtilityClass
public class DataGenerator {

    @UtilityClass
    public static class DataHelper {

        /**
         * Метод для генерации рандомого пользователя (с параметрами, подходящими под требования)
         */
        public static CardUserInfo createUser() {
            Faker faker = new Faker(new Locale("ru"));
            String name = faker.name().fullName();
            String phone = faker.phoneNumber().phoneNumber();
            String city = getCity();
            return new CardUserInfo(city, name, phone);
        }

        /**
         * Метод для генерации даты
         */
        public static String generateDate(int days) {
            return LocalDate.now().plusDays(days).format(ofPattern("dd.MM.yyyy"));
        }

        /**
         * Генерирует рандомный город (из тех, что подходят под требования)
         */
        public String getCity() {
            // Все административные центры субъектов РФ (13.10.2022)
            Map<Integer, String> cities = Map.<Integer, String>ofEntries(
                    entry(1, "Майкоп"),
                    entry(2, "Горно-Алтайск"),
                    entry(3, "Уфа"),
                    entry(4, "Улан-Удэ"),
                    entry(5, "Махачкала"),
                    entry(6, "Донецк"),
                    entry(7, "Магас"),
                    entry(8, "Нальчик"),
                    entry(9, "Элиста"),
                    entry(10, "Черкесск"),
                    entry(11, "Петрозаводск"),
                    entry(12, "Сыктывкар"),
                    entry(13, "Симферополь"),
                    entry(14, "Луганск"),
                    entry(15, "Йошкар-Ола"),
                    entry(16, "Саранск"),
                    entry(17, "Якутск"),
                    entry(18, "Владикавказ"),
                    entry(19, "Казань"),
                    entry(20, "Кызыл"),
                    entry(21, "Ижевск"),
                    entry(22, "Абакан"),
                    entry(23, "Грозный"),
                    entry(24, "Чебоксары"),
                    entry(25, "Барнаул"),
                    entry(26, "Чита"),
                    entry(27, "Петропавловск-Камчатский"),
                    entry(28, "Краснодар"),
                    entry(29, "Красноярск"),
                    entry(30, "Пермь"),
                    entry(31, "Владивосток"),
                    entry(32, "Ставрополь"),
                    entry(33, "Хабаровск"),
                    entry(34, "Благовещенск"),
                    entry(35, "Архангельск"),
                    entry(36, "Астрахань"),
                    entry(37, "Белгород"),
                    entry(38, "Брянск"),
                    entry(39, "Владимир"),
                    entry(40, "Волгоград"),
                    entry(41, "Вологда"),
                    entry(42, "Воронеж"),
                    entry(43, "Мелитополь"),
                    entry(44, "Иваново"),
                    entry(45, "Иркутск"),
                    entry(46, "Калининград"),
                    entry(47, "Калуга"),
                    entry(48, "Кемерово"),
                    entry(49, "Киров"),
                    entry(50, "Кострома"),
                    entry(51, "Курган"),
                    entry(52, "Курск"),
                    entry(53, "Гатчина"),
                    entry(54, "Санкт-Петербург"),
                    entry(55, "Липецк"),
                    entry(56, "Магадан"),
                    entry(57, "Красногорск"),
                    entry(58, "Мурманск"),
                    entry(59, "Нижний Новгород"),
                    entry(60, "Великий Новгород"),
                    entry(61, "Новосибирск"),
                    entry(62, "Омск"),
                    entry(63, "Оренбург"),
                    entry(64, "Орёл"),
                    entry(65, "Пенза"),
                    entry(66, "Псков"),
                    entry(67, "Ростов-на-Дону"),
                    entry(68, "Рязань"),
                    entry(69, "Самара"),
                    entry(70, "Саратов"),
                    entry(71, "Южно-Сахалинск"),
                    entry(72, "Екатеринбург"),
                    entry(73, "Смоленск"),
                    entry(74, "Тамбов"),
                    entry(75, "Тверь"),
                    entry(76, "Томск"),
                    entry(77, "Тула"),
                    entry(78, "Тюмень"),
                    entry(79, "Ульяновск"),
                    entry(80, "Херсон"),
                    entry(81, "Челябинск"),
                    entry(82, "Ярославль"),
                    entry(83, "Москва"),
                    entry(84, "Севастополь"),
                    entry(85, "Биробиджан"),
                    entry(86, "Нарьян-Мар"),
                    entry(87, "Ханты-Мансийск"),
                    entry(88, "Анадырь"),
                    entry(89, "Салехард")
            );
            int random = 1 + (int) (Math.random() * 90);
            return cities.get(random);
        }
    }
}
