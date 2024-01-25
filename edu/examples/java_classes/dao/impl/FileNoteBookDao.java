package edu.examples.java_classes.dao.impl;

import java.io.*;
import java.util.Date;
import java.util.List;

import edu.examples.java_classes.dao.DaoException;
import edu.examples.java_classes.dao.NoteBookDao;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.LogicException;

public class FileNoteBookDao implements NoteBookDao {

    @Override
    public void save(Note n) throws DaoException {

        if (n.getId() == 0) {
            n.setId(MockSource.countOfNotes() + 1);
        }

        if (n.getDate() == null) {
            n.setDate(new Date());
        }

        try {

            MockSource.add(n);

            FileSave.dataStorage(MockSource.get());

        } catch (IOException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public void deleteNumberList(int numberInTheListDelete) throws DaoException {

        try {
            MockSource.deleteNumberList(numberInTheListDelete);

            FileSave.dataStorage(MockSource.get());

        } catch (IOException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public void deleteIdList(int idListDelete) throws DaoException {
        try {
            MockSource.deleteIdList(idListDelete);

            FileSave.dataStorage(MockSource.get());

        } catch (IOException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void clear() throws DaoException {

        try {
            MockSource.clear();

            FileSave.dataStorage(MockSource.get());

        } catch (IOException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public void sortNotesTitle() throws DaoException {

        try {
            MockSource.sortNotesTitle();

            FileSave.dataStorage(MockSource.get());

        } catch (IOException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public void sortNotesContent() throws DaoException {

        try {
            MockSource.sortNotesContent();

            FileSave.dataStorage(MockSource.get());

        } catch (IOException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public List<Note> allNotes() throws DaoException {
        return MockSource.get();
    }

}
