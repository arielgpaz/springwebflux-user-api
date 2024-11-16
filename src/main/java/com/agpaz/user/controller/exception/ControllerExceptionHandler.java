package com.agpaz.user.controller.exception;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Mono;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(DuplicateKeyException.class)
    ResponseEntity<Mono<StandardError>> handleDuplicateKeyException(
            DuplicateKeyException e, ServerHttpRequest request) {
        return ResponseEntity.badRequest()
                .body(Mono.just(StandardError.builder()
                                .timestamp(now())
                                .status(BAD_REQUEST.value())
                                .error(BAD_REQUEST.getReasonPhrase())
                                .message(this.verifyDupKey(e.getMessage()))
                                .path(request.getPath().toString())
                        .build()));
    }

    @ExceptionHandler(WebExchangeBindException.class)
    public ResponseEntity<Mono<ValidationError>> handleWebExchangeBindException(
            WebExchangeBindException e, ServerHttpRequest request) {

        ValidationError error = new ValidationError(
                now(), request.getPath().toString(), BAD_REQUEST.value(),
                "Validation error", "Error on atributes validation"
        );

        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            error.addError(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return ResponseEntity.badRequest()
                .body(Mono.just(error));
    }

    private String verifyDupKey(String message) {
        if (message.contains("email dup key")) {
            return "email already registered";
        }
        return "Dup key exception";
    }
}
