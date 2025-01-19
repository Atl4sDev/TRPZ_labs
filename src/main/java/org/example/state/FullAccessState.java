package main.java.org.example.state;

public class FullAccessState implements NotebookState {
    @Override
    public void viewNote() {
        System.out.println("Viewing the note.");
    }

    @Override
    public void editNote() {
        System.out.println("Editing the note.");
    }

    @Override
    public void addNote() {
        System.out.println("Adding a new note.");
    }

    @Override
    public void deleteNote() {
        System.out.println("Deleting the note.");
    }
}
