package ru.minibobr.commands;

import ru.minibobr.managers.CollectionManager;
import ru.minibobr.models.FormOfEducation;
import ru.minibobr.models.Semester;
import ru.minibobr.models.StudyGroup;
import ru.minibobr.utility.communication.RequestEntity;
import ru.minibobr.utility.communication.ResponseEntity;

import java.util.LinkedList;

public class CountByFormOfEducation extends Command {
    private final CollectionManager collectionManager;

    public CountByFormOfEducation(CollectionManager collectionManager) {
        super("count_by_form_of_education", "вывести количество элементов, значение поля formOfEducation которых равно заданному");
        this.collectionManager = collectionManager;
    }

    @Override
    public ResponseEntity execute(RequestEntity request) {
        String args = request.getParams();
        if (args.isEmpty()) return ResponseEntity.badRequest().body("Неверные аргументы");
        try {
            int count = 0;
            FormOfEducation formOfEducation = FormOfEducation.valueOf(args);
            LinkedList<StudyGroup> studyGroups = collectionManager.getCollection();
            for (StudyGroup studyGroup : studyGroups) {
                if (studyGroup.getFormOfEducation() == formOfEducation) {
                    count++;
                }
            }
            return ResponseEntity.ok().body(count + " элемента со значением поля formOfEducation равных " + formOfEducation);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Поле должно быть типа FormOfEducation");
        }
    }
}
