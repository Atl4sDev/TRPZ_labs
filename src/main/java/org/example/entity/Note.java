package main.java.org.example.entity;

import main.java.org.example.composite.NotebookComponent;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Note implements NotebookComponent {
    private String name;
    private String content;
    private String type; // text, image, file, link, html
    private Set<String> tags;

    public Note(String name, String content, String type) {
        this.name = name;
        this.content = content;
        this.type = type;
        this.tags = new HashSet<>();
    }

    public void addTag(String tag) {
        tags.add(tag);
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "- Note: " + name + " (Type: " + type + ")");
        System.out.println(indent + "  Content: " + content);
        if (!tags.isEmpty()) {
            System.out.println(indent + "  Tags: " + String.join(", ", tags));
        }
    }

    @Override
    public void addComponent(NotebookComponent component) {
        throw new UnsupportedOperationException("Cannot add component to a note");
    }

    @Override
    public void removeComponent(NotebookComponent component) {
        throw new UnsupportedOperationException("Cannot remove component from a note");
    }

    @Override
    public List<NotebookComponent> getComponents() {
        throw new UnsupportedOperationException("Note has no components");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }
}

