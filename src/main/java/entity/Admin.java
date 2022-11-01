package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Admin extends Person {

    @OneToOne(mappedBy = "admin") // har admin bara y clinic
    private Clinic clinic;

}
