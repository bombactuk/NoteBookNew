package edu.examples.java_classes.dao;

import edu.examples.java_classes.dao.impl.FileNoteBookDao;
import edu.examples.java_classes.dao.impl.MockSource;
import edu.examples.java_classes.entity.Note;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class DaoProvider {

    private static final DaoProvider INSTANCE;

    static {
        try {
            INSTANCE = new DaoProvider();
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static final String FILE_NAME = "textFile.txt";

    private DaoProvider() throws IOException, ParseException {

        BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));

        String[] params;
        Note newNote;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String line = reader.readLine();

        while (line != null) {

            params = line.split("/");

            newNote = new Note();

            newNote.setId(Integer.parseInt(params[1].split("=")[1]));
            newNote.setTitle(params[2].split("=")[1]);
            newNote.setContent(params[3].split("=")[1]);
            newNote.setDate(format.parse(params[4].split("=")[1]));

            MockSource.add(newNote);

            line = reader.readLine();

        }

        reader.close();

    }

    private NoteBookDao noteBookDao = new FileNoteBookDao();

    public NoteBookDao getNoteBookDao() {
        return noteBookDao;
    }

    public static DaoProvider getInstance() {
        return INSTANCE;
    }

    public static String getFileName() {
        return FILE_NAME;
    }

}
