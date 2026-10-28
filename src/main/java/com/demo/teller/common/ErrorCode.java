package com.demo.teller.common;

/**
 * Result codes. Messages for each code live in messages*.properties.
 */
public enum ErrorCode {

    // Auth
    LOGIN_FAILED("E001"),

    // Input
    INVALID_INPUT("E010"),

    // Account / transaction
    ACCOUNT_NOT_FOUND("E101"),
    WRONG_PASSWORD("E102"),
    INSUFFICIENT_BALANCE("E103"),
    ACCOUNT_NOT_ACTIVE("E104"),

    // Manager approval (A001 opens the approval popup on the screen)
    APPROVER_AUTH_FAILED("E201"),
    APPROVAL_REQUIRED("A001"),
    APPROVAL_INVALID("E202"),

    // Cancellation
    TX_NOT_FOUND("E301"),
    TX_ALREADY_CANCELED("E302"),
    TX_NOT_TODAY("E303"),
    CANCEL_INSUFFICIENT("E304"),

    // Etc
    NOT_FOUND("E404"),
    SYSTEM_ERROR("E999");

    private final String code;

    ErrorCode(String code) {
        this.code = code;
    }

    public String code() {
        return code;
    }
}
