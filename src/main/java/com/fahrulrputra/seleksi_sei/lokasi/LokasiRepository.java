package com.fahrulrputra.seleksi_sei.lokasi;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LokasiRepository extends JpaRepository<Lokasi, Long> {}
