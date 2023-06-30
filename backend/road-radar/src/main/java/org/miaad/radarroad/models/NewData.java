package org.miaad.radarroad.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class NewData{
    private Long radarId;
    private String registrationNumber;
    private Long vehicleSpeed;
}
