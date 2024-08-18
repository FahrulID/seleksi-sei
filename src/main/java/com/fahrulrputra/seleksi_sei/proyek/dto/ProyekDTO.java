package com.fahrulrputra.seleksi_sei.proyek.dto;

import java.time.LocalDateTime;

import com.fahrulrputra.seleksi_sei.proyek.Proyek;

public class ProyekDTO {

    private String namaProyek;
    private String client;
    private LocalDateTime tglMulai;
    private LocalDateTime tglSelesai;
    private String pimpinanProyek;
    private String keterangan;
    private Long lokasiId;

    public ProyekDTO() {
    }

    public ProyekDTO(String namaProyek, String client, LocalDateTime tglMulai, LocalDateTime tglSelesai, String pimpinanProyek, String keterangan, Long lokasiId) {
        this.namaProyek = namaProyek;
        this.client = client;
        this.tglMulai = tglMulai;
        this.tglSelesai = tglSelesai;
        this.pimpinanProyek = pimpinanProyek;
        this.keterangan = keterangan;
        this.lokasiId = lokasiId;
    }

    public String getNamaProyek() {
        return namaProyek;
    }

    public void setNamaProyek(String namaProyek) {
        this.namaProyek = namaProyek;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public LocalDateTime getTglMulai() {
        return tglMulai;
    }

    public void setTglMulai(LocalDateTime tglMulai) {
        this.tglMulai = tglMulai;
    }

    public LocalDateTime getTglSelesai() {
        return tglSelesai;
    }

    public void setTglSelesai(LocalDateTime tglSelesai) {
        this.tglSelesai = tglSelesai;
    }

    public String getPimpinanProyek() {
        return pimpinanProyek;
    }

    public void setPimpinanProyek(String pimpinanProyek) {
        this.pimpinanProyek = pimpinanProyek;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Long getLokasiId() {
        return lokasiId;
    }

    public void setLokasiId(Long lokasiId) {
        this.lokasiId = lokasiId;
    }

    public ProyekDTO convertToDTO(Proyek proyek, Long lokasiId) {
        ProyekDTO dto = new ProyekDTO();
        dto.setNamaProyek(proyek.getNamaProyek());
        dto.setClient(proyek.getClient());
        dto.setTglMulai(proyek.getTglMulai());
        dto.setTglSelesai(proyek.getTglSelesai());
        dto.setPimpinanProyek(proyek.getPimpinanProyek());
        dto.setKeterangan(proyek.getKeterangan());
        dto.setLokasiId(lokasiId);
        return dto;
    }
}
