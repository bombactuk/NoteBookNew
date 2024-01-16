package edu.examples.java_classes.dao;

import java.util.Collections;
import java.util.List;

import edu.examples.java_classes.entity.Note;

public interface NoteBookDao {

    void save(Note n);

    void delete(int idDelete);

    void clear();

    void sortNotesTitle();

    void sortNotesContent();

    List<Note> allNotes();

}
