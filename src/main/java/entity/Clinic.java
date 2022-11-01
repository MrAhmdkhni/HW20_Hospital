package entity;

import base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Clinic extends BaseEntity<Long> {

    private String name;

    @OneToOne // har clinic y admin dare
    private Admin admin;

    @OneToMany(mappedBy = "clinic") // har clinic chan ta doctor dare
    private Set<Doctor> doctors = new HashSet<>();

    @ManyToMany(mappedBy = "clinics") // har clinic chan ta patient dare
    private Set<Patient> patients = new HashSet<>();
}
