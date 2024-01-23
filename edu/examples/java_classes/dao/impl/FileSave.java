package edu.examples.java_classes.dao.impl;

import edu.examples.java_classes.dao.DaoException;
import edu.examples.java_classes.entity.Note;

import java.io.*;
import java.util.List;

public class FileSave {

    public static void dataStorage(List<Note> notes) throws DaoException {

        try (FileWriter writer = new FileWriter("mubook.txt", false)) {

            for (Note s : notes) {
                writer.write(s.getId() +
                        " Title:" + s.getTitle() +
                        " Content:" + s.getContent() +
                        " Date:" + s.getD());
                writer.append("\n");
            }

        } catch (IOException e) {
            throw new DaoException(e);
        }

    }

}
