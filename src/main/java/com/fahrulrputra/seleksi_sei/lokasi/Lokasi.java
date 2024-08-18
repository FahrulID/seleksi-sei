package com.fahrulrputra.seleksi_sei.lokasi;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.HashSet;

import org.hibernate.annotations.CreationTimestamp;
import com.fahrulrputra.seleksi_sei.common.BaseEntity;
import com.fahrulrputra.seleksi_sei.proyek.Proyek;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "lokasi")
public class Lokasi extends BaseEntity {

    private String namaLokasi;
    private String negara;
    private String provinsi;
    private String kota;

    @ManyToMany(mappedBy = "lokasis", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Proyek> proyeks = new HashSet<>();

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    public Lokasi() {
    }

    public Lokasi(String namaLokasi, String negara, String provinsi, String kota) {
        this.namaLokasi = namaLokasi;
        this.negara = negara;
        this.provinsi = provinsi;
        this.kota = kota;
    }

    public String getNamaLokasi() {
        return namaLokasi;
    }

    public void setNamaLokasi(String namaLokasi) {
        this.namaLokasi = namaLokasi;
    }

    public String getNegara() {
        return negara;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public void update(Lokasi entity) {
        this.namaLokasi = entity.getNamaLokasi();
        this.negara = entity.getNegara();
        this.provinsi = entity.getProvinsi();
        this.kota = entity.getKota();
    }
}
