package com.angelHc.Gestion.de.Citas.Medicas.mapper;

import com.angelHc.Gestion.de.Citas.Medicas.dto.DoctorRequest;
import com.angelHc.Gestion.de.Citas.Medicas.dto.DoctorResponse;
import com.angelHc.Gestion.de.Citas.Medicas.entity.DoctorEntity;

public class DoctorMapper {
    public static DoctorResponse mapperDocor(DoctorEntity doctorEntity) {

        if (doctorEntity == null) {return null;}
        return DoctorResponse.builder()
                .id(doctorEntity.getId())
                .nombre(doctorEntity.getNombre())
                .especialidad(doctorEntity.getEspecialidad())
                .activo(doctorEntity.getActivo())
                .build();

    }
}
