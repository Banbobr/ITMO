package ru.minibobr.models.utility.builders;

import ru.minibobr.models.Location;

/**
 * Билдер для модели Location
 */
public class LocationBuilder implements Builder<Location> {
    private Long x;
    private double y;
    private Float z;
    private String name;

    public void buildX(Long x) {
        if (x == null) throw new IllegalArgumentException("Кооридната X не может быть null");
        this.x = x;
    }

    public void buildY(double y) {
        this.y = y;
    }

    public void buildZ(Float z) {
        if (z == null) throw new IllegalArgumentException("Кооридната Z не может быть null");
        this.z = z;
    }

    public void buildName(String name) {
        if (name == null) throw new IllegalArgumentException("Поле name не может быть null");
        this.name = name;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public Location build() {
        return new Location(this);
    }
}
