package ru.minibobr;

import ru.minibobr.commands.*;
import ru.minibobr.managers.*;
import ru.minibobr.models.StudyGroup;
import ru.minibobr.utility.CommandHistoryDequeHandler;
import ru.minibobr.utility.RecursionDequeHandler;
import ru.minibobr.utility.io.Console;
import ru.minibobr.utility.io.StandartConsole;

import java.util.LinkedList;
import java.util.Scanner;


/**
 * Класс для инициализации программы
 */
public class Engine {
    /**
     * Метод, в котором инициализируются все менеджеры и запускается программа
     *
     * @param args аргументы командной строки (имя стартового файла)
     */
    public static void run(String[] args) {
        Console console = new StandartConsole();

        String fileName = System.getenv("FILE_NAME_LAB5");

        FileManager fileManager = new FileManager(console);
        ParseManager parseManager = new ParseManager(console);
        CollectionManager collectionManager = CollectionManager.getInstance();

        String json = fileManager.read(fileName);
        LinkedList<StudyGroup> initCollection = parseManager.getLinkedListFromJson(json);
        collectionManager.setCollection(initCollection);

        Scanner scanner = new Scanner(System.in);
        InputManager.setScanner(scanner);


        CommandManager commandManager = new CommandManager();
        RecursionDequeHandler recursionDequeHandler = RecursionDequeHandler.getInstance();
        ScannerManager scannerManager = new ScannerManager();
        CommandHistoryDequeHandler commandHistoryDequeHandler = new CommandHistoryDequeHandler();
        InputManager inputManager = new InputManager(console, commandManager, recursionDequeHandler, scannerManager, commandHistoryDequeHandler);

        commandManager
                .add("help", new Help(commandManager))
                .add("info", new Info(collectionManager))
                .add("show", new Show(collectionManager))
                .add("add", new Add(collectionManager, scannerManager, console))
                .add("update", new Update(collectionManager, scannerManager, console))
                .add("remove_by_id", new RemoveById(collectionManager))
                .add("clear", new Clear(collectionManager))
                .add("save", new Save(fileName, parseManager, fileManager, collectionManager))
                .add("execute_script", new ExecuteScript(inputManager))
                .add("exit", new Exit())
                .add("remove_head", new RemoveHead(collectionManager, console))
                .add("remove_lower", new RemoveLower(collectionManager, scannerManager, console))
                .add("history", new History(commandHistoryDequeHandler))
                .add("remove_all_by_group_admin", new RemoveAllByGroupAdmin(collectionManager))
                .add("remove_any_by_average_mark", new RemoveAnyByAverageMark(collectionManager))
                .add("count_by_form_of_education", new CountByFormOfEducation(collectionManager));

        inputManager.interactiveRun();
    }
}
