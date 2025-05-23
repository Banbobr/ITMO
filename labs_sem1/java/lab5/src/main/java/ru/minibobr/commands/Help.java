package ru.minibobr.commands;

import ru.minibobr.managers.CommandManager;
import ru.minibobr.utility.communication.RequestEntity;
import ru.minibobr.utility.communication.ResponseEntity;

/**
 * Класс команды help
 */
public class Help extends Command {
    private final CommandManager commandManager;

    public Help(CommandManager commandManager) {
        super("help", "вывести справку по доступным командам");
        this.commandManager = commandManager;
    }

    /**
     * {@inheritDoc}
     * @param request запрос для выполнения команды
     * @return {@link ResponseEntity}
     */
    @Override
    public ResponseEntity execute(RequestEntity request) {
        String args = request.getParams();
        try {
            if (!args.isEmpty())
                return ResponseEntity.ok().body(commandManager.getCommands().get(args).getDescription());

        } catch (NullPointerException e) {
            return ResponseEntity.badRequest().body("Команда не найдена");
        }

        StringBuilder builder = new StringBuilder();
        commandManager.getCommands().values().forEach(command -> {
            builder.append(command.getName()).append(" - ").append(command.getDescription()).append("\n");
        });
        return ResponseEntity.ok().body(builder.substring(0, builder.length() - 2));
    }
}

