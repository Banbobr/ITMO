package ru.minibobr.commands;

import ru.minibobr.managers.CollectionManager;
import ru.minibobr.models.StudyGroup;
import ru.minibobr.utility.communication.RequestEntity;
import ru.minibobr.utility.communication.ResponseEntity;

import java.util.LinkedList;

public class RemoveAllByGroupAdmin extends Command {
    private final CollectionManager collectionManager;

    public RemoveAllByGroupAdmin(CollectionManager collectionManager) {
        super("remove_all_by_group_admin", "удалить из коллекции все элементы, значение поля name groupAdmin которого эквивалентно заданному");
        this.collectionManager = collectionManager;
    }

    @Override
    public ResponseEntity execute(RequestEntity request) {
        String name = request.getParams();
        LinkedList<StudyGroup> collection = collectionManager.getCollection();
        for (StudyGroup studyGroupFromCollection : collection) {
            if (studyGroupFromCollection.getGroupAdmin().getName().equals(name)) {
                collection.remove(studyGroupFromCollection);
            }
        }
        return ResponseEntity.ok().body("Элементы удалены");
    }
}
