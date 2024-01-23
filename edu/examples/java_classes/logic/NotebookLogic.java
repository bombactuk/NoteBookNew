package edu.examples.java_classes.logic;

import java.util.Date;
import java.util.List;

import edu.examples.java_classes.entity.Note;

public interface NotebookLogic {

    void add(Note n) throws LogicException;

    void delete(int idDelete) throws LogicException;

    void clear() throws LogicException;

    void sortNotesTitle() throws LogicException;

    void sortNotesContent() throws LogicException;

    List<Note> find(String text) throws LogicException;

    List<Note> find(Date date) throws LogicException;

    List<Note> allNotes() throws LogicException;
}
