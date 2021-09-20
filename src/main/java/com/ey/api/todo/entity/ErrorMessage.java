package com.ey.api.todo.entity;


import lombok.Data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Neha.Sony
 */

@Data
public class ErrorMessage {

    private String message;

    private Map<String, String> errorMetadata;

    public ErrorMessage(Exception e) {
        this.message = e.getMessage();
        Map<String, String> errorMetadata = new HashMap<>();
        if (e.getCause() != null) {
            errorMetadata.put(e.getCause().getMessage(), e.getCause().getCause() != null ? e.getCause().getCause().getMessage() : Arrays.toString(e.getStackTrace()));
        }
        this.errorMetadata = errorMetadata;
    }
}
