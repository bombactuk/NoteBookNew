package edu.examples.java_classes.controller.impl;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;

public class SortNotesCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();

    @Override
    public String execute(String request) throws LogicException {

        String response = null;
        String[] params;
        String sortField;

        params = request.split("\n");
        sortField = params[1];

        switch (sortField) {
            case "Title": {

                try {
                    logic.sortNotesTitle();
                    response = "Записи отсортированы по Title.";
                } catch (RuntimeException e) {
                    throw new LogicException(e);
                }
                break;

            }
            case "Content": {

                try {
                    logic.sortNotesContent();
                    response = "Записи отсортированы по Content.";
                } catch (RuntimeException e) {
                    throw new LogicException(e);
                }
                break;

            }
            default: {
                response = "Сортировка по полю не найдено";
                break;
            }
        }

        return response;

    }

}
