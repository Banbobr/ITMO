package ru.minibobr.utility;

import ru.minibobr.commands.Command;

import java.util.ArrayDeque;
import java.util.Deque;

public class CommandHistoryDequeHandler {
    private static CommandHistoryDequeHandler instance;
    private final Deque<String> commandDeque = new ArrayDeque<>();
    public static final int AMOUNT_OF_COMMANDS = 8;

    public static CommandHistoryDequeHandler getInstance() {
        return instance == null ? instance = new CommandHistoryDequeHandler() : instance;
    }

    public void addCommandLast(String command) {
        commandDeque.addLast(command);
    }

    public void removeCommandFirst() {
        commandDeque.removeFirst();
    }

    public int countCommand() {
        return commandDeque.size();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("История последних 8 команд:").append("\n");
        for (String command : commandDeque) {
            builder.append(command).append("\n");
        }
        return builder.toString();
    }
}