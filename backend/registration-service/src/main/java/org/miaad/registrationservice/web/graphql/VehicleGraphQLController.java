package org.miaad.registrationservice.web.graphql;

import org.miaad.registrationservice.dto.VehicleRequestDTO;
import org.miaad.registrationservice.dto.VehicleResponseDTO;
import org.miaad.registrationservice.entities.Vehicle;
import org.miaad.registrationservice.repositories.VehicleRepository;
import org.miaad.registrationservice.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VehicleGraphQLController {
    @Autowired
    private VehicleService vehicleService;
    // - Get all vehicles
    @QueryMapping
    public List<Vehicle> getVehicles(){
        return vehicleService.allVehicles();
    }

    // - Get vehicle by id
    @QueryMapping
    public Vehicle getVehicleById(@Argument Long id){
        return vehicleService.vehicleById(id);
    }

    // - Save vehicle
    @MutationMapping
    public VehicleResponseDTO addVehicle(@Argument(name = "vehicle") VehicleRequestDTO vehicleRequestDTO){
        return vehicleService.addVehicle(vehicleRequestDTO);
    }

    // - Update vehicle
    @MutationMapping
    public VehicleResponseDTO updateVehicle(@Argument Long id, @Argument(name = "vehicle") VehicleRequestDTO vehicleRequestDTO){
        return vehicleService.updateVehicle(id,vehicleRequestDTO);
    }
    // - Delete vehicle
    @MutationMapping
    public Boolean deleteVehicle(@Argument Long id){
        return vehicleService.deleteVehicle(id);
    }
}


