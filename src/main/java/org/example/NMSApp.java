package main.java.org.example;

import main.java.org.example.entity.Note;
import main.java.org.example.entity.NoteDirector;
import main.java.org.example.entity.Notebook;
import main.java.org.example.entity.User;
import main.java.org.example.facade.NotesSystemFacade;
import main.java.org.example.state.EditState;
import main.java.org.example.state.FullAccessState;
import main.java.org.example.state.ViewOnlyState;

import java.io.File;

public class NMSApp {
    public static void main(String[] args) {
        NotesSystemFacade noteSystem = new NotesSystemFacade();

        // Створення нової текстової нотатки
        String noteId = noteSystem.createNote("user1", "Важлива нотатка", "text");

        // Додавання тегу
        noteSystem.addTagToNote("user1", noteId, "важливе");

        // Надання доступу іншому користувачу
        noteSystem.shareNote("user1", "user2", noteId, "view");

        // Додавання файлу
        byte[] fileContent = "Тестовий контент файлу".getBytes();
        noteSystem.addFileToNote("user1", noteId, fileContent);
    }
}
