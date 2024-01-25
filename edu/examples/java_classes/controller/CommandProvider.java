package edu.examples.java_classes.controller;

import java.util.HashMap;
import java.util.Map;

import edu.examples.java_classes.controller.impl.*;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {

        repository.put(CommandName.ADD, new AddNoteCommand());
        repository.put(CommandName.UPDATE, new UpdateNoteCommand());
        repository.put(CommandName.WRONG_REQUEST, new NoSuchCommand());
        repository.put(CommandName.DELETE, new DeleteNoteCommand());
        repository.put(CommandName.SORT, new SortNotesCommand());
        repository.put(CommandName.CLEAR, new ClearNoteCommand());

    }

    Command getCommand(String name) {

        CommandName commandName = null;
        Command command = null;

        try {

            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);

        } catch (IllegalArgumentException | NullPointerException e) {

            command = repository.get(CommandName.WRONG_REQUEST);

        }

        return command;

    }

}
