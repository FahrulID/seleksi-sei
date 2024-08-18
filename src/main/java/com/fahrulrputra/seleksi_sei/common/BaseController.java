package com.fahrulrputra.seleksi_sei.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {

    protected <U> ResponseEntity<ApiResponse<U>> createSuccessResponse(String message, HttpStatus status) {
        return createSuccessResponse(null, message, status);
    }

    protected <U> ResponseEntity<ApiResponse<U>> createSuccessResponse(U data, String message, HttpStatus status) {
        ApiResponse<U> response = new ApiResponse<>(message, data, true, status);
        return new ResponseEntity<>(response, status);
    }

    protected <U> ResponseEntity<ApiResponse<U>> createErrorResponse(String message, HttpStatus status) {
        ApiResponse<U> response = new ApiResponse<>(message, null, false, status);
        return new ResponseEntity<>(response, status);
    }
}
