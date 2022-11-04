package entity;

import base.entity.BaseEntity;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Clinic extends BaseEntity<Long> {

    @Column(nullable = false)
    private String name;

    @OneToOne // har clinic y admin dare
    private Admin admin;

    @OneToMany(mappedBy = "clinic") // har clinic chan ta doctor dare
    private Set<Doctor> doctors = new HashSet<>();

    @ManyToMany(mappedBy = "clinics") // har clinic chan ta patient dare
    private Set<Patient> patients = new HashSet<>();

    public Clinic(String name) {
        this.name = name;
    }

    public Clinic(String name, Admin admin) {
        this.name = name;
        this.admin = admin;
    }

    public Clinic() {
    }

    @Override
    public String toString() {
        return "Clinic {" +
                "name = '" + name + '\'' +
                "} ";
    }
}
