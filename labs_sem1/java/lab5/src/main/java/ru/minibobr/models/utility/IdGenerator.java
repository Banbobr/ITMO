package ru.minibobr.models.utility;

import ru.minibobr.models.StudyGroup;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 * Класс для генерации айди элементов коллекции
 */
public class IdGenerator {
    private static IdGenerator instance;
    private Integer ID = 1;
    private HashSet<Integer> IdList;

    private IdGenerator() {}

    public static IdGenerator getInstance() {
        return instance == null ? instance = new IdGenerator() : instance;
    }

    /**
     * Установить все существующие айдишники в коллекции
     *
     * @param collection коллекция
     */
    public void setIdsFromCollection(LinkedList<StudyGroup> collection) {
        HashSet<Integer> Ids = new HashSet<>();
        for (StudyGroup studyGroup: collection) {
            Integer id = studyGroup.getId();
            Ids.add(id);
        }
        IdList = Ids;
    }

    /**
     * Сгенерировать новый айди
     *
     * @return айди
     */
    public Integer generateId() {
        while (IdList.contains(ID)) {
            ID++;
        }
        IdList.add(ID);
        return ID;
    }
}