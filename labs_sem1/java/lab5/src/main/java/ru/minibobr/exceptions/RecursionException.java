package ru.minibobr.exceptions;

/**
 * Исключение рекурсии
 */
public class RecursionException extends Exception {
    public RecursionException(String message) {
        super(message);
    }
}
