package ru.minibobr.commands;

import ru.minibobr.managers.CollectionManager;
import ru.minibobr.models.StudyGroup;
import ru.minibobr.utility.communication.RequestEntity;
import ru.minibobr.utility.communication.ResponseEntity;
import ru.minibobr.utility.io.Console;

import java.util.LinkedList;

public class RemoveHead extends Command {
    private final CollectionManager collectionManager;

    public RemoveHead(CollectionManager collectionManager, Console console) {
        super("remove_head", "вывести первый элемент коллекции и удалить его");
        this.collectionManager = collectionManager;
    }

    /**
     * {@inheritDoc}
     * @param req запрос для выполнения команды
     * @return {@link ResponseEntity}
     */
    @Override
    public ResponseEntity execute(RequestEntity req) {
        try {
            String args = req.getParams();
            if (!args.isEmpty()) return ResponseEntity.badRequest().body("Неверные аргументы");
            LinkedList<StudyGroup> collection = collectionManager.getCollection();
            StudyGroup studyGroup = collection.get(0);
            collection.remove(collection.get(0));
            return ResponseEntity.ok().body(studyGroup.toString() + "Элемент успешно удален");
        } catch (IndexOutOfBoundsException e) {
            return ResponseEntity.badRequest().body("Коллекция пуста");
        }
    }
}
