package com.demo.teller.common;

/**
 * Common response body for every API.
 * Business errors are also returned with HTTP 200 and distinguished by resultCode.
 * The message is resolved from resultCode in the request's language just before the response is written.
 */
public record ApiResponse<T>(String resultCode, String message, T data) {
    public static final String OK = "0000";

    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>(OK, null, data);
    }

    public static <T> ApiResponse<T> fail(String code) {
        return new ApiResponse<>(code, null, null);
    }

    public static <T> ApiResponse<T> fail(String code, String message) {
        return new ApiResponse<>(code, message, null);
    }

    public ApiResponse<T> withMessage(String message) {
        return new ApiResponse<>(resultCode, message, data);
    }
}
