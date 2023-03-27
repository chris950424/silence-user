package com.silence.auth.infrastructure.base;

import lombok.Data;

import java.io.Serializable;

/**
 * ApiResponse
 *
 * @author leo
 * @version 1.1.0
 * @date 2021/12/27
 */
@Data
public class ApiResponse<T> implements Serializable {
    private static final long serialVersionUID = -1L;
    private String code;
    private String message;
    private T result;

    public ApiResponse() {

    }

    public ApiResponse(String code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public static <T> ApiResponse<T> success() {
        return success(null, null);
    }

    public static <T> ApiResponse<T> success(String message) {
        return success(message, null);
    }

    public static <T> ApiResponse<T> success(T result) {
        return success(null, result);
    }

    public static <T> ApiResponse<T> success(String message, T result) {
        return getInstance("0", message, result);
    }

    public static <T> ApiResponse<T> fail() {
        return fail(null);
    }

    public static <T> ApiResponse<T> fail(String message) {
        return getInstance("9999", message, null);
    }


    private static <T> ApiResponse<T> getInstance(String code, String message, T result) {
        return new ApiResponse<T>(code, message, result);
    }

}
