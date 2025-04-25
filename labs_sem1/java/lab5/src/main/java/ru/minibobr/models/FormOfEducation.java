package ru.minibobr.models;

/**
 * Енам форм обученмя
 */
public enum FormOfEducation {
    DISTANCE_EDUCATION,
    FULL_TIME_EDUCATION,
    EVENING_CLASSES;

    /**
     * Получение всех имен енама
     * @return строка с перечислением всех имен енама
     */
    public static String getNames() {
        StringBuilder formOfEducationBuilder = new StringBuilder();
        for (FormOfEducation formOfEducation : values()) {
            formOfEducationBuilder.append(formOfEducation).append(", ");
        }
        return formOfEducationBuilder.substring(0, formOfEducationBuilder.length() - 2);
    }
}