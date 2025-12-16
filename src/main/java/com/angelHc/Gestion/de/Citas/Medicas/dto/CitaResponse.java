package com.angelHc.Gestion.de.Citas.Medicas.dto;

import com.angelHc.Gestion.de.Citas.Medicas.entity.Estado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CitaResponse {

    private Long id;
    private LocalDate fecha;
    private LocalTime hora;
    private Estado estado;
}
