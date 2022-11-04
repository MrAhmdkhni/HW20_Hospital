package entity;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QueuingDTO {
    private LocalDate date;
    private LocalTime visitTime;
    private DoctorDTO doctorDTO;

    @Override
    public String toString() {
        return "\nQueuingDTO {" +
                "date=" + date +
                ", visitTime = " + visitTime +
                ", doctorDTO = " + doctorDTO +
                "}\n";
    }
}
