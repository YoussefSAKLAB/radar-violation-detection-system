package org.miaad.registrationservice.mappers;

import org.miaad.registrationservice.dto.VehicleResponseDTO;
import org.miaad.registrationservice.entities.Vehicle;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {
    public VehicleResponseDTO fromVehicle(Vehicle vehicle){
        VehicleResponseDTO vehicleResponseDTO=new VehicleResponseDTO();
        BeanUtils.copyProperties(vehicle, vehicleResponseDTO);
        return vehicleResponseDTO;
    }
}
