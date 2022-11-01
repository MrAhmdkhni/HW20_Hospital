package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Doctor extends Person {

    @ManyToOne // har doctor bara y clinic
    private Clinic clinic;

    @OneToMany(mappedBy = "doctor") // har doctor chan ta prescription
    private Set<Prescription> prescriptions = new HashSet<>();
}
