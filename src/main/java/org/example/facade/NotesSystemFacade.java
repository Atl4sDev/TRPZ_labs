package main.java.org.example.facade;

import main.java.org.example.entity.Note;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class NotesSystemFacade {
    private UserManager userManager;
    private FileStorage fileStorage;
    private TagManager tagManager;
    private Map<String, Note> notes;
    
    public NotesSystemFacade() {
        this.userManager = new UserManager();
        this.fileStorage = new FileStorage();
        this.tagManager = new TagManager();
        this.notes = new HashMap<>();
    }

    public String createNote(String userId, String content, String type) {
        String noteId = UUID.randomUUID().toString();
        Note note = new Note(noteId, content, type);
        notes.put(noteId, note);
        System.out.println("Створено нову нотатку: " + noteId);
        return noteId;
    }

    public void addFileToNote(String userId, String noteId, byte[] fileContent) {
        if (userManager.checkAccess(userId, noteId, "edit")) {
            String fileId = UUID.randomUUID().toString();
            fileStorage.saveFile(fileId, fileContent);
            System.out.println("Додано файл до нотатки: " + noteId);
        }
    }

    public void shareNote(String ownerId, String targetUserId, String noteId, String permission) {
        if (userManager.checkAccess(ownerId, noteId, "owner")) {
            userManager.grantAccess(targetUserId, noteId, permission);
        }
    }

    public void addTagToNote(String userId, String noteId, String tag) {
        if (userManager.checkAccess(userId, noteId, "edit")) {
            tagManager.addTag(noteId, tag);
        }
    }
}