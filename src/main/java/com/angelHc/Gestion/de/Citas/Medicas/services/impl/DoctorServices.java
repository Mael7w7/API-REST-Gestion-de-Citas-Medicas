package com.angelHc.Gestion.de.Citas.Medicas.services.impl;

import com.angelHc.Gestion.de.Citas.Medicas.dto.DoctorRequest;
import com.angelHc.Gestion.de.Citas.Medicas.dto.DoctorResponse;

import com.angelHc.Gestion.de.Citas.Medicas.entity.DoctorEntity;

import com.angelHc.Gestion.de.Citas.Medicas.mapper.DoctorMapper;
import com.angelHc.Gestion.de.Citas.Medicas.repository.DoctorRepository;
import com.angelHc.Gestion.de.Citas.Medicas.services.IDoctorServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class DoctorServices implements IDoctorServices {
    private final DoctorRepository repository;


    @Override
    public DoctorResponse saveDoctor(DoctorRequest doctorRequest) {
        DoctorEntity doctor = new DoctorEntity();
        doctor.setNombre(doctorRequest.getNombre());
        doctor.setEspecialidad(doctorRequest.getEspecialidad());

        var tar = repository.save(doctor);

        return DoctorMapper.mapperDocor(tar);

    }

    @Override
    public List<DoctorResponse> findAllDoctor() {
        List<DoctorEntity> doctors = repository.findAll();

        return doctors.stream()
                .map(DoctorMapper::mapperDocor
                ).collect(Collectors.toList());
    }


    @Override
    public DoctorResponse findDoctorById(Long id) {
        DoctorEntity doctor = repository.findById(id)
                .orElseThrow(()->new RuntimeException("El id del doctor no existe"));

        return DoctorMapper.mapperDocor(doctor);
    }

    @Override
    public DoctorResponse updateDoctor(DoctorRequest doctorRequest, Long id) {
        DoctorEntity doctor = repository.findById(id)
                .orElseThrow(()->new RuntimeException("El id del doctor no existe"));

        doctor.setNombre(doctorRequest.getNombre());
        doctor.setEspecialidad(doctorRequest.getEspecialidad());
        var tar = repository.save(doctor);


        return DoctorMapper.mapperDocor(tar);
    }

    @Override
    public void deleteDoctor(Long id) {

        DoctorEntity doctor = repository.findById(id)
                .orElseThrow(()->new RuntimeException("El id del doctor no existe"));

        doctor.setActivo(false);
        repository.save(doctor);


    }
}
