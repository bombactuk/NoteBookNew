package edu.examples.java_classes.logic.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.examples.java_classes.dao.DaoProvider;
import edu.examples.java_classes.dao.NoteBookDao;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.NotebookLogic;

public class NotebookLogicImpl implements NotebookLogic {

    private final DaoProvider provider = DaoProvider.getInstance();
    private final NoteBookDao dao = provider.getNoteBookDao();

    public void add(Note n) {
        dao.save(n);
    }

    @Override
    public void delete(int idDelete) {
        dao.delete(idDelete);
    }

    @Override
    public void clear() {
        dao.clear();
    }


    public void sortNotesTitle() {
        dao.sortNotesTitle();
    }

    public void sortNotesContent() {
        dao.sortNotesContent();
    }

    public List<Note> find(String text) {

        List<Note> result = new ArrayList<>();

        List<Note> myNotes = dao.allNotes();

        for (Note n : myNotes) {
            if (isTextInNote(n, text)) {
                result.add(n);
            }
        }

        return result;

    }

    private boolean isTextInNote(Note n, String text) {
        return n.getTitle().contains(text) || n.getContent().contains(text);
    }


    public List<Note> find(Date date) {

        List<Note> result = new ArrayList<>();

        List<Note> myNotes = dao.allNotes();

        for (Note myNote : myNotes) {
            if (myNote.getD().equals(date)) {
                result.add(myNote);
            }
        }

        return result;

    }


    public List<Note> allNotes() {
        return dao.allNotes();
    }

}
