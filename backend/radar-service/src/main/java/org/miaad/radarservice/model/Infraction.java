package org.miaad.radarservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Infraction {
    private Long id;
    private Date date;
    private Boolean paid;
    private Long radarId;
    private String vehicleRegistrationNumber;
    private Long vehicleSpeed;
    private Long radarMaxSpeed;
    private Long infractionAmount;
}
