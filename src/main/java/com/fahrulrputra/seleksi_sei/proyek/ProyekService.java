package com.fahrulrputra.seleksi_sei.proyek;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fahrulrputra.seleksi_sei.lokasi.Lokasi;
import com.fahrulrputra.seleksi_sei.lokasi.LokasiService;
import com.fahrulrputra.seleksi_sei.proyek.dto.ProyekDTO;
import com.fahrulrputra.seleksi_sei.proyek.exception.ProyekNotFoundException;

@Component
public class ProyekService {
    private final ProyekRepository proyekRepository;
    private final LokasiService lokasiService;

    public ProyekService(ProyekRepository proyekRepository, LokasiService lokasiService) {
        this.proyekRepository = proyekRepository;
        this.lokasiService = lokasiService;
    }

    public Proyek findById(Long id) {
        return proyekRepository.findById(id).orElseThrow(() -> new ProyekNotFoundException(id));
    }

    public List<Proyek> findAll() {
        return proyekRepository.findAll();
    }

    public Proyek create(ProyekDTO dto) {
        Lokasi lokasi = lokasiService.findById(dto.getLokasiId());
        Proyek proyek = new Proyek(dto.getNamaProyek(), dto.getClient(), dto.getTglMulai(), dto.getTglSelesai(), dto.getPimpinanProyek(), dto.getKeterangan());
        proyek.getLokasis().add(lokasi);
        return proyekRepository.save(proyek);
    }

    public Proyek update(Long id, ProyekDTO dto) {
        Proyek proyek = proyekRepository.findById(id).orElseThrow(() -> new ProyekNotFoundException(id));
        proyek.setNamaProyek(dto.getNamaProyek());
        proyek.setClient(dto.getClient());
        proyek.setTglMulai(dto.getTglMulai());
        proyek.setTglSelesai(dto.getTglSelesai());
        proyek.setPimpinanProyek(dto.getPimpinanProyek());
        proyek.setKeterangan(dto.getKeterangan());
        Lokasi lokasi = lokasiService.findById(dto.getLokasiId());
        proyek.getLokasis().clear();
        proyek.getLokasis().add(lokasi);
        return proyekRepository.save(proyek);
    }

    public void delete(Long id) {
        Proyek proyek = proyekRepository.findById(id).orElseThrow(() -> new ProyekNotFoundException(id));
        proyekRepository.delete(proyek);
    }
}
