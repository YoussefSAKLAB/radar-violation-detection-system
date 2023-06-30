package org.miaad.registrationservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullVehicle",types = Vehicle.class)
public interface VehicleProjection {
    Long getId();
    String getRegistrationNumber();
    String getBrand();
    Double getFiscalPower();
    String getModel();
    Owner getOwner();
}
