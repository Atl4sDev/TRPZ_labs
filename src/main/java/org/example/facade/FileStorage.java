package main.java.org.example.facade;

class FileStorage {
    public void saveFile(String fileId, byte[] content) {
        System.out.println("Збережено файл: " + fileId);
    }
    
    public byte[] getFile(String fileId) {
        return new byte[0];
    }
}