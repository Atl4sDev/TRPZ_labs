package main.java.org.example.composite;

import java.util.List;

public interface NotebookComponent {
    void display(String indent);
    void addComponent(NotebookComponent component) throws UnsupportedOperationException;
    void removeComponent(NotebookComponent component) throws UnsupportedOperationException;
    List<NotebookComponent> getComponents() throws UnsupportedOperationException;
    String getName();
    String getType();
}