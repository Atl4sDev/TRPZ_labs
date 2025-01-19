package main.java.org.example.entity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Note {
    private final String text;
    private final String image;
    private final File file;
    private final String htmlContent;
    private final List<String> tags;

    private Note(NoteBuilder builder) {
        this.text = builder.text;
        this.image = builder.image;
        this.file = builder.file;
        this.htmlContent = builder.htmlContent;
        this.tags = builder.tags;
    }

    // Геттери для отримання даних
    public String getText() {
        return text;
    }

    public String getImage() {
        return image;
    }

    public File getFile() {
        return file;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public List<String> getTags() {
        return tags;
    }

    public static class NoteBuilder {
        private String text;
        private String image;
        private File file;
        private String htmlContent;
        private List<String> tags = new ArrayList<>();

        public NoteBuilder setText(String text) {
            this.text = text;
            return this;
        }

        public NoteBuilder addImage(String imagePath) {
            this.image = imagePath;
            return this;
        }

        public NoteBuilder attachFile(File file) {
            this.file = file;
            return this;
        }

        public NoteBuilder addHtmlContent(String htmlContent) {
            this.htmlContent = htmlContent;
            return this;
        }

        public NoteBuilder addTag(String tag) {
            this.tags.add(tag);
            return this;
        }

        public Note build() {
            return new Note(this);
        }
    }
}
