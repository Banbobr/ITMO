package ru.minibobr.models.utility.builders;

import ru.minibobr.models.*;
import ru.minibobr.models.utility.IdGenerator;

import java.util.Date;

/**
 * Билдер для модели StudyGroup
 */
public class StudyGroupBuilder implements Builder<StudyGroup> {
    private int id;
    private String name;
    private Coordinates coordinates;
    private java.util.Date creationDate;
    private Integer studentsCount;
    private Long averageMark;
    private FormOfEducation formOfEducation;
    private Semester semesterEnum;
    private Person groupAdmin;

    public void buildId() {
        IdGenerator idGenerator = IdGenerator.getInstance();
        this.id = idGenerator.generateId();
    }

    public void buildName(String name) {
        if (name == null) throw new IllegalArgumentException("Поле name не может быть null");
        if (name.isEmpty()) throw new IllegalArgumentException("Поле name не может быть пустым");
        this.name = name;
    }

    public void buildCoordinates(Coordinates coordinates) {
        if (coordinates == null) throw new IllegalArgumentException("Поле coordinates не может быть null");
        this.coordinates = coordinates;
    }

    public void buildCreationDate(Date creationDate) {
        if (creationDate == null) throw new IllegalArgumentException("Поле creationDate не может быть null");
        this.creationDate = creationDate;
    }

    public void buildStudentsCount(Integer studentsCount) {
        if (studentsCount == null) throw new IllegalArgumentException("Поле studentsCount не может быть null");
        if (studentsCount <= 0) throw new IllegalArgumentException("Поле studentsCount должно быть больше 0");
        this.studentsCount = studentsCount;
    }

    public void buildAverageMark(Long averageMark) {
        if (averageMark <= 0) throw new IllegalArgumentException("Поле averageMark должно быть больше 0");
        this.averageMark = averageMark;
    }

    public void buildFormOfEducation(FormOfEducation formOfEducation) {
        this.formOfEducation = formOfEducation;
    }

    public void buildSemesterEnum(Semester semesterEnum) {
        this.semesterEnum = semesterEnum;
    }

    public void buildGroupAdmin(Person groupAdmin) {
        this.groupAdmin = groupAdmin;
    }


    public int getId() {
        return id;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public String getName() {
        return name;
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
     * {@inheritDoc}
     */
    @Override
    public StudyGroup build() {
        return new StudyGroup(this);
    }
}
