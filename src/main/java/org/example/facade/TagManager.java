package main.java.org.example.facade;

class TagManager {
    public void addTag(String noteId, String tag) {
        System.out.println("Додано тег '" + tag + "' до нотатки " + noteId);
    }
    
    public void removeTag(String noteId, String tag) {
        System.out.println("Видалено тег '" + tag + "' з нотатки " + noteId);
    }
}
