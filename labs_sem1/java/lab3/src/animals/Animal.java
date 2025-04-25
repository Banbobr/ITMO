package animals;

import enums.Location;

import java.util.Objects;

public abstract class Animal {
    protected String name;
    protected Location location;

    public Animal(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return this.name;
    }

    public String getLocation() {
        return this.location.getTitle();
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public abstract void speak(String speach);

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return this.getName();
    }
}