package com.ey.api.todo.exceptions;

/**
 * @author Neha.Sony
 */

public class BadRequestException extends Exception{
    private static final long serialVersionUID = 1L;

    public BadRequestException(String message) {
        super(message);
    }
}
