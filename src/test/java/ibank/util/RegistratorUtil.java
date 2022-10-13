package ibank.util;

import ibank.data.RegistrationInfo;
import ibank.exceptions.StatusCodeErrorException;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.experimental.UtilityClass;

import static ibank.util.RegistrationDto.JsonTranslator.toJson;
import static io.restassured.RestAssured.given;

/**
 * Класс регистрирует пользователей в системе. Для регистрации в метод register нужно передать настройки RequestSpecification
 * и информацию о юзере (объект RegistrationInfo)
 */

@UtilityClass
public class RegistratorUtil {

    @UtilityClass
    public static class Registrator {
        private RequestSpecification requestSpec;

        public static void registrateUser(RegistrationInfo user) {
            int statusCode =
                    given().spec(requestSpec)
                            .body(toJson(user))
                            .when()
                            .post("/api/system/users")
                            .statusCode();
            checkStatusCode(statusCode);
        }

        private boolean checkStatusCode(int statusCode) throws RuntimeException {
            if (statusCode != 200) {
                throw new StatusCodeErrorException(
                        "Ошибка при регистрации юзера. Статус код: " + statusCode
                );
            }
            return true;
        }

        public static void setUpWebApi() {
            requestSpec = new RequestSpecBuilder()
                    .setBaseUri("http://localhost")
                    .setPort(7777)
                    .setAccept(ContentType.JSON)
                    .setContentType(ContentType.JSON)
                    .log(LogDetail.ALL)
                    .build();
        }
    }
}
