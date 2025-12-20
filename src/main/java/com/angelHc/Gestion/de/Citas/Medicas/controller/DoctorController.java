package com.angelHc.Gestion.de.Citas.Medicas.controller;

import com.angelHc.Gestion.de.Citas.Medicas.dto.DoctorRequest;
import com.angelHc.Gestion.de.Citas.Medicas.dto.DoctorResponse;
import com.angelHc.Gestion.de.Citas.Medicas.services.impl.DoctorServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@AllArgsConstructor

public class DoctorController {
    private final DoctorServices doctorServices;

    @PostMapping
    public ResponseEntity<DoctorResponse> save(@RequestBody DoctorRequest doctorRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorServices.saveDoctor(doctorRequest));

    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorResponse> update(@RequestBody DoctorRequest doctorRequest,@PathVariable Long id) {
        return ResponseEntity.ok(doctorServices.updateDoctor(doctorRequest,id));
    }


    @GetMapping("/{id}")
    public ResponseEntity<DoctorResponse> findDoctorById(@PathVariable Long id) {
        return ResponseEntity.ok(doctorServices.findDoctorById(id));
    }

    @GetMapping()
    public ResponseEntity<List<DoctorResponse>> findAll() {
        return ResponseEntity.ok(doctorServices.findAllDoctor());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id) {
        doctorServices.deleteDoctor(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}
