package ibank.util;

import com.google.gson.Gson;
import ibank.data.RegistrationInfo;
import lombok.experimental.UtilityClass;

/**
 * Класс для перевода дата-класса RegistrationInfo в JSON-формат и наоборот.
 * Для перевода используется библиотека Gson
 */

@UtilityClass
public class RegistrationDto {

    @UtilityClass
    public static class JsonTranslator {
        Gson gson = new Gson();

        public static String toJson(RegistrationInfo user) {
            String json = gson.toJson(user);
            return json;
        }
    }
}
