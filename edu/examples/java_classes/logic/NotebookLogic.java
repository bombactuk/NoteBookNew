package edu.examples.java_classes.logic;

import java.util.Date;
import java.util.List;

import edu.examples.java_classes.entity.Note;

public interface NotebookLogic {

    void add(Note n);

    void delete(int idDelete);

    void clear();

    void sortNotesTitle();

    void sortNotesContent();

    List<Note> find(String text);

    List<Note> find(Date date);

    List<Note> allNotes();
}
