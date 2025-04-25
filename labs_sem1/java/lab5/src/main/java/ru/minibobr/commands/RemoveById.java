package ru.minibobr.commands;

import ru.minibobr.managers.CollectionManager;
import ru.minibobr.utility.communication.RequestEntity;
import ru.minibobr.utility.communication.ResponseEntity;

/**
 * Класс команды RemoveById
 */
public class RemoveById extends Command {
    private final CollectionManager collectionManager;

    public RemoveById(CollectionManager collectionManager) {
        super("remove_by_id id", "обновить значение элемента коллекции, id которого равен заданному");
        this.collectionManager = collectionManager;
    }

    /**
     * {@inheritDoc}
     * @param req запрос для выполнения команды
     * @return {@link ResponseEntity}
     */
    @Override
    public ResponseEntity execute(RequestEntity req) {
        String args = req.getParams();
        if (args.isEmpty()) return ResponseEntity.badRequest().body("Неверные аргументы");
        try {
            Integer id = Integer.parseInt(args);
            if (collectionManager.getById(id) == null) return ResponseEntity.badRequest()
                    .body("Элемента с таким id не существует в коллекции");
            collectionManager.removeElementFromCollection(id);
            return ResponseEntity.ok().body("Элемент успешно удален");
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("ID должен быть Int");
        }
    }
}