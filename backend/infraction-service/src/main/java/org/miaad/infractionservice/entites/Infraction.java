package org.miaad.infractionservice.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.miaad.infractionservice.models.Radar;
import org.miaad.infractionservice.models.Vehicle;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Infraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;

    private Boolean paid;
    private Long radarId;
    private String vehicleRegistrationNumber;
    @Transient
    private Vehicle vehicle;
    private Long vehicleSpeed;
    @Transient
    private Radar radar;
    private Long radarMaxSpeed;
    private Long infractionAmount;
}
