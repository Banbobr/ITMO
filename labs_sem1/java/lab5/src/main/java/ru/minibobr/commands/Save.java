package ru.minibobr.commands;

import ru.minibobr.exceptions.PermissionDeniedException;
import ru.minibobr.managers.CollectionManager;
import ru.minibobr.managers.FileManager;
import ru.minibobr.managers.ParseManager;
import ru.minibobr.models.StudyGroup;
import ru.minibobr.utility.communication.RequestEntity;
import ru.minibobr.utility.communication.ResponseEntity;

import java.util.LinkedList;

/**
 * Класс команды Save
 */
public class Save extends Command {
    private final String fileName;
    private final ParseManager parseManager;
    private final FileManager fileManager;
    private final CollectionManager collectionManager;

    public Save(String fileName, ParseManager parseManager, FileManager fileManager, CollectionManager collectionManager) {
        super("save", "сохранить коллекцию в файл");
        this.fileName = fileName;
        this.parseManager = parseManager;
        this.fileManager = fileManager;
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
        try {
            LinkedList<StudyGroup> collection = collectionManager.getCollection();
            String json = parseManager.getJsonFromLinkedList(collection);
            fileManager.write(fileName, json);
        } catch (PermissionDeniedException e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        }
        return ResponseEntity.ok().body("Коллекция сохранена в файл");
    }
}
