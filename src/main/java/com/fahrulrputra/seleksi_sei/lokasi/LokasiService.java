package com.fahrulrputra.seleksi_sei.lokasi;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fahrulrputra.seleksi_sei.lokasi.exception.LokasiNotFoundException;

@Component
public class LokasiService {
    private final LokasiRepository lokasiRepository;

    public LokasiService(LokasiRepository lokasiRepository) {
        this.lokasiRepository = lokasiRepository;
    }
    
    public Lokasi findById(Long id) {
        return lokasiRepository.findById(id).orElseThrow(() -> new LokasiNotFoundException(id));
    }

    public List<Lokasi> findAll() {
        return lokasiRepository.findAll();
    }

    public Lokasi create(Lokasi entity) {
        return lokasiRepository.save(entity);
    }

    public Lokasi update(Long id, Lokasi entity) {
        Lokasi lokasi = lokasiRepository.findById(id).orElseThrow(() -> new LokasiNotFoundException(id));
        lokasi.update(entity);
        return lokasiRepository.save(lokasi);
    }

    public void delete(Long id) {
        Lokasi lokasi = lokasiRepository.findById(id).orElseThrow(() -> new LokasiNotFoundException(id));
        lokasiRepository.delete(lokasi);
    }
}
