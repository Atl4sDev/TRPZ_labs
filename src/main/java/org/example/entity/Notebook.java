package main.java.org.example.entity;

import java.util.*;

import main.java.org.example.composite.NotebookComponent;
import main.java.org.example.observer.Observer;
import main.java.org.example.observer.Subject;

public class Notebook implements NotebookComponent {
    private String name;
    private List<NotebookComponent> components;
    private Map<String, Set<String>> userPermissions; // userId -> permissions

    public Notebook(String name) {
        this.name = name;
        this.components = new ArrayList<>();
        this.userPermissions = new HashMap<>();
    }

    public void grantAccess(String userId, String... permissions) {
        userPermissions.put(userId, new HashSet<>(Arrays.asList(permissions)));
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "+ Notebook: " + name);
        for (NotebookComponent component : components) {
            component.display(indent + "  ");
        }
    }

    @Override
    public void addComponent(NotebookComponent component) {
        components.add(component);
    }

    @Override
    public void removeComponent(NotebookComponent component) {
        components.remove(component);
    }

    @Override
    public List<NotebookComponent> getComponents() {
        return new ArrayList<>(components);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return "notebook";
    }

    public List<NotebookComponent> findByTag(String tag) {
        List<NotebookComponent> result = new ArrayList<>();
        for (NotebookComponent component : components) {
            if (component instanceof Note) {
                Note note = (Note) component;
                if (note.getTags().contains(tag)) {
                    result.add(note);
                }
            } else if (component instanceof Notebook) {
                Notebook notebook = (Notebook) component;
                result.addAll(notebook.findByTag(tag));
            }
        }
        return result;
    }
}