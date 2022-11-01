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
}
