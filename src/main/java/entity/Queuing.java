package entity;

import base.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
public class Queuing extends BaseEntity<Long> {

    @CreationTimestamp
    private LocalDate date;
    @Column(name = "start-time")
    private LocalTime startTime;
    @Column(name = "end-time")
    private LocalTime endTime;
    @Column(name = "visit-time")
    private LocalTime visitTime;


    @ManyToOne
    private Patient patient;
    @OneToOne
    private Doctor doctor;

    public Queuing(LocalDate date, LocalTime startTime, LocalTime endTime) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.visitTime = startTime;
    }

    public Queuing(LocalDate date, LocalTime startTime, LocalTime endTime, Doctor doctor) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.visitTime = startTime;
        this.doctor = doctor;
    }

    public Queuing() {
    }

    @Override
    public String toString() {
        return "\nQueuing {" +
                "date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", visitTime=" + visitTime +
                ", patient=" + patient +
                ", doctor=" + doctor +
                "}\n";
    }
}
