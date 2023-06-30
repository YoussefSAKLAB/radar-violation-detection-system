package org.miaad.radarroad.models;

import lombok.Data;

@Data
public class Radar {
    private Long id;
    private String name;
    private Boolean status;
    private Long maxSpeed;
    private Long longitude;
    private Long latitude;
}