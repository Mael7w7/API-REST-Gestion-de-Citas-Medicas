package com.angelHc.Gestion.de.Citas.Medicas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "doctor")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DoctorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String especialidad;

    private Boolean activo=true;
}
