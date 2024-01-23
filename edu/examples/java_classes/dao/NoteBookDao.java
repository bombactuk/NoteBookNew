package edu.examples.java_classes.dao;

import java.util.Collections;
import java.util.List;

import edu.examples.java_classes.entity.Note;

public interface NoteBookDao {

    void save(Note n) throws DaoException;

    void delete(int idDelete) throws DaoException;

    void clear() throws DaoException;

    void sortNotesTitle() throws DaoException;

    void sortNotesContent() throws DaoException;

    List<Note> allNotes() throws DaoException;

}
