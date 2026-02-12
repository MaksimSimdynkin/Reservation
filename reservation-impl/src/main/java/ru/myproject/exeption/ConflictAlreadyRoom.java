package ru.myproject.exeption;

public class ConflictAlreadyRoom extends RuntimeException {
    public ConflictAlreadyRoom(String message) {
        super(message);
    }
}
