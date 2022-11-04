package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Doctor extends Person {

    @ManyToOne // har doctor bara y clinic
    private Clinic clinic;

    @OneToMany(mappedBy = "doctor") // har doctor chan ta prescription
    private Set<Prescription> prescriptions = new HashSet<>();

    public Doctor(String firstname, String lastname, String nationalCode, String username, String password) {
        super(firstname, lastname, nationalCode, username, password);
    }

    public Doctor() {
    }


}
