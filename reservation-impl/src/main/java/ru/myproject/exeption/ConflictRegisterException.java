package ru.myproject.exeption;

public class ConflictRegisterException extends RuntimeException {
    public ConflictRegisterException(String message) {
        super(message);
    }
}
