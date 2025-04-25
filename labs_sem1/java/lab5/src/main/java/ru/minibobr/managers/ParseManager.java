package ru.minibobr.managers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.minibobr.models.StudyGroup;
import ru.minibobr.models.utility.IdGenerator;
import ru.minibobr.utility.io.Console;

import java.lang.reflect.Type;
import java.util.*;
import java.time.LocalDate;

import com.google.gson.reflect.TypeToken;
import ru.minibobr.managers.utility.adapters.LocalDateAdapter;

/**
 * Класс для парсинга коллекции
 */
public class ParseManager {

    private final Console console;
    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .create();

    public ParseManager(Console console) {
        this.console = console;
    }


    /**
     * Конвертирует json в LinkedList
     *
     * @param json json
     * @return linkedlist - коллекция
     */
    public LinkedList<StudyGroup> getLinkedListFromJson(String json) {
        IdGenerator idGen = IdGenerator.getInstance();
        try {
            LinkedList<StudyGroup> studyGroups = new LinkedList<>();
            if (!json.isEmpty()) {
                Type collectionType = new TypeToken<LinkedList<StudyGroup>>() {
                }.getType();
                studyGroups = gson.fromJson(json, collectionType);
            }
            ArrayList<Integer> IdList = new ArrayList<>();

            Iterator<StudyGroup> iterator = studyGroups.iterator();
            while (iterator.hasNext()) {
                StudyGroup studyGroup = iterator.next();
                Integer studyGroupId = studyGroup.getId();
                if (IdList.contains(studyGroupId) || !studyGroup.validate()) {
                    iterator.remove();
                } else {
                    IdList.add(studyGroupId);
                }
            }
            idGen.setIdsFromCollection(studyGroups);
            return studyGroups;
        } catch (Exception e) {
            console.println("Json-файл повреждён, данные из него не были взяты. Коллекция, с которой вы работаете пуста. Ошибка: %s".formatted(e.toString()));
            return new LinkedList<>();
        }
    }

    /**
     * Конвертирует LinkedList в json
     *
     * @param studyGroups коллекция
     * @return json
     */
    public String getJsonFromLinkedList(LinkedList<StudyGroup> studyGroups) {
        try {
            return gson.toJson(studyGroups);
        } catch (Exception e) {
            console.println(e.toString());
            return "Ошибка парсинга";
        }
    }
}