package util;

import lombok.experimental.UtilityClass;
import java.time.LocalDate;
import static java.time.format.DateTimeFormatter.ofPattern;

/** Класс для генерации нужной даты
 */
@UtilityClass
public class DateGenerationService {

    @UtilityClass
    public static class DateGenerator {
        public static String generateDate(int days) {
            return LocalDate.now().plusDays(days).format(ofPattern("dd.MM.yyyy"));
        }
    }
}
