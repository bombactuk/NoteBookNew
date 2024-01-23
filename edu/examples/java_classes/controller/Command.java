package edu.examples.java_classes.controller;

import edu.examples.java_classes.logic.LogicException;

public interface Command {
    String execute(String request) throws LogicException;
}
