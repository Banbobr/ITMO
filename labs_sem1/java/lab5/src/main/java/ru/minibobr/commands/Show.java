package ru.minibobr.commands;

import ru.minibobr.managers.CollectionManager;
import ru.minibobr.utility.communication.RequestEntity;
import ru.minibobr.utility.communication.ResponseEntity;

/**
 * Класс команды Show
 */
public class Show extends Command {
    private final CollectionManager collectionManager;

    public Show(CollectionManager collectionManager) {
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
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
        if (!args.isEmpty()) return ResponseEntity.badRequest().body("Неверные аргументы");

        return ResponseEntity.ok().body(collectionManager.toString());
    }
}
