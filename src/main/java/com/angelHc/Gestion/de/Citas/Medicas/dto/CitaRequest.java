package com.angelHc.Gestion.de.Citas.Medicas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CitaRequest {

    private Long citaId;
    private Long doctorId;
    private Long pacienteId;

}
