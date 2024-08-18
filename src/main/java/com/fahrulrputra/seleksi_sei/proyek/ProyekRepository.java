package com.fahrulrputra.seleksi_sei.proyek;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProyekRepository extends JpaRepository<Proyek, Long> {}
