package ru.minibobr.commands;

import ru.minibobr.utility.CommandHistoryDequeHandler;
import ru.minibobr.utility.communication.RequestEntity;
import ru.minibobr.utility.communication.ResponseEntity;

public class History extends Command {
    private final CommandHistoryDequeHandler commandHistoryDequeHandler;

    public History(CommandHistoryDequeHandler commandHistoryDequeHandler) {
        super("history", "вывести последние 8 команд (без их аргументов)");
        this.commandHistoryDequeHandler = commandHistoryDequeHandler;
    }

    /**
     * {@inheritDoc}
     * @param request запрос для выполнения команды
     * @return {@link ResponseEntity}
     */
    @Override
    public ResponseEntity execute(RequestEntity request) {
        return ResponseEntity.ok().body(commandHistoryDequeHandler.toString());
    }
}