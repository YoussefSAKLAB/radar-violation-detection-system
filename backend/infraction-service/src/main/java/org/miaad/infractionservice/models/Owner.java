package org.miaad.infractionservice.models;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Owner {
    private Long id;
    private String name;
    private Date birthDate;
    private String email;
    private List<Vehicle> vehicles;
}
