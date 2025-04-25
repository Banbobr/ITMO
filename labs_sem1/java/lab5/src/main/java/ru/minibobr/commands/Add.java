package ru.minibobr.commands;

import ru.minibobr.managers.CollectionManager;
import ru.minibobr.managers.ScannerManager;
import ru.minibobr.models.StudyGroup;
import ru.minibobr.models.utility.InteractiveStudyGorupCreator;
import ru.minibobr.utility.communication.RequestEntity;
import ru.minibobr.utility.communication.ResponseEntity;
import ru.minibobr.utility.io.Console;

public class Add extends Command {
    private final CollectionManager collectionManager;
    private final ScannerManager scannerManager;
    private final Console console;

    public Add(CollectionManager collectionManager, ScannerManager scannerManager, Console console) {
        super("add {element}", "добавить новый элемент в коллекцию");
        this.collectionManager = collectionManager;
        this.scannerManager = scannerManager;
        this.console = console;
    }

    @Override
    public ResponseEntity execute(RequestEntity request) {
        StudyGroup studyGroup = InteractiveStudyGorupCreator.create(console, scannerManager.getCurrentScanner());
        collectionManager.addElementToCollection(studyGroup);
        return ResponseEntity.ok().body("Элемент добавлен в коллекцию");
    }
}
