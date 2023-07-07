package org.miaad.registrationservice.services;

import org.miaad.registrationservice.dto.OwnerRequestDTO;
import org.miaad.registrationservice.dto.OwnerResponseDTO;
import org.miaad.registrationservice.entities.Owner;

import java.util.List;

public interface OwnerService {
    public OwnerResponseDTO addOwner(OwnerRequestDTO ownerRequestDTO);
    public OwnerResponseDTO updateOwner(Long id,OwnerRequestDTO ownerRequestDTO);
    public Owner updateOwner(Long id,Owner owner);
    public Boolean deleteOwner(Long id);
    public List<Owner> allOwners();
    public Owner ownerById(Long id);
    public Long ownerCount();
}
