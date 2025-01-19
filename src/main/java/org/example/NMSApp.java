package main.java.org.example;

import main.java.org.example.entity.Notebook;
import main.java.org.example.state.EditState;
import main.java.org.example.state.FullAccessState;
import main.java.org.example.state.ViewOnlyState;

public class NMSApp {
    public static void main(String[] args) {
        Notebook notebook = new Notebook(new ViewOnlyState());

        System.out.println("\n-- View-Only Mode --");
        notebook.viewNote();
        notebook.editNote();

        System.out.println("\n-- Switching to Edit Mode --");
        notebook.setState(new EditState());
        notebook.viewNote();
        notebook.editNote();
        notebook.addNote();

        System.out.println("\n-- Switching to Full Access Mode --");
        notebook.setState(new FullAccessState());
        notebook.viewNote();
        notebook.addNote();
        notebook.deleteNote();
    }
}
