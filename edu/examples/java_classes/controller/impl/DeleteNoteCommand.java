package edu.examples.java_classes.controller.impl;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;

import java.text.ParseException;

public class DeleteNoteCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();


    @Override
    public String execute(String request) throws LogicException {

        String response = null;
        String[] params;
        int idDelete;

        params = request.split("\n");

        try {
            idDelete = Integer.parseInt(params[1].split("=")[1].replace("id=", "")) - 1;

            logic.delete(idDelete);

            response = "Запись удалена успешно.";

        } catch (RuntimeException e) {
            response = "Запись не удалена.";
            throw new LogicException(e);
        }

        return response;

    }
}
