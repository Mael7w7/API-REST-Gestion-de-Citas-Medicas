package com.angelHc.Gestion.de.Citas.Medicas.repository;

import com.angelHc.Gestion.de.Citas.Medicas.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {

}
