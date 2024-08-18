package com.fahrulrputra.seleksi_sei.proyek.exception;

import org.springframework.http.HttpStatus;

public class ProyekNotFoundException extends RuntimeException {
    private HttpStatus statusCode;

    public ProyekNotFoundException(Long id) {
        super("Proyek with id " + id + " not found");
        this.statusCode = HttpStatus.NOT_FOUND;
    }
    
    public HttpStatus getStatusCode() {
        return statusCode;
    }
}
