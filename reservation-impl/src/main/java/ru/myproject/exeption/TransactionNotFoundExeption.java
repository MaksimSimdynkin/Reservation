package ru.myproject.exeption;

public class TransactionNotFoundExeption extends RuntimeException {
    public TransactionNotFoundExeption(String message) {
        super(message);
    }
}
