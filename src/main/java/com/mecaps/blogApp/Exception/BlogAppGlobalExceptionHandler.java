package com.mecaps.blogApp.Exception;

//import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

// Restcontroller advice
@RestControllerAdvice
public class BlogAppGlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ErrorResponse userNotFound (UserNotFoundException exception,
                                            HttpServletRequest request){

              ErrorResponse errorResponse = ErrorResponse.builder()
                      .timestamp(LocalDateTime.now()).message(exception.getMessage())
                      .statusCode(HttpStatus.NOT_FOUND.value())
                      .path(request.getRequestURI())
                      .build();
        return errorResponse;
    }
    @ExceptionHandler(ResourcrsNotFoundException.class)
    public ErrorResponse resourcesnotfound(ResourcrsNotFoundException resourcrsNotFoundException,
                                           HttpServletRequest request){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now()).message(resourcrsNotFoundException.getMessage())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .path(request.getRequestURI())
                .build();
        return errorResponse;
    }
    /*
    helper method
    public static ErrorResponse helperMethod(RuntimeException exception . HttpsServeletRequest request ) {
     ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now()).message(resourcrsNotFoundException.getMessage())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .path(request.getRequestURI())
                .build();
        return errorResponse;

    }
     */
    @ExceptionHandler(Exception.class)
    public ErrorResponse exceptionError (HttpServletRequest request){
            ErrorResponse errorResponse = ErrorResponse.builder()
                    .timestamp(LocalDateTime.now())
                    .message("something  went wrong..  from server side")
                    .statusCode(HttpStatus.BAD_GATEWAY.value())
                    .path(request.getRequestURI())
                    .build();
        return  errorResponse;
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse methodArgumentNotValidException(
            MethodArgumentNotValidException exception,
            HttpServletRequest request) {

        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .message("Field errors")
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()) //statusCode(HttpStatus.BAD_REQUEST.value())
                .path(request.getRequestURI())
                .errors(errors)
                .build();

        return errorResponse;
    }

    }



