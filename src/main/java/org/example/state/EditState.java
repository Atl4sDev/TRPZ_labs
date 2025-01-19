package main.java.org.example.state;

public class EditState implements NotebookState {
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
        System.out.println("Permission denied: You cannot add new notes in edit-only mode.");
    }

    @Override
    public void deleteNote() {
        System.out.println("Permission denied: You cannot delete notes.");
    }
}
