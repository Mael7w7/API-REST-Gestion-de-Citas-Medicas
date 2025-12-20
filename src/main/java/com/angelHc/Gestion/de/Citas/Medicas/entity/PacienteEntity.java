package com.angelHc.Gestion.de.Citas.Medicas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "paciente")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PacienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @Column(unique = true, nullable = false)
    private String email;

    private Boolean activo=true;

}
