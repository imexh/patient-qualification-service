package com.application.patientqualificationservice.services.impl;

import com.application.patientqualificationservice.common.value.Patient;
import com.application.patientqualificationservice.controllers.dto.PatientViewResponseDTO;
import com.application.patientqualificationservice.external.repository.IPatientRepository;
import com.application.patientqualificationservice.services.IPatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService implements IPatientService {
    private final IPatientRepository patientRepository;

    public PatientService(final IPatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public PatientViewResponseDTO createPatient(final Patient patient) {
        return new PatientViewResponseDTO(patientRepository.persistPatient(patient));
    }

    @Override
    public PatientViewResponseDTO getPatientById(final String id) {
        return new PatientViewResponseDTO(patientRepository.getPatientById(id));
    }

    @Override
    public List<PatientViewResponseDTO> getAllPatients() {
        return patientRepository.getAllPatients().stream()
                .map(PatientViewResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isPatientQualified(final String id) {
        final Patient patient = patientRepository.getPatientById(id);

        return patient.isQualified();
    }
}
