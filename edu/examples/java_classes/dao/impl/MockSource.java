package edu.examples.java_classes.dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
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

    public static void deleteNumberList(int numberInTheListDelete) {
        notes.remove(numberInTheListDelete);
    }

    public static void deleteIdList(int idListDelete) {

        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getId() == idListDelete) {
                notes.remove(i);
            }
        }

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
