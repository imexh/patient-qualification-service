package com.application.patientqualificationservice.services;

import com.application.patientqualificationservice.common.value.Patient;
import com.application.patientqualificationservice.controllers.dto.PatientViewResponseDTO;

import java.util.List;

public interface IPatientService {
    PatientViewResponseDTO createPatient(Patient patient);

    PatientViewResponseDTO getPatientById(String id);

    List<PatientViewResponseDTO> getAllPatients();

    boolean isPatientQualified(String id);
}
