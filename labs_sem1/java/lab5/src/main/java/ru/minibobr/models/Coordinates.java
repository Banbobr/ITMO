package ru.minibobr.models;


import ru.minibobr.models.utility.builders.CoordinatesBuilder;
import ru.minibobr.utility.Validatable;

import java.math.BigDecimal;

/**
 * Модель Coordinates
 */
public final class Coordinates implements Validatable {
    private final int x; //Значение поля должно быть больше -642
    private final long y;

    /**
     * Конструктор Coordinates
     * @param builder {@link CoordinatesBuilder} билдер Coordinates
     */
    public Coordinates(CoordinatesBuilder builder) {
        x = builder.getX();
        y = builder.getY();
    }

    public int getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + "; " + y + ")";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validate() {
        return (x > -642);
    }
}