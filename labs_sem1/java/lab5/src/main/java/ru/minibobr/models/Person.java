package ru.minibobr.models;


import ru.minibobr.managers.CollectionManager;
import ru.minibobr.models.utility.builders.PersonBuilder;
import ru.minibobr.utility.Validatable;

import java.time.LocalDate;
import java.util.LinkedList;

/**
 * Модель Person
 */
public final class Person implements Validatable {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private LocalDate birthday; //Поле может быть null
    private Long height; //Поле не может быть null, Значение поля должно быть больше 0
    private String passportID; //Значение этого поля должно быть уникальным, Строка не может быть пустой, Поле может быть null
    private Location location; //Поле может быть null

    /**
     * Конструктор Person
     *
     * @param builder {@link PersonBuilder} билдер Person
     */
    public Person(PersonBuilder builder) {
        this.name = builder.getName();
        this.birthday = builder.getBirthday();
        this.height = builder.getHeight();
        this.passportID = builder.getPassportID();
        this.location = builder.getLocation();
    }

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

    @Override
    public String toString() {
        return "Person:" + "name='" + name +
                ", birthday=" + birthday +
                ", height=" + height +
                ", passportID=" + passportID +
                ", location=" + location;
    }

    public static boolean uniquePassportID (String passportID) {
        CollectionManager collectionManager = CollectionManager.getInstance();
        LinkedList<StudyGroup> collection = collectionManager.getCollection();
        for (StudyGroup studyGroup : collection) {
            if (passportID.equals(studyGroup.getGroupAdmin().getPassportID())) {
                return false;
            }
        }
        return true;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validate() {
        if (name == null || name.isEmpty()) return false;
        if (height == null || height <= 0) return false;
        if (!uniquePassportID(passportID)) return false;
        return !passportID.isEmpty();
    }
}