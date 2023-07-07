package org.miaad.registrationservice.services;


import org.miaad.registrationservice.dto.VehicleRequestDTO;
import org.miaad.registrationservice.dto.VehicleResponseDTO;
import org.miaad.registrationservice.entities.Vehicle;
import org.miaad.registrationservice.mappers.VehicleMapper;
import org.miaad.registrationservice.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService{
    @Autowired
    private VehicleMapper vehicleMapper;
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public VehicleResponseDTO addVehicle(VehicleRequestDTO vehicleRequestDTO) {
        Vehicle vehicle=Vehicle.builder()
                .registrationNumber(vehicleRequestDTO.getRegistrationNumber())
                .brand(vehicleRequestDTO.getBrand())
                .fiscalPower(vehicleRequestDTO.getFiscalPower())
                .model(vehicleRequestDTO.getModel())
                .build();
        Vehicle savedVehicle=vehicleRepository.save(vehicle);
        VehicleResponseDTO vehicleResponseDTO=vehicleMapper.fromVehicle(savedVehicle);
        return vehicleResponseDTO;
    }

    @Override
    public VehicleResponseDTO updateVehicle(Long id, VehicleRequestDTO vehicleRequestDTO) {
        Vehicle vehicle=Vehicle.builder()
                .id(id)
                .registrationNumber(vehicleRequestDTO.getRegistrationNumber())
                .brand(vehicleRequestDTO.getBrand())
                .fiscalPower(vehicleRequestDTO.getFiscalPower())
                .model(vehicleRequestDTO.getModel())
                .build();
        Vehicle savedVehicle=vehicleRepository.save(vehicle);
        VehicleResponseDTO vehicleResponseDTO=vehicleMapper.fromVehicle(savedVehicle);
        return vehicleResponseDTO;
    }

    @Override
    public Boolean deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
        return true;
    }

    @Override
    public Vehicle updateVehicle(Long id, Vehicle vehicle) {
        Vehicle v = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Vehicle %s not found !", id)));

        if(vehicle.getModel() != null) v.setModel(vehicle.getModel());
        if(vehicle.getBrand() != null) v.setBrand(vehicle.getBrand());
        if(vehicle.getFiscalPower() != null) v.setFiscalPower(vehicle.getFiscalPower());
        if(vehicle.getRegistrationNumber() != null) v.setRegistrationNumber(vehicle.getRegistrationNumber());
        if(vehicle.getOwner() != null) v.setOwner(vehicle.getOwner());

        return vehicleRepository.save(v);
    }

    @Override
    public List<Vehicle> allVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle vehicleById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Vehicle %s not found !", id)));
    }

    @Override
    public Long vehicleCount() {
        return vehicleRepository.count();
    }

    @Override
    public Page<Vehicle> getVehiclesPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return vehicleRepository.findAll(pageable);
    }

    @Override
    public Vehicle getVehicleByRegistrationNumber(String registrationNumber) {
        return vehicleRepository.findVehicleByRegistrationNumber(registrationNumber);
    }
}

