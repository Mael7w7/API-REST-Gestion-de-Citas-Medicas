package com.angelHc.Gestion.de.Citas.Medicas.controller;

import com.angelHc.Gestion.de.Citas.Medicas.dto.PacienteRequest;
import com.angelHc.Gestion.de.Citas.Medicas.dto.PacienteResponse;
import com.angelHc.Gestion.de.Citas.Medicas.services.impl.PacienteServices;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@AllArgsConstructor

public class PacienteController {

    private final PacienteServices pacienteServices;

    //Crear un nuevo paciente
    @PostMapping
    public ResponseEntity<PacienteResponse> savePaciente(@RequestBody PacienteRequest pacienteRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteServices.save(pacienteRequest));
    }

    //listar todos los pacientes
    @GetMapping
    public ResponseEntity<Page<PacienteResponse>> getAllPacientes( @RequestParam(defaultValue = "0") int page,
                                                                   @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(pacienteServices.findAll(pageable));
    }
    //Listar por id
    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponse> getPacienteById(@PathVariable Long id) {
        return  ResponseEntity.ok(pacienteServices.findById(id));
    }

    //Actualizar por id

    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponse> updatePaciente(@RequestBody PacienteRequest pacienteRequest,@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(pacienteServices.update(id,pacienteRequest));
    }

    //Eliminar por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePacienteById(@PathVariable Long id) {
        pacienteServices.delete(id);
        return ResponseEntity.noContent().build();
    }

}
