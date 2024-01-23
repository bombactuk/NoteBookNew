package edu.examples.java_classes.controller.impl;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;
import edu.examples.java_classes.output.NotebookOutput;

import java.util.List;

public class OutputNoteCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();

    @Override
    public String execute(String request) throws LogicException {

        String response = null;

        List<Note> myNotes = null;
        try {
            myNotes = logic.allNotes();
        } catch (RuntimeException e) {
            throw new LogicException(e);
        }

        NotebookOutput output = new NotebookOutput();

        output.print("all notes", myNotes);

        if (myNotes == null || myNotes.size() <= 0) {
            response = "Нет записей для вывода.";
        } else {
            response = "Вывод успешно прошёл";
        }

        return response;

    }

}
