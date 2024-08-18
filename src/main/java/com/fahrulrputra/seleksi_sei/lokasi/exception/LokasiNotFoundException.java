package com.fahrulrputra.seleksi_sei.lokasi.exception;

import org.springframework.http.HttpStatus;

public class LokasiNotFoundException extends RuntimeException {
    private HttpStatus statusCode;

    public LokasiNotFoundException(Long id) {
        super("Lokasi with id " + id + " not found");
        this.statusCode = HttpStatus.NOT_FOUND;
    }
    
    public HttpStatus getStatusCode() {
        return statusCode;
    }
}
