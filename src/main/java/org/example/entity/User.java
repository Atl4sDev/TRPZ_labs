package main.java.org.example.entity;

import main.java.org.example.observer.Observer;

public class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("User " + name + " received update: " + message);
    }
}