package org.miaad.infractionservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Radar {
    private Long id;
    private String name;
    private Boolean status;
    private Long maxSpeed;
    private Long longitude;
    private Long latitude;

}
