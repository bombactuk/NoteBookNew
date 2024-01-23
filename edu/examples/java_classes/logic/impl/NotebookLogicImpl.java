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

    public void add(Note n) throws LogicException {
        try {
            dao.save(n);
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    @Override
    public void delete(int idDelete) throws LogicException {
        try {
            dao.delete(idDelete);
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


    public void sortNotesTitle() throws LogicException {
        try {
            dao.sortNotesTitle();
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    public void sortNotesContent() throws LogicException {
        try {
            dao.sortNotesContent();
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    public List<Note> find(String text) throws LogicException {

        List<Note> result = new ArrayList<>();

        try {
            List<Note> myNotes = dao.allNotes();
            for (Note n : myNotes) {
                if (isTextInNote(n, text)) {
                    result.add(n);
                }
            }
        } catch (DaoException e) {
            throw new LogicException(e);
        }

        return result;

    }

    private boolean isTextInNote(Note n, String text) {
        return n.getTitle().contains(text) || n.getContent().contains(text);
    }


    public List<Note> find(Date date) throws LogicException {

        List<Note> result = new ArrayList<>();

        try {
            List<Note> myNotes = dao.allNotes();

            for (Note myNote : myNotes) {
                if (myNote.getD().equals(date)) {
                    result.add(myNote);
                }
            }
        } catch (DaoException e) {
            throw new LogicException(e);
        }

        return result;

    }


    public List<Note> allNotes() throws LogicException {
        try {
            return dao.allNotes();
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

}
