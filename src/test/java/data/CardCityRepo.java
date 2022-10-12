package data;


import java.util.HashMap;
import java.util.Map;

/** Дата-класс со списками нужных городов (подходящих под требования). И методом отправки рандомного города
 */
public class CardCityRepo {

    private Map<Integer, String> cities = new HashMap<>();

    /**
     * Все административные центры субъектов РФ (13.10.2022)
     * Лучше использовать этот метод в тест-класс, а не классе-генераторе, чтобы операция загрузки не повторялась
     * отдельно для каждого авто-теста
     */
    public void uploadCities() {
        cities.put(1, "Майкоп");
        cities.put(2, "Горно-Алтайск");
        cities.put(3, "Уфа");
        cities.put(4, "Улан-Удэ");
        cities.put(5, "Махачкала");
        cities.put(6, "Донецк");
        cities.put(7, "Магас");
        cities.put(8, "Нальчик");
        cities.put(9, "Элиста");
        cities.put(10, "Черкесск");
        cities.put(11, "Петрозаводск");
        cities.put(12, "Сыктывкар");
        cities.put(13, "Симферополь");
        cities.put(14, "Луганск");
        cities.put(15, "Йошкар-Ола");
        cities.put(16, "Саранск");
        cities.put(17, "Якутск");
        cities.put(18, "Владикавказ");
        cities.put(19, "Казань");
        cities.put(20, "Кызыл");
        cities.put(21, "Ижевск");
        cities.put(22, "Абакан");
        cities.put(23, "Грозный");
        cities.put(24, "Чебоксары");
        cities.put(25, "Барнаул");
        cities.put(26, "Чита");
        cities.put(27, "Петропавловск-Камчатский");
        cities.put(28, "Краснодар");
        cities.put(29, "Красноярск");
        cities.put(30, "Пермь");
        cities.put(31, "Владивосток");
        cities.put(32, "Ставрополь");
        cities.put(33, "Хабаровск");
        cities.put(34, "Благовещенск");
        cities.put(35, "Архангельск");
        cities.put(36, "Астрахань");
        cities.put(37, "Белгород");
        cities.put(38, "Брянск");
        cities.put(39, "Владимир");
        cities.put(40, "Волгоград");
        cities.put(41, "Вологда");
        cities.put(42, "Воронеж");
        cities.put(43, "Мелитополь");
        cities.put(44, "Иваново");
        cities.put(45, "Иркутск");
        cities.put(46, "Калининград");
        cities.put(47, "Калуга");
        cities.put(48, "Кемерово");
        cities.put(49, "Киров");
        cities.put(50, "Кострома");
        cities.put(51, "Курган");
        cities.put(52, "Курск");
        cities.put(53, "Гатчина");
        cities.put(54, "Санкт-Петербург");
        cities.put(55, "Липецк");
        cities.put(56, "Магадан");
        cities.put(57, "Красногорск");
        cities.put(58, "Мурманск");
        cities.put(59, "Нижний Новгород");
        cities.put(60, "Великий Новгород");
        cities.put(61, "Новосибирск");
        cities.put(62, "Омск");
        cities.put(63, "Оренбург");
        cities.put(64, "Орёл");
        cities.put(65, "Пенза");
        cities.put(66, "Псков");
        cities.put(67, "Ростов-на-Дону");
        cities.put(68, "Рязань");
        cities.put(69, "Самара");
        cities.put(70, "Саратов");
        cities.put(71, "Южно-Сахалинск");
        cities.put(72, "Екатеринбург");
        cities.put(73, "Смоленск");
        cities.put(74, "Тамбов");
        cities.put(75, "Тверь");
        cities.put(76, "Томск");
        cities.put(77, "Тула");
        cities.put(78, "Тюмень");
        cities.put(79, "Ульяновск");
        cities.put(80, "Херсон");
        cities.put(81, "Челябинск");
        cities.put(82, "Ярославль");
        cities.put(83, "Москва");
        cities.put(84, "Севастополь");
        cities.put(85, "Биробиджан");
        cities.put(86, "Нарьян-Мар");
        cities.put(87, "Ханты-Мансийск");
        cities.put(88, "Анадырь");
        cities.put(89, "Салехард");
    }

    /**
     * Генерирует рандомный город
     */
    public String getCity() {
        int random = 1 + (int) (Math.random() * 90);
        return cities.get(random);
    }
}
