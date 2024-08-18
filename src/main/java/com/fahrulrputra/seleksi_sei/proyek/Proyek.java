package com.fahrulrputra.seleksi_sei.proyek;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.HashSet;

import org.hibernate.annotations.CreationTimestamp;

import com.fahrulrputra.seleksi_sei.common.BaseEntity;
import com.fahrulrputra.seleksi_sei.lokasi.Lokasi;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "proyek")
public class Proyek extends BaseEntity {

    private String namaProyek;
    private String client;
    private LocalDateTime tglMulai;
    private LocalDateTime tglSelesai;
    private String pimpinanProyek;

    @Column(columnDefinition = "TEXT")
    private String keterangan;
    
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "proyek_lokasi",
        joinColumns = @JoinColumn(name = "proyek_id"),
        inverseJoinColumns = @JoinColumn(name = "lokasi_id")
    )
    private Set<Lokasi> lokasis = new HashSet<>();

    public Proyek() {
    }

    public Proyek(String namaProyek, String client, LocalDateTime tglMulai, LocalDateTime tglSelesai, String pimpinanProyek, String keterangan) {
        this.namaProyek = namaProyek;
        this.client = client;
        this.tglMulai = tglMulai;
        this.tglSelesai = tglSelesai;
        this.pimpinanProyek = pimpinanProyek;
        this.keterangan = keterangan;
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

    public Set<Lokasi> getLokasis() {
        return lokasis;
    }

    public void setLokasis(Set<Lokasi> lokasis) {
        this.lokasis = lokasis;
    }

    public void update(Proyek entity) {
        this.namaProyek = entity.getNamaProyek();
        this.client = entity.getClient();
        this.tglMulai = entity.getTglMulai();
        this.tglSelesai = entity.getTglSelesai();
        this.pimpinanProyek = entity.getPimpinanProyek();
        this.keterangan = entity.getKeterangan();
    }
}
