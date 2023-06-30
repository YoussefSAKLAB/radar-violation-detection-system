package org.miaad.infractionservice.feign;

import org.miaad.infractionservice.models.Vehicle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "REGISTRATION-SERVICE")
public interface VehicleRestClient {
    @GetMapping("api/restVehicle/vehicleByRN/{registrationNumber}")
    Vehicle getByRegistrationNumber(@PathVariable(name = "registrationNumber") String registrationNumber);
}
