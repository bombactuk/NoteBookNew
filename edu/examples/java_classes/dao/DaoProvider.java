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

public final class DaoProvider {

    private static final DaoProvider INSTANCE = new DaoProvider();

    private DaoProvider() {
        try (BufferedReader reader = new BufferedReader(new FileReader("mubook.txt"))) {

            String[] params;
            Note newNote = new Note();

            // SimpleDateFormat format = new SimpleDateFormat();
            // format.applyPattern("yyyy-MM-dd");
            // Date date;

            String line = reader.readLine();

            while (line != null) {

                params = line.split(" ");

                newNote = new Note();

                newNote.setId(Integer.parseInt(params[1].split(":")[1]));
                newNote.setTitle(params[2].split(":")[1]);
                newNote.setContent(params[3].split(":")[1]);

                // date = format.parse(params[4].split(":")[1]);
                //  newNote.setD(date);

                MockSource.add(newNote);

                line = reader.readLine();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private NoteBookDao noteBookDao = new FileNoteBookDao();

    public NoteBookDao getNoteBookDao() {
        return noteBookDao;
    }

    public static DaoProvider getInstance() {
        return INSTANCE;
    }


}
