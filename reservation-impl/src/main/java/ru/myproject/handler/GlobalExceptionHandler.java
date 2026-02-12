package ru.myproject.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import ru.myproject.dto.ErrorDto;
import ru.myproject.exeption.ConflictAlreadyRoom;
import ru.myproject.exeption.TransactionNotFoundExeption;

import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConflictAlreadyRoom.class)
    public ResponseEntity<ErrorDto> conflictAlreadyRoom(ConflictAlreadyRoom ex){
        return new ResponseEntity<>(
                ErrorDto.builder()
                .status(String.valueOf(HttpStatus.CONFLICT))
                .code(HttpStatus.CONFLICT.value())
                .message(ex.getMessage())
                .build(),
                HttpStatus.CONFLICT);
    }

    @ExceptionHandler(TransactionNotFoundExeption.class)
    public ResponseEntity<ErrorDto> notFoundExeption(TransactionNotFoundExeption ex){
        return new ResponseEntity<>(ErrorDto.builder()
                .status(String.valueOf(HttpStatus.NOT_FOUND))
                .code(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .build(),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> notValidArgument(MethodArgumentNotValidException ex){
        return new ResponseEntity<>(ErrorDto.builder()
                .status(String.valueOf(HttpStatus.BAD_REQUEST))
                .code(HttpStatus.BAD_REQUEST.value())
                .message(Objects.requireNonNull(ex.getFieldError()).getDefaultMessage())
                .build(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDto> notValidArgument(HttpMessageNotReadableException ex){
        return new ResponseEntity<>(ErrorDto.builder()
                .status(String.valueOf(HttpStatus.BAD_REQUEST))
                .code(HttpStatus.BAD_REQUEST.value())
                .message("Неверный формат JSON. Проверьте значения enum (BUSINESS, CLASSIC, LUXURY)")
                .build(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorDto> notValidArgument(MethodArgumentTypeMismatchException ex){
        return new ResponseEntity<>(ErrorDto.builder()
                .status(String.valueOf(HttpStatus.BAD_REQUEST))
                .code(HttpStatus.BAD_REQUEST.value())
                .message("Неверный формат UUID.")
                .build(),
                HttpStatus.BAD_REQUEST);
    }
}
