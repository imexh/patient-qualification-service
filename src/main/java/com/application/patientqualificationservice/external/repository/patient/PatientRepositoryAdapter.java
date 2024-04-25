package com.application.patientqualificationservice.external.repository.patient;

import com.application.patientqualificationservice.common.value.Patient;
import com.application.patientqualificationservice.external.repository.IPatientRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class PatientRepositoryAdapter implements IPatientRepository {
    private final MongoTemplate mongoTemplate;

    public PatientRepositoryAdapter(final MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Patient persistPatient(final Patient patient) {
        Objects.requireNonNull(patient, "Patient repository required non null patient, got null.");

        PatientDocument patientDocument = PatientModelMapper.toDocument(patient);

        return PatientModelMapper.toPatient(mongoTemplate.save(patientDocument));
    }

    @Override
    public Patient getPatientById(final String identity) {
        final PatientDocument patientDocument = mongoTemplate.findById(identity, PatientDocument.class);

        return patientDocument != null ? PatientModelMapper.toPatient(patientDocument) : null;
    }

    @Override
    public List<Patient> getAllPatients() {
        List<PatientDocument> patientDocuments = mongoTemplate.findAll(PatientDocument.class);
        return PatientModelMapper.toPatientList(patientDocuments);
    }
}
