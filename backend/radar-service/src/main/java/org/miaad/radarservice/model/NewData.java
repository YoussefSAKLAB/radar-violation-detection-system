package org.miaad.radarservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewData {
    private Long radarId;
    private String registrationNumber;
    private Long vehicleSpeed;
}
