package main.java.org.example;

import main.java.org.example.entity.Note;
import main.java.org.example.entity.NoteDirector;
import main.java.org.example.entity.Notebook;
import main.java.org.example.state.EditState;
import main.java.org.example.state.FullAccessState;
import main.java.org.example.state.ViewOnlyState;

import java.io.File;

public class NMSApp {
    public static void main(String[] args) {
        Note note = new Note.NoteBuilder()
                .setText("This is a note")
                .addImage("path/to/image.png")
                .attachFile(new File("path/to/file.pdf"))
                .addHtmlContent("<h1>Hello, world!</h1>")
                .addTag("Important")
                .addTag("Work")
                .build();

        System.out.println("Text: " + note.getText());
        System.out.println("Image: " + note.getImage());
        System.out.println("File: " + (note.getFile() != null ? note.getFile().getPath() : "No file attached"));
        System.out.println("HTML Content: " + note.getHtmlContent());
        System.out.println("Tags: " + String.join(", ", note.getTags()));

        NoteDirector director = new NoteDirector(new Note.NoteBuilder());
        Note textNote = director.createTextNote("This is a simple text note.");
        System.out.println("Text Note: " + textNote.getText());
    }
}
