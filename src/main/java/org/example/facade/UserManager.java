package main.java.org.example.facade;

class UserManager {
    public void grantAccess(String userId, String noteId, String permission) {
        System.out.println("Надано доступ користувачу " + userId + 
            " до нотатки " + noteId + " з правами: " + permission);
    }
    
    public boolean checkAccess(String userId, String noteId, String permission) {
        // Перевірка прав доступу
        return true;
    }
}