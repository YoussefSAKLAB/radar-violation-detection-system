package org.miaad.registrationservice.entities;

import org.springframework.data.rest.core.config.Projection;

import java.util.Date;
import java.util.List;

@Projection(name = "fullOwner",types = Owner.class)
public interface OwnerProjection {
    Long getId();
    String getName();
    Date getBirthDate();
    String getEmail();
    List<Vehicle> getVehicles();
}
