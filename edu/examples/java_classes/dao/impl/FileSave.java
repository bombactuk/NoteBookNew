package edu.examples.java_classes.dao.impl;

import edu.examples.java_classes.dao.DaoProvider;
import edu.examples.java_classes.entity.Note;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.List;

public final class FileSave {

    private FileSave() {
    }

    public static void dataStorage(List<Note> notes) throws IOException {

        FileWriter writer = new FileWriter(DaoProvider.getFileName(), false);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        for (Note s : notes) {
            writer.write("/Id=" + s.getId() +
                    "/Title=" + s.getTitle() +
                    "/Content=" + s.getContent() +
                    "/Date=" + formatter.format(s.getDate()));
            writer.append("\n");
        }

        writer.close();

    }

}
