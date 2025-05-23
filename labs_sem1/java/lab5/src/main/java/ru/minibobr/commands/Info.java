package ru.minibobr.commands;

import ru.minibobr.managers.CollectionManager;
import ru.minibobr.utility.communication.RequestEntity;
import ru.minibobr.utility.communication.ResponseEntity;

/**
 * Класс команды Info
 */
public class Info extends Command {
    private final CollectionManager collectionManager;

    public Info(CollectionManager collectionManager) {
        super("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        this.collectionManager = collectionManager;

    }

    /**
     * {@inheritDoc}
     * @param req запрос для выполнения команды
     * @return {@link ResponseEntity}
     */
    public ResponseEntity execute(RequestEntity req) {
        String args = req.getParams();
        if (!args.isEmpty()) return ResponseEntity.badRequest().body("Неверные аргументы");

        return ResponseEntity.ok().body(collectionManager.getCollectionInfo());
    }
}
