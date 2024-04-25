package com.application.patientqualificationservice.external.repository.patient;

import com.application.patientqualificationservice.common.value.Patient;

import java.util.List;
import java.util.stream.Collectors;

public class PatientModelMapper {
    public PatientModelMapper() {
    }

    static PatientDocument toDocument(final Patient patient) {
        PatientDocument patientDocument = new PatientDocument();

        patientDocument.id = patient.id();
        patientDocument.name = patient.name();
        patientDocument.email = patient.email();
        patientDocument.birthDate = patient.birthDate();
        patientDocument.income = patient.income();
        patientDocument.contact = patient.contact();

        return patientDocument;
    }

    static Patient toPatient(final PatientDocument patientDocument) {
        return new Patient(patientDocument.id, patientDocument.name, patientDocument.email, patientDocument.birthDate,
                patientDocument.income, patientDocument.contact);
    }

    static List<Patient> toPatientList(final List<PatientDocument> patientDocuments) {
        return patientDocuments.stream().map(PatientModelMapper::toPatient).collect(Collectors.toList());
    }
}
