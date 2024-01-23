package edu.examples.java_classes.controller.impl;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;

public class AddNoteCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();

    @Override
    public String execute(String request) throws LogicException {

        String response = null;
        String[] params;
        Note newNote;

        try {

            params = request.split("\n");
            newNote = new Note();

            newNote.setTitle(params[1].split("=")[1]);
            newNote.setContent(params[2].split("=")[1]);

            logic.add(newNote);

            response = "Запись сохранена успешно.";

        } catch (RuntimeException e) {
            response = "Запись не сохранена.";
            throw new LogicException(e);
        }

        return response;

    }

}
