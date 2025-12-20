package com.angelHc.Gestion.de.Citas.Medicas.services.impl;

import com.angelHc.Gestion.de.Citas.Medicas.dto.PacienteRequest;
import com.angelHc.Gestion.de.Citas.Medicas.dto.PacienteResponse;
import com.angelHc.Gestion.de.Citas.Medicas.entity.PacienteEntity;
import com.angelHc.Gestion.de.Citas.Medicas.mapper.PacienteMapper;
import com.angelHc.Gestion.de.Citas.Medicas.repository.PacienteRepository;
import com.angelHc.Gestion.de.Citas.Medicas.services.IPacienteServices;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;


@AllArgsConstructor
@Service
public class PacienteServices implements IPacienteServices {

    private final PacienteRepository repository;

    @Override
    public PacienteResponse save(PacienteRequest request) {
        PacienteEntity pacienteEntity = new PacienteEntity();
        pacienteEntity.setNombre(request.getNombre());
        pacienteEntity.setEmail(request.getEmail());

        var tar = repository.save(pacienteEntity);
        return PacienteMapper.toPacienteResponse(tar);
    }


    @Override
    public Page<PacienteResponse> findAll(Pageable pageable) {
        Page<PacienteEntity> paciente= repository.findAll(pageable);

        return paciente.map(PacienteMapper::toPacienteResponse);


    }

    @Override
    public PacienteResponse findById(Long id) {
        PacienteEntity paciente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe ninguna paciente con id: " + id));

        return PacienteMapper.toPacienteResponse(paciente);

    }

    @Override
    public PacienteResponse update(Long id ,PacienteRequest request) {
        PacienteEntity paciente = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("paciente no encontrado "));

        paciente.setNombre(request.getNombre());
        paciente.setEmail(request.getEmail());

        var tar = repository.save(paciente);

        return PacienteMapper.toPacienteResponse(tar);

    }

    @Override
    public void delete(Long id) {

        PacienteEntity paciente = repository.findById(id)
                        .orElseThrow(()-> new RuntimeException("No existe ninguna paciente con id: " + id));

        paciente.setActivo(false);

         repository.save(paciente);

    }
}
