package com.application.patientqualificationservice.controllers.dto;

import com.application.patientqualificationservice.common.value.Patient;

public record CreatePatientRequestDTO(String name, String email, String birthDate, String income, String contact, boolean isQualified) {
    public Patient toPatient() {
        return new Patient(null, name, email, birthDate, income, contact, isQualified);
    }
}
