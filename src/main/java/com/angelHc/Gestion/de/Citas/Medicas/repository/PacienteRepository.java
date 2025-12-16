package com.angelHc.Gestion.de.Citas.Medicas.repository;

import com.angelHc.Gestion.de.Citas.Medicas.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {

}
