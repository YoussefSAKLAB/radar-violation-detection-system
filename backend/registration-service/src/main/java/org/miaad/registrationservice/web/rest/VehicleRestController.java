package org.miaad.registrationservice.web.rest;


import org.miaad.registrationservice.dto.VehicleRequestDTO;
import org.miaad.registrationservice.dto.VehicleResponseDTO;
import org.miaad.registrationservice.entities.Vehicle;
import org.miaad.registrationservice.repositories.VehicleRepository;
import org.miaad.registrationservice.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restVehicle")
public class VehicleRestController {
    @Autowired
    private VehicleService vehicleService;

    // Operations in Vehicles

    // Get all vehicles
    @GetMapping("/vehicles")
    public List<Vehicle> getVehicles(){

        return vehicleService.allVehicles();
    }

    // Get vehicle by id
    @GetMapping("/vehicles/{id}")
    public Vehicle getVehicleById(@PathVariable Long id){
        return vehicleService.vehicleById(id);
    }

    // Add vehicle
    @PostMapping("/vehicles")
    public VehicleResponseDTO saveVehicle(@RequestBody VehicleRequestDTO vehicleRequestDTO){

        return vehicleService.addVehicle(vehicleRequestDTO);
    }

    // Update vehicle
    @PutMapping("/vehicles/{id}")
    public Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle){
        return vehicleService.updateVehicle(id,vehicle);
    }

    // Delete vehicle
    @DeleteMapping("/vehicles/{id}")
    public void deleteVehicle(@PathVariable Long id){

        vehicleService.deleteVehicle(id);
    }

    // Get all vehicle pages
    @GetMapping("/pageVehicle")
    public Page<Vehicle> getPageVehicle(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size) {

        return vehicleService.getVehiclesPage(page,size);
    }

    // Get number of all vehicles
    @GetMapping("/count")
    public Long getVehiclesCount() {
        return vehicleService.vehicleCount();
    }

    // Get vehicle by registration number
    @GetMapping("/vehicleByRN/{registrationNumber}")
    public Vehicle getByRegistrationNumber(@PathVariable String registrationNumber){
        return vehicleService.getVehicleByRegistrationNumber(registrationNumber);
    }

}
