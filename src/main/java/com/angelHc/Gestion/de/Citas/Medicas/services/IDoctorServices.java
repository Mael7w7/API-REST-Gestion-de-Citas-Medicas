package com.angelHc.Gestion.de.Citas.Medicas.services;

import com.angelHc.Gestion.de.Citas.Medicas.dto.DoctorRequest;
import com.angelHc.Gestion.de.Citas.Medicas.dto.DoctorResponse;

import java.util.List;

public interface IDoctorServices {

    DoctorResponse saveDoctor(DoctorRequest doctorRequest);
    List<DoctorResponse> findAllDoctor();
    DoctorResponse findDoctorById(Long id);
    DoctorResponse updateDoctor(DoctorRequest doctorRequest, Long id);
    void  deleteDoctor(Long id);

}
