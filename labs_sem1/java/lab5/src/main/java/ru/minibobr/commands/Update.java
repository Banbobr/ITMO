package ru.minibobr.commands;

import ru.minibobr.managers.CollectionManager;
import ru.minibobr.managers.ScannerManager;
import ru.minibobr.models.StudyGroup;
import ru.minibobr.models.utility.InteractiveStudyGorupCreator;
import ru.minibobr.utility.communication.RequestEntity;
import ru.minibobr.utility.communication.ResponseEntity;
import ru.minibobr.utility.io.Console;

/**
 * Класс команды Update
 */
public class Update extends Command {
    private final CollectionManager collectionManager;
    private final Console console;
    private final ScannerManager scannerManager;

    public Update(CollectionManager collectionManager, ScannerManager scannerManager, Console console) {
        super("update id", "обновить значение элемента коллекции, id которого равен заданному");
        this.collectionManager = collectionManager;
        this.scannerManager = scannerManager;
        this.console = console;
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
            if (collectionManager.getById(id) == null) return ResponseEntity.badRequest().body("Элемента с таким id не существует в коллекции");
            StudyGroup studyGroup = InteractiveStudyGorupCreator.create(console, scannerManager.getCurrentScanner());
            collectionManager.addElementToCollection(studyGroup);
            return ResponseEntity.ok().body("Элемент успешно перезаписан");

        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("ID должен быть Int");
        }
    }
}