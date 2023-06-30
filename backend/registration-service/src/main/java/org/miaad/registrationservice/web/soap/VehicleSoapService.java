package org.miaad.registrationservice.web.soap;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.miaad.registrationservice.dto.VehicleRequestDTO;
import org.miaad.registrationservice.dto.VehicleResponseDTO;
import org.miaad.registrationservice.entities.Vehicle;
import org.miaad.registrationservice.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@WebService(name = "VehicleSoapService")
public class VehicleSoapService {
    @Autowired
    private VehicleService vehicleService;

    // Operations in Vehicles

    // Get all vehicles
    @WebMethod
    public List<Vehicle> getVehicles(){

        return vehicleService.allVehicles();
    }

    // Get vehicle by id
    @WebMethod
    public Vehicle getVehicleById(@WebParam(name ="id") Long id){
        return vehicleService.vehicleById(id);
    }

    // Add vehicle
    @WebMethod
    public VehicleResponseDTO saveVehicle(@WebParam(name ="vehicle") VehicleRequestDTO vehicleRequestDTO){

        return vehicleService.addVehicle(vehicleRequestDTO);
    }

    // Update vehicle
    @WebMethod
    public Vehicle updateVehicle(@WebParam(name ="id") Long id, @WebParam(name ="vehicle") Vehicle vehicle){
        return vehicleService.updateVehicle(id,vehicle);
    }

    // Delete vehicle
    @WebMethod
    public void deleteVehicle(@WebParam(name ="id") Long id){

        vehicleService.deleteVehicle(id);
    }

    // Get number of all vehicles
    @WebMethod
    public Long getVehiclesCount() {
        return vehicleService.vehicleCount();
    }

    // Get vehicle by registration number
    @WebMethod
    public Vehicle getByRegistrationNumber(@WebParam(name ="registrationNumber") String registrationNumber){
        return vehicleService.getVehicleByRegistrationNumber(registrationNumber);
    }
}
