package ibank.exceptions;

/**
 * Класс ошибок, говорящих, что от сервера пришел не тот статус код, который мы ожидали
 */

public class StatusCodeErrorException extends RuntimeException {

    public StatusCodeErrorException(String msg) {
        super(msg);
    }
}
