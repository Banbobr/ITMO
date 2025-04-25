package ru.minibobr.commands;

import ru.minibobr.managers.CollectionManager;
import ru.minibobr.models.StudyGroup;
import ru.minibobr.utility.communication.RequestEntity;
import ru.minibobr.utility.communication.ResponseEntity;

import java.util.LinkedList;

public class RemoveAnyByAverageMark extends Command {
    private final CollectionManager collectionManager;

    public RemoveAnyByAverageMark(CollectionManager collectionManager) {
        super("remove_any_by_average_mark", "удалить из коллекции один элемент, значение поля averageMark которого эквивалентно заданному");
        this.collectionManager = collectionManager;
    }

    @Override
    public ResponseEntity execute(RequestEntity request) {
        String args = request.getParams();
        if (args.isEmpty()) return ResponseEntity.badRequest().body("Неверные аргументы");
        try {
            Long averageMark = Long.parseLong(args);
            LinkedList<StudyGroup> studyGroups = collectionManager.getCollection();
            for (StudyGroup studyGroup : studyGroups) {
                if (studyGroup.getAverageMark().equals(averageMark)) {
                    collectionManager.removeElementFromCollection(studyGroup.getId());
                    break;
                }
            }
            return ResponseEntity.ok().body("Элемент с AverageMark = " + averageMark + " удален");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Поле должно быть типа Long");
        }
    }
}