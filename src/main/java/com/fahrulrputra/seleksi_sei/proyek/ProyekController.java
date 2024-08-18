package com.fahrulrputra.seleksi_sei.proyek;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fahrulrputra.seleksi_sei.common.ApiResponse;
import com.fahrulrputra.seleksi_sei.common.BaseController;
import com.fahrulrputra.seleksi_sei.lokasi.exception.LokasiNotFoundException;
import com.fahrulrputra.seleksi_sei.proyek.dto.ProyekDTO;
import com.fahrulrputra.seleksi_sei.proyek.exception.ProyekNotFoundException;

@RestController
@RequestMapping("/proyek")
public class ProyekController extends BaseController {

    @Autowired
    private ProyekService proyekService;

	@GetMapping({"/", ""})
	public ResponseEntity<ApiResponse<List<Proyek>>> all() {
        try {
            List<Proyek> proyeks = proyekService.findAll();
            return createSuccessResponse(proyeks, "Proyek fetched successfully", HttpStatus.OK);
        } catch (Exception e) {
            return createErrorResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}

    @PostMapping({"/", ""})
    public ResponseEntity<ApiResponse<Proyek>> create(@RequestBody ProyekDTO dto) {
        try {
            Proyek proyeks = proyekService.create(dto);
            return createSuccessResponse(proyeks, "Proyek created successfully", HttpStatus.CREATED);
        } catch (LokasiNotFoundException e) {
            return createErrorResponse(e.getMessage(), e.getStatusCode());
        } catch (Exception e) {
            return createErrorResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Proyek>> one(@PathVariable Long id) {
        try {
            Proyek proyeks = proyekService.findById(id);
            return createSuccessResponse(proyeks, "Proyek fetched successfully", HttpStatus.OK);
        } catch (ProyekNotFoundException e) {
            return createErrorResponse(e.getMessage(), e.getStatusCode());
        } catch (Exception e) {
            return createErrorResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Proyek>> update(@PathVariable Long id, @RequestBody ProyekDTO dto) {
        try {
            Proyek proyek = proyekService.update(id, dto);
            return createSuccessResponse(proyek, "Proyek updated successfully", HttpStatus.OK);
        } catch (ProyekNotFoundException e) {
            return createErrorResponse(e.getMessage(), e.getStatusCode());
        } catch (Exception e) {
            return createErrorResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Proyek>> delete(@PathVariable Long id) {
        try {
            proyekService.delete(id);
            return createSuccessResponse("Proyek deleted successfully", HttpStatus.OK);
        } catch (ProyekNotFoundException e) {
            return createErrorResponse(e.getMessage(), e.getStatusCode());
        } catch (Exception e) {
            return createErrorResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
