package com.fahrulrputra.seleksi_sei.common;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) 
public class ApiResponse<T> {
    private LocalDateTime timestamp;
    private String message;
    private String error;
    private T data;
    private boolean success;
    private int status;

    public ApiResponse(String message, T data, boolean success, HttpStatus status) {
        this.timestamp = LocalDateTime.now();
        
        if(success) {
            this.message = message;
        } else {
            this.error = message;
        }

        this.data = data;
        this.success = success;
        this.status = status.value();
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status.value();
    }
}

