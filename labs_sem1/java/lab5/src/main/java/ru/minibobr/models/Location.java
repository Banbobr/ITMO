package ru.minibobr.models;

import ru.minibobr.models.utility.builders.LocationBuilder;
import ru.minibobr.utility.Validatable;

/**
 * Модель Location
 */
public final class Location implements Validatable {
    private Long x; //Поле не может быть null
    private double y;
    private Float z; //Поле не может быть null
    private String name; //Поле не может быть null

    /**
     * Конструктор Location
     * @param builder {@link LocationBuilder} билдер Location
     */
    public Location(LocationBuilder builder) {
        x = builder.getX();
        y = builder.getY();
        z = builder.getZ();
        name = builder.getName();
    }

    public Long getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Float getZ() {
        return z;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Location:" + " x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", name=" + name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validate() {
        if (x == null) return false;
        if (z == null) return false;
        return name != null;
    }
}
