package com.application.patientqualificationservice.external.repository;

import com.application.patientqualificationservice.common.value.Patient;

import java.util.List;

public interface IPatientRepository {
    Patient persistPatient(final Patient patient);

    Patient getPatientById(final String identity);

    List<Patient> getAllPatients();
}
