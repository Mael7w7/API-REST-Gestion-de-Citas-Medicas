package com.angelHc.Gestion.de.Citas.Medicas.services;

import com.angelHc.Gestion.de.Citas.Medicas.dto.PacienteRequest;
import com.angelHc.Gestion.de.Citas.Medicas.dto.PacienteResponse;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;


public interface IPacienteServices {
        PacienteResponse save (PacienteRequest request);
        Page<PacienteResponse> findAll(Pageable pageable);
        PacienteResponse findById(Long id);
        PacienteResponse update(Long id ,PacienteRequest request);
        void delete(Long id);

}
