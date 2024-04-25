package com.application.patientqualificationservice.controllers;

import com.application.patientqualificationservice.controllers.dto.CreatePatientRequestDTO;
import com.application.patientqualificationservice.controllers.dto.PatientViewResponseDTO;
import com.application.patientqualificationservice.services.IPatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class PatientHandler {
    private final IPatientService patientService;

    public PatientHandler(final IPatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/patients")
    public ResponseEntity<PatientViewResponseDTO> createPatient(
            @RequestBody final CreatePatientRequestDTO requestDTO) {

        return new ResponseEntity<>(this.patientService.createPatient(requestDTO.toPatient()), HttpStatus.OK);
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<PatientViewResponseDTO> getPatientById(
            @PathVariable final String id) {
        return new ResponseEntity<>(this.patientService.getPatientById(id), HttpStatus.OK);
    }

    @GetMapping("/patients")
    public ResponseEntity<List<PatientViewResponseDTO>> getAllPatients() {
        return new ResponseEntity<>(this.patientService.getAllPatients(), HttpStatus.OK);
    }

    @GetMapping("/patients/{id}/qualified")
    public ResponseEntity<Boolean> isPatientQualified(
            @PathVariable final String id) {
        return new ResponseEntity<>(this.patientService.isPatientQualified(id), HttpStatus.OK);
    }
}
