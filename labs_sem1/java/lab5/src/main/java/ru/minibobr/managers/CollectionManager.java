package ru.minibobr.managers;

import ru.minibobr.models.StudyGroup;
import ru.minibobr.models.utility.IdGenerator;

import java.util.*;


/**
 * Класс для работы с коллекцией
 */
public class CollectionManager {
    private static CollectionManager instance;
    private LinkedList<StudyGroup> collection;
    private final Date creationDate;

    private CollectionManager() {
        collection = new LinkedList<StudyGroup>();
        creationDate = new Date();
    }

    public static CollectionManager getInstance() {
        return instance == null ? instance = new CollectionManager() : instance;
    }

    public LinkedList<StudyGroup> getCollection() {
        return collection;
    }

    public void setCollection(LinkedList<StudyGroup> collection) {
        this.collection = collection;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Получить данные о коллекции
     *
     * @return данные о коллекции
     */
    public String getCollectionInfo() {
        return "Тип данных: " + collection.getClass().getSimpleName() + "\n" +
                "Дата инициализации: " + creationDate + "\n" +
                "Размер коллекции: " + collection.size();
    }

    @Override
    public String toString() {
        if (collection.isEmpty()) return "Коллекция пуста!";

        StringBuilder sb = new StringBuilder();
        for (StudyGroup studyGroup: collection) {
            sb.append(studyGroup.toString()).append("\n");
        }
        return sb.toString();
    }

    public void addElementToCollection(StudyGroup studyGroup) {
        collection.add(studyGroup);

    }

    public String getElements() {
        return collection.toString();
    }

    public void removeElementFromCollection(Integer id) {
        collection.remove(getById(id));
    }

    public void clearCollection() {
        collection.clear();
    }

    public StudyGroup getById(Integer id) {
        for (StudyGroup studyGroup : collection) {
            if (studyGroup.getId() == id) {
                return studyGroup;
            }
        }
        return null;
    }
}


