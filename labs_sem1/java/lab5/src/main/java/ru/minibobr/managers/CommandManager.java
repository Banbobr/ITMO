package ru.minibobr.managers;

import ru.minibobr.commands.Command;
import ru.minibobr.utility.io.Console;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс для работы с командами
 */
public class CommandManager {
    private final HashMap<String, Command> commands = new HashMap<>();

    public Map<String, Command> getCommands() {
        return commands;
    }

    /**
     * Добавить команду
     *
     * @param name    имя команды
     * @param command {@link Command} класс команды
     * @return {@link CommandManager}
     */
    public CommandManager add(String name, Command command) {
        commands.put(name, command);
        return this;

    }

    /**
     * Получить команду
     *
     * @param name имя команды
     * @return {@link Command} команда
     */
    public Command getCommand(String name) {
        return commands.get(name);
    }
}