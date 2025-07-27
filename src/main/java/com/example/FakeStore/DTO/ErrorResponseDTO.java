package com.example.FakeStore.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseDTO {
    
    private String status;
    private String message;
    private String error;
    private LocalDateTime timestamp;
    private Map<String, String> errors;
    
    public static ErrorResponseDTO validationError(String message, Map<String, String> errors) {
        return ErrorResponseDTO.builder()
                .status("error")
                .message(message)
                .error("Validation failed")
                .timestamp(LocalDateTime.now())
                .errors(errors)
                .build();
    }
    
    public static ErrorResponseDTO notFoundError(String message) {
        return ErrorResponseDTO.builder()
                .status("error")
                .message(message)
                .error("Resource not found")
                .timestamp(LocalDateTime.now())
                .build();
    }
    
    public static ErrorResponseDTO badRequestError(String message) {
        return ErrorResponseDTO.builder()
                .status("error")
                .message(message)
                .error("Bad request")
                .timestamp(LocalDateTime.now())
                .build();
    }
    
    public static ErrorResponseDTO internalServerError(String message) {
        return ErrorResponseDTO.builder()
                .status("error")
                .message(message)
                .error("Internal server error")
                .timestamp(LocalDateTime.now())
                .build();
    }
} 