package edu.examples.java_classes.logic.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.examples.java_classes.dao.DaoException;
import edu.examples.java_classes.dao.DaoProvider;
import edu.examples.java_classes.dao.NoteBookDao;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.NotebookLogic;

public class NotebookLogicImpl implements NotebookLogic {

    private final DaoProvider provider = DaoProvider.getInstance();
    private final NoteBookDao dao = provider.getNoteBookDao();


    @Override
    public void add(Note n) throws LogicException {
        try {
            dao.save(n);
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    @Override
    public void deleteNumberList(int numberInTheListDelete) throws LogicException {
        try {
            dao.deleteNumberList(numberInTheListDelete);
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    @Override
    public void deleteIdList(int idListDelete) throws LogicException {
        try {
            dao.deleteIdList(idListDelete);
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    @Override
    public void clear() throws LogicException {
        try {
            dao.clear();
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    @Override
    public void sortNotesTitle() throws LogicException {
        try {
            dao.sortNotesTitle();
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    @Override
    public void sortNotesContent() throws LogicException {
        try {
            dao.sortNotesContent();
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

}
