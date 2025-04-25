package ru.minibobr.utility;

/**
 * Интерфейс для валидации полей моделей
 */
public interface Validatable {
    /**
     * Валидирует данные полей при составлении модели
     *
     * @return успешность валидации
     */
    boolean validate();
}
