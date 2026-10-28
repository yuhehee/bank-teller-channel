package com.demo.teller.common;

/**
 * Thrown when a business rule is violated.
 * The message key is translated into the request's language by GlobalExceptionHandler.
 */
public class BizException extends RuntimeException {

    private final ErrorCode errorCode;
    private final String messageKey;
    private final Object[] args;

    public BizException(ErrorCode errorCode) {
        this(errorCode, errorCode.code());
    }

    public BizException(ErrorCode errorCode, String messageKey, Object... args) {
        super(messageKey);
        this.errorCode = errorCode;
        this.messageKey = messageKey;
        this.args = args;
    }

    public String getCode() {
        return errorCode.code();
    }

    public String getMessageKey() {
        return messageKey;
    }

    public Object[] getArgs() {
        return args;
    }
}
