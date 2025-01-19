package main.java.org.example.entity;

import main.java.org.example.state.NotebookState;

public class Notebook {
    private NotebookState state;

    public Notebook(NotebookState initialState) {
        this.state = initialState;
    }

    public void setState(NotebookState state) {
        this.state = state;
        System.out.println("Notebook state changed.");
    }

    public void viewNote() {
        state.viewNote();
    }

    public void editNote() {
        state.editNote();
    }

    public void addNote() {
        state.addNote();
    }

    public void deleteNote() {
        state.deleteNote();
    }
}
