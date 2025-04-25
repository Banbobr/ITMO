package ru.minibobr.models.utility.builders;

import ru.minibobr.models.Coordinates;

/**
 * Билдер для модели Coordinates
 */
public class CoordinatesBuilder implements Builder<Coordinates> {
    private int x;
    private long y;

    public int getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public void buildX(int x) {
        if (x <= -642) throw new IllegalArgumentException("Координата X должна быть > -642");
        this.x = x;
    }


    public void buildY(long y) {
        this.y = y;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Coordinates build() {
        return new Coordinates(this);
    }

}
