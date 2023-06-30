package org.miaad.registrationservice.services;

import org.miaad.registrationservice.dto.OwnerRequestDTO;
import org.miaad.registrationservice.dto.OwnerResponseDTO;
import org.miaad.registrationservice.entities.Owner;
import org.miaad.registrationservice.entities.Vehicle;
import org.miaad.registrationservice.mappers.OwnerMapper;
import org.miaad.registrationservice.repositories.OwnerRepository;
import org.miaad.registrationservice.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService{
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private OwnerMapper ownerMapper;

    @Override
    public OwnerResponseDTO addOwner(OwnerRequestDTO ownerRequestDTO) {
        Owner owner=Owner.builder()
                .name(ownerRequestDTO.getName())
                .birthDate(ownerRequestDTO.getBirthDate())
                .email(ownerRequestDTO.getEmail())
                .build();
        Owner savedOwner=ownerRepository.save(owner);
        OwnerResponseDTO ownerResponseDTO= ownerMapper.fromOwner(savedOwner);

        return ownerResponseDTO;
    }

    @Override
    public OwnerResponseDTO updateOwner(Long id, OwnerRequestDTO ownerRequestDTO) {
        Owner owner=Owner.builder()
                .id(id)
                .name(ownerRequestDTO.getName())
                .birthDate(ownerRequestDTO.getBirthDate())
                .email(ownerRequestDTO.getEmail())
                .build();
        Owner savedOwner=ownerRepository.save(owner);
        OwnerResponseDTO ownerResponseDTO= ownerMapper.fromOwner(savedOwner);

        return ownerResponseDTO;
    }

    @Override
    public Owner updateOwner(Long id, Owner owner) {
        Owner o = ownerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Owner with this id :%s is not found !", id)));

        if (owner.getName() != null) o.setName(owner.getName());
        if (owner.getEmail() != null) o.setEmail(owner.getEmail());
        if (owner.getBirthDate() != null) o.setBirthDate(owner.getBirthDate());
        if (owner.getVehicles() != null) o.setVehicles(owner.getVehicles());

        return ownerRepository.save(o);
    }

    @Override
    public Boolean deleteOwner(Long id) {
        Owner o = ownerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Owner with this id :%s is not found !", id)));
        for(Vehicle vehicle :o.getVehicles()){
            vehicle.setOwner(null);
            vehicleRepository.save(vehicle);
        }
        o.setVehicles(null);
        ownerRepository.save(o);
        ownerRepository.delete(o);
        return true;
    }

    @Override
    public List<Owner> allOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public Owner ownerById(Long id) {
        return ownerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(String.format("Owner  %s not found",id)));
    }
}

