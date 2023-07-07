package org.miaad.registrationservice.services;

import org.miaad.registrationservice.dto.VehicleRequestDTO;
import org.miaad.registrationservice.dto.VehicleResponseDTO;
import org.miaad.registrationservice.entities.Vehicle;
import org.springframework.data.domain.Page;

import java.util.List;

public interface VehicleService {
    public VehicleResponseDTO addVehicle(VehicleRequestDTO vehicleRequestDTO);
    public VehicleResponseDTO updateVehicle(Long id,VehicleRequestDTO vehicleRequestDTO);
    public Boolean deleteVehicle(Long id);
    public Vehicle updateVehicle(Long id, Vehicle vehicle);
    public List<Vehicle> allVehicles();
    public Vehicle vehicleById(Long id);
    public Long vehicleCount();
    public Page<Vehicle> getVehiclesPage(int page,int size);
    public Vehicle getVehicleByRegistrationNumber(String registrationNumber);
}
