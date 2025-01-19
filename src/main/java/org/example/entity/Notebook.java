package main.java.org.example.entity;

import java.util.ArrayList;
import java.util.List;
import main.java.org.example.observer.Observer;
import main.java.org.example.observer.Subject;

public class Notebook implements Subject {
    private String name;
    private List<Observer> observers;
    private List<String> notes;

    public Notebook(String name) {
        this.name = name;
        this.observers = new ArrayList<>();
        this.notes = new ArrayList<>();
    }

    public void addNote(String note) {
        notes.add(note);
        notifyObservers("New note added: " + note);
    }

    public void editNote(int index, String newNote) {
        if (index >= 0 && index < notes.size()) {
            notes.set(index, newNote);
            notifyObservers("Note edited at index " + index + ": " + newNote);
        }
    }

    public void removeNote(int index) {
        if (index >= 0 && index < notes.size()) {
            String removedNote = notes.remove(index);
            notifyObservers("Note removed: " + removedNote);
        }
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}