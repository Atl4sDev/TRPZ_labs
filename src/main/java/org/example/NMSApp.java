package main.java.org.example;

import main.java.org.example.entity.Note;
import main.java.org.example.entity.NoteDirector;
import main.java.org.example.entity.Notebook;
import main.java.org.example.entity.User;
import main.java.org.example.state.EditState;
import main.java.org.example.state.FullAccessState;
import main.java.org.example.state.ViewOnlyState;

import java.io.File;

public class NMSApp {
    public static void main(String[] args) {
        // Create a notebook
        Notebook notebook = new Notebook("Project Notes");

        // Create users
        User user1 = new User("Alice");
        User user2 = new User("Bob");

        // Add users as observers
        notebook.addObserver(user1);
        notebook.addObserver(user2);

        // Perform actions on the notebook
        notebook.addNote("Initial note");
        notebook.addNote("Another note");
        notebook.editNote(0, "Updated initial note");
        notebook.removeNote(1);
    }
}
