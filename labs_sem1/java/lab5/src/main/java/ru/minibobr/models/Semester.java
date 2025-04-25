package ru.minibobr.models;

/**
 * Енам семестров
 */
public enum Semester {
    FIRST,
    FOURTH,
    FIFTH,
    SIXTH;

    /**
     * Получение всех имен енама
     * @return строка с перечислением всех имен енама
     */
    public static String getNames() {
        StringBuilder semesterBuilder = new StringBuilder();
        for (Semester semester : values()) {
            semesterBuilder.append(semester).append(", ");
        }
        return semesterBuilder.substring(0, semesterBuilder.length() - 2);
    }
}
