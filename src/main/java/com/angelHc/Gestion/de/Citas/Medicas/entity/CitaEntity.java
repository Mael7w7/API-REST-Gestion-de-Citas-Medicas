package com.angelHc.Gestion.de.Citas.Medicas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "cita")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class CitaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDate fecha;

    @CreationTimestamp
    private LocalTime hora;
    private Estado estado;

    //relacion de muchos a uno con paciente
    @ManyToOne
    @JoinColumn(name ="id_paciente")
    private PacienteEntity paciente;


    //relacion demuchos a uno con doctores
    @ManyToOne
    @JoinColumn(name="id_doctores")
    private DoctorEntity doctor;





}
