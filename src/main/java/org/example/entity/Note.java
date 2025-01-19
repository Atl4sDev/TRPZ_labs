package main.java.org.example.entity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Note {
    private String id;
    private String content;
    private String type; // "text", "image", "file", "link", "html"

    public Note(String id, String content, String type) {
        this.id = id;
        this.content = content;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

