package com.mecaps.blogApp.Exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
//@AllArgsConstructor
//@Setter
@Builder
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int statusCode;
    private String message;
    private String path;
    private Map<String ,String> errors;
}
