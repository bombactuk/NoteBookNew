package edu.examples.java_classes.dao.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

        if (n.getD() == null) {
            n.setD(new Date());
        }

        MockSource.add(n);

        FileSave.dataStorage(MockSource.get());

    }

    @Override
    public void delete(int idDelete) throws DaoException {

        MockSource.delete(idDelete);

        FileSave.dataStorage(MockSource.get());

    }

    @Override
    public void clear() throws DaoException {

        MockSource.clear();

        FileSave.dataStorage(MockSource.get());

    }

    @Override
    public void sortNotesTitle() throws DaoException {

        MockSource.sortNotesTitle();

        FileSave.dataStorage(MockSource.get());

    }

    @Override
    public void sortNotesContent() throws DaoException {

        MockSource.sortNotesContent();

        FileSave.dataStorage(MockSource.get());

    }

    @Override
    public List<Note> allNotes() throws DaoException {
        return MockSource.get();
    }

}
