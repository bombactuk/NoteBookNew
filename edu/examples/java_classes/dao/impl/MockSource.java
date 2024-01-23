package edu.examples.java_classes.dao.impl;

import java.util.*;

import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.entity.SortingItems;

public class MockSource {
    private static List<Note> notes = new ArrayList<>();

    public static void add(Note n) {
        notes.add(n);
    }

    public static void clear() {
        notes.clear();
    }

    public static void delete(int idDelete) {
        notes.remove(idDelete);
    }

    public static void sortNotesTitle() {
        Collections.sort(notes);
    }

    public static void sortNotesContent() {
        Comparator<Note> contentComparator = new SortingItems();
        notes.sort(contentComparator);
    }

    public static List<Note> get() {
        return notes;
    }

    public static int countOfNotes() {
        return notes.size();
    }
}
