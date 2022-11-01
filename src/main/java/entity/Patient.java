package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Patient extends Person {

    @ManyToMany // har patient chan ta clinic dare
    private Set<Clinic> clinics = new HashSet<>();

    @OneToMany(mappedBy = "patient") // har patient chan ta prescription dare
    private Set<Prescription> prescriptions = new HashSet<>();


    public Patient(String firstname, String lastname, String nationalCod, String username, String password) {
        super(firstname, lastname, nationalCod, username, password);
    }

    public Patient() {
    }
}
