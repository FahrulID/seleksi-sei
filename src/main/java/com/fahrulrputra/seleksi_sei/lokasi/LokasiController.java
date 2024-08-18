package com.fahrulrputra.seleksi_sei.lokasi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fahrulrputra.seleksi_sei.common.ApiResponse;
import com.fahrulrputra.seleksi_sei.common.BaseController;
import com.fahrulrputra.seleksi_sei.lokasi.exception.LokasiNotFoundException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/lokasi")
public class LokasiController extends BaseController {

    @Autowired
    private LokasiService lokasiService;

	@GetMapping({"/", ""})
	public ResponseEntity<ApiResponse<List<Lokasi>>> all() {
        try {
            List<Lokasi> lokasis = lokasiService.findAll();
            return createSuccessResponse(lokasis, "Lokasi fetched successfully", HttpStatus.OK);
        } catch (Exception e) {
            return createErrorResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}

    @PostMapping({"/", ""})
    public ResponseEntity<ApiResponse<Lokasi>> create(@RequestBody Lokasi entity) {
        try {
            Lokasi lokasi = lokasiService.create(entity);
            return createSuccessResponse(lokasi, "Lokasi created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return createErrorResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Lokasi>> one(@PathVariable Long id) {
        try {
            Lokasi lokasi = lokasiService.findById(id);
            return createSuccessResponse(lokasi, "Lokasi fetched successfully", HttpStatus.OK);
        } catch (LokasiNotFoundException e) {
            return createErrorResponse(e.getMessage(), e.getStatusCode());
        } catch (Exception e) {
            return createErrorResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Lokasi>> update(@PathVariable Long id, @RequestBody Lokasi entity) {
        try {
            Lokasi lokasi = lokasiService.update(id, entity);
            return createSuccessResponse(lokasi, "Lokasi updated successfully", HttpStatus.OK);
        } catch (LokasiNotFoundException e) {
            return createErrorResponse(e.getMessage(), e.getStatusCode());
        } catch (Exception e) {
            return createErrorResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Lokasi>> delete(@PathVariable Long id) {
        try {
            lokasiService.delete(id);
            return createSuccessResponse("Lokasi deleted successfully", HttpStatus.OK);
        } catch (LokasiNotFoundException e) {
            return createErrorResponse(e.getMessage(), e.getStatusCode());
        } catch (Exception e) {
            return createErrorResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
