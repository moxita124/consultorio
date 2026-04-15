package com.consultorio.repository;

import com.consultorio.model.CitaMedica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaMedicaRepository extends JpaRepository<CitaMedica, Long> {
}