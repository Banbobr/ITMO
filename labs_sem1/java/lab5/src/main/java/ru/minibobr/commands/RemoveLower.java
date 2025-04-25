package ru.minibobr.commands;


import ru.minibobr.managers.CollectionManager;
import ru.minibobr.managers.ScannerManager;
import ru.minibobr.models.StudyGroup;
import ru.minibobr.models.utility.InteractiveStudyGorupCreator;
import ru.minibobr.utility.communication.RequestEntity;
import ru.minibobr.utility.communication.ResponseEntity;
import ru.minibobr.utility.io.Console;

import java.util.LinkedList;

public class RemoveLower extends Command {
    private final CollectionManager collectionManager;
    private final ScannerManager scannerManager;
    private final Console console;

    public RemoveLower(CollectionManager collectionManager, ScannerManager scannerManager, Console console) {
        super("remove_lower {element}", "удалить из коллекции все элементы, меньшие, чем заданный");
        this.collectionManager = collectionManager;
        this.scannerManager = scannerManager;
        this.console = console;
    }

    @Override
    public ResponseEntity execute(RequestEntity request) {
        int countDeleted = 0;
        StudyGroup studyGroup = InteractiveStudyGorupCreator.create(console, scannerManager.getCurrentScanner());
        LinkedList<StudyGroup> collection = collectionManager.getCollection();
        for (StudyGroup studyGroupFromCollection : collection) {
            if (studyGroupFromCollection.compareTo(studyGroup) < 0) {
                countDeleted++;
                collection.remove(studyGroupFromCollection);
            }
        }
        return ResponseEntity.ok().body("Удалено " + Integer.toString(countDeleted) + " элемнтов меньших чем заданный");
    }
}