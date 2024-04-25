package com.application.patientqualificationservice.common.value;

public class Patient {
    private String id;
    private String name;
    private String email;
    private String birthDate;
    private String income;
    private String contact;
    private boolean isQualified;

    public Patient(String id, String name, String email, String birthDate, String income, String contact) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.income = income;
        this.contact = contact;
        this.isQualified = isPatientQualified(this);
    }

    public Patient(String id, String name, String email, String birthDate, String income, String contact, boolean isQualified) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.income = income;
        this.contact = contact;
        this.isQualified = isQualified;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getIncome() {
        return income;
    }

    public String getContact() {
        return contact;
    }

    public boolean isQualified() {
        return isQualified;
    }

    private boolean isPatientQualified(final Patient patient) {
        return !(Double.parseDouble(patient.getIncome()) >= 100000);
    }
}
