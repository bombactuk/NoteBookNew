package edu.examples.java_classes.controller.impl;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;

public class SortNotesCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();

    @Override
    public String execute(String request) {

        String response = null;
        String[] params;
        String sortField;

        params = request.split("\n");
        sortField = params[1];

        switch (sortField) {
            case "Title": {

                logic.sortNotesTitle();
                response = "Записи отсортированы по Title.";
                break;

            }
            case "Content": {

                logic.sortNotesContent();
                response = "Записи отсортированы по Content.";
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
