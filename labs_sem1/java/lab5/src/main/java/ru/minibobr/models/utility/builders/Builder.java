package ru.minibobr.models.utility.builders;

/**
 * Интерфейс для описания билдера
 * @param <T> класс, который будет билдиться
 */
public interface Builder<T> {

    /**
     * Получить построенный класс
     * @return построенный класс
     */
    T build();
}