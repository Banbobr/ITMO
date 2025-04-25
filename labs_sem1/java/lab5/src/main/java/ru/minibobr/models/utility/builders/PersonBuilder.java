package ru.minibobr.models.utility.builders;

import ru.minibobr.managers.CollectionManager;
import ru.minibobr.models.Location;
import ru.minibobr.models.Person;

import java.time.LocalDate;

/**
 * Билдер для модели Person
 */
public class PersonBuilder implements Builder<Person> {
    private String name;
    private LocalDate birthday;
    private Long height;
    private String passportID;
    private Location location;

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Long getHeight() {
        return height;
    }

    public String getPassportID() {
        return passportID;
    }

    public Location getLocation() {
        return location;
    }

    public void buildName(String name) {
        if (name == null) throw new IllegalArgumentException("Поле name не может быть null");
        if (name.isEmpty()) throw new IllegalArgumentException("Поле name не может быть пустым");
        this.name = name;
    }

    public void buildBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void buildHeight(Long height) {
        if (height == null) throw new IllegalArgumentException("Поле height не может быть null");
        if (height <= 0) throw new IllegalArgumentException("Поле height не может быть < 0");
        this.height = height;
    }

    public void buildPassportID(String passportID) {
        if (!Person.uniquePassportID(passportID)) throw new IllegalArgumentException("Уже существует такой passportId");
        if (passportID.isEmpty()) throw new IllegalArgumentException("Поле passportID не может быть пустым");
        this.passportID = passportID;
    }

    public void buildLocation(Location location) {
        this.location = location;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person build() {
        return new Person(this);
    }
}