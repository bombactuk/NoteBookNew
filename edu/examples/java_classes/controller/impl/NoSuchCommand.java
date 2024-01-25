package edu.examples.java_classes.controller.impl;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.logic.LogicException;

public class NoSuchCommand implements Command {

    @Override
    public String execute(String request) {
        return "Ошибка запроса";
    }

}
