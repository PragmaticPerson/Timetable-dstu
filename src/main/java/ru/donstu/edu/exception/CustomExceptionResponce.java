package ru.donstu.edu.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class CustomExceptionResponce {
    private HttpStatus status;
    private String message;
    private LocalDateTime timestamp;

    public CustomExceptionResponce() {
        super();
        timestamp = LocalDateTime.now();
    }

    public CustomExceptionResponce(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
        timestamp = LocalDateTime.now();
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

}
