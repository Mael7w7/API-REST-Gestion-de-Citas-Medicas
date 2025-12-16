package com.angelHc.Gestion.de.Citas.Medicas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DoctorResponse {
    private Long id;

    private String nombre;

    private String especialidad;

    private Boolean activo=true;
}
