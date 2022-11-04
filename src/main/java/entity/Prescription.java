package entity;

import base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Prescription extends BaseEntity<Long> {

    private String description;

    @ManyToOne // har prescription bar y patient
    private Patient patient;

    @ManyToOne // har prescription bar y doctor
    private Doctor doctor;

    public Prescription(String description, Patient patient, Doctor doctor) {
        this.description = description;
        this.patient = patient;
        this.doctor = doctor;
    }

    public Prescription() {
    }

    @Override
    public String toString() {
        return "Prescription {" +
                "description = '" + description + '\'' +
                ", patient = '" + patient.getFirstname() + " " + patient.getLastname() + '\'' +
                ", doctor = '" + doctor.getFirstname() + " " + doctor.getLastname() + '\'' +
                "} ";
    }
}
