package com.angelHc.Gestion.de.Citas.Medicas.mapper;

import com.angelHc.Gestion.de.Citas.Medicas.dto.PacienteResponse;
import com.angelHc.Gestion.de.Citas.Medicas.entity.PacienteEntity;

public class PacienteMapper {


    // de PacienteEntity -> PacienteResponse
    public static PacienteResponse toPacienteResponse(PacienteEntity pacienteEntity) {

        if (pacienteEntity == null) return null;

        return PacienteResponse.builder()
                .id(pacienteEntity.getId())
                .nombre(pacienteEntity.getNombre())
                .email(pacienteEntity.getEmail())
                .activo(pacienteEntity.getActivo())
                .build();
    }
    }

