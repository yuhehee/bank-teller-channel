package com.demo.teller.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

/**
 * Converts exceptions into ApiResponse so the screen always receives the same JSON shape.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private final Messages messages;

    public GlobalExceptionHandler(Messages messages) {
        this.messages = messages;
    }

    @ExceptionHandler(BizException.class)
    public ApiResponse<Void> handleBiz(BizException e) {
        log.info("Business error [{}] {}", e.getCode(), e.getMessageKey());
        return ApiResponse.fail(e.getCode(), messages.get(e.getMessageKey(), e.getArgs()));
    }

    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<Void> handleNotFound(NoResourceFoundException e) {
        return ApiResponse.fail(ErrorCode.NOT_FOUND.code());
    }

    // Never expose internal details (stack trace, SQL) to the client
    @ExceptionHandler(Exception.class)
    public ApiResponse<Void> handleEtc(Exception e) {
        log.error("Unexpected error", e);
        return ApiResponse.fail(ErrorCode.SYSTEM_ERROR.code());
    }
}
