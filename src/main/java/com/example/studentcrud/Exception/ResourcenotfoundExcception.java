package com.example.studentcrud.Exception;

public class ResourcenotfoundExcception extends RuntimeException {
    public ResourcenotfoundExcception() {
        super();
    }

    public ResourcenotfoundExcception(String message) {
        super(message);
    }
}
