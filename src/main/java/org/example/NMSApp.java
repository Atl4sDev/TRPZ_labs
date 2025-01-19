package main.java.org.example;

import main.java.org.example.composite.NotebookComponent;
import main.java.org.example.entity.Note;
import main.java.org.example.entity.NoteDirector;
import main.java.org.example.entity.Notebook;
import main.java.org.example.entity.User;
import main.java.org.example.facade.NotesSystemFacade;
import main.java.org.example.state.EditState;
import main.java.org.example.state.FullAccessState;
import main.java.org.example.state.ViewOnlyState;

import java.io.File;
import java.util.List;

public class NMSApp {
    public static void main(String[] args) {
        // Створюємо кореневий блокнот
        Notebook rootNotebook = new Notebook("Root Notebook");

        // Створюємо підблокнот для роботи
        Notebook workNotebook = new Notebook("Work Notes");

        // Створюємо нотатки
        Note textNote = new Note("Meeting Minutes", "Discuss project deadlines", "text");
        textNote.addTag("work");
        textNote.addTag("important");

        Note linkNote = new Note("Resources", "https://example.com/docs", "link");
        linkNote.addTag("reference");

        // Додаємо нотатки до робочого блокноту
        workNotebook.addComponent(textNote);
        workNotebook.addComponent(linkNote);

        // Створюємо особистий блокнот
        Notebook personalNotebook = new Notebook("Personal Notes");
        Note todoNote = new Note("TODO", "1. Buy groceries\n2. Call mom", "text");
        todoNote.addTag("personal");
        personalNotebook.addComponent(todoNote);

        // Додаємо всі блокноти до кореневого
        rootNotebook.addComponent(workNotebook);
        rootNotebook.addComponent(personalNotebook);

        // Надаємо доступ до робочого блокноту колезі
        workNotebook.grantAccess("colleague1", "view", "edit");

        // Відображаємо всю структуру
        System.out.println("Full Notebook Structure:");
        rootNotebook.display("");

        // Шукаємо всі важливі нотатки
        System.out.println("\nImportant Notes:");
        List<NotebookComponent> importantNotes = rootNotebook.findByTag("important");
        for (NotebookComponent note : importantNotes) {
            note.display("");
        }
    }
}
