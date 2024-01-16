package edu.examples.java_classes.dao.impl;

import java.util.Date;
import java.util.List;

import edu.examples.java_classes.dao.NoteBookDao;
import edu.examples.java_classes.entity.Note;

public class FileNoteBookDao implements NoteBookDao {

    @Override
    public void save(Note n) {

        if (n.getId() == 0) {
            n.setId(MockSource.countOfNotes() + 1);
        }

        if (n.getD() == null) {
            n.setD(new Date());
        }

        MockSource.add(n);

    }

    @Override
    public void delete(int idDelete) {
        MockSource.delete(idDelete);
    }

    @Override
    public void clear() {
        MockSource.clear();
    }

    @Override
    public void sortNotesTitle() {
        MockSource.sortNotesTitle();
    }

    @Override
    public void sortNotesContent() {
        MockSource.sortNotesContent();
    }

    @Override
    public List<Note> allNotes() {
        return MockSource.get();
    }

}
