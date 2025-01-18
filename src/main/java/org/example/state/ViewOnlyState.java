package main.java.org.example.state;

public class ViewOnlyState implements NotebookState {
    @Override
    public void viewNote() {
        System.out.println("Viewing the note.");
    }

    @Override
    public void editNote() {
        System.out.println("Permission denied: You can only view the notes.");
    }

    @Override
    public void addNote() {
        System.out.println("Permission denied: You cannot add notes.");
    }

    @Override
    public void deleteNote() {
        System.out.println("Permission denied: You cannot delete notes.");
    }
}
