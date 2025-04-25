package ru.minibobr.models;

import ru.minibobr.models.utility.builders.StudyGroupBuilder;
import ru.minibobr.utility.Validatable;

import java.util.Date;

/**
 * Модель StudyGroup
 */
public final class StudyGroup implements Comparable<StudyGroup>, Validatable {
    private final int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private final String name; //Поле не может быть null, Строка не может быть пустой
    private final Coordinates coordinates; //Поле не может быть null
    private final Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private final Integer studentsCount; //Значение поля должно быть больше 0, Поле не может быть null
    private final Long averageMark; //Значение поля должно быть больше 0, Поле может быть null
    private final FormOfEducation formOfEducation; //Поле может быть null
    private final Semester semesterEnum; //Поле может быть null
    private final Person groupAdmin; //Поле может быть null

    /**
     * Конструктор StudyGroup
     * @param builder {@link StudyGroupBuilder} билдер StudyGroup
     */
    public StudyGroup(StudyGroupBuilder builder) {
        id = builder.getId();
        name = builder.getName();
        coordinates = builder.getCoordinates();
        creationDate = builder.getCreationDate();
        studentsCount = builder.getStudentsCount();
        averageMark = builder.getAverageMark();
        formOfEducation = builder.getFormOfEducation();
        semesterEnum = builder.getSemesterEnum();
        groupAdmin = builder.getGroupAdmin();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Integer getStudentsCount() {
        return studentsCount;
    }

    public Long getAverageMark() {
        return averageMark;
    }

    public FormOfEducation getFormOfEducation() {
        return formOfEducation;
    }

    public Semester getSemesterEnum() {
        return semesterEnum;
    }

    public Person getGroupAdmin() {
        return groupAdmin;
    }

    /**
     * Сравнение двух учебных групп по количеству учеников
     * @param studyGroup группа для сравнения
     * @return результат сравнения
     */
    @Override
    public int compareTo(StudyGroup studyGroup) {
        return Integer.compare(this.studentsCount - studyGroup.getStudentsCount(), 0);
    }

    @Override
    public String toString() {
        return "StudyGroup:" + " id=" + id +
                ", name=" + name +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", studentsCount=" + studentsCount +
                ", averageMark=" + averageMark +
                ", formOfEducation=" + formOfEducation +
                ", semesterEnum=" + semesterEnum +
                ", groupAdmin=" + groupAdmin;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validate() {
        if (id <= 0) return false;
        if (name == null || name.isEmpty()) return false;
        if (coordinates == null || !coordinates.validate()) return false;
        if (creationDate == null) return false;
        if (studentsCount == null || studentsCount <= 0) return false;
        if (averageMark <= 0) return false;
        return groupAdmin.validate();
    }
}
