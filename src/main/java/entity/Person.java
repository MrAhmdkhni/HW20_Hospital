package entity;

import base.entity.BaseEntity;
import jakarta.persistence.*;

@MappedSuperclass
public class Person extends BaseEntity<Long> {

    private String firstname;
    private String lastname;
    private String nationalCod;
    private String username;
    private String password;

    public Person(String firstname, String lastname, String nationalCod, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.nationalCod = nationalCod;
        this.username = username;
        this.password = password;
    }

    public Person() {
    }
}
