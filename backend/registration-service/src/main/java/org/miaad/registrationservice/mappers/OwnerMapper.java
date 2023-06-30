package org.miaad.registrationservice.mappers;

import org.miaad.registrationservice.dto.OwnerResponseDTO;
import org.miaad.registrationservice.entities.Owner;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class OwnerMapper {
    public OwnerResponseDTO fromOwner(Owner owner){
        OwnerResponseDTO ownerResponseDTO=new OwnerResponseDTO();
        BeanUtils.copyProperties(owner, ownerResponseDTO);
        return ownerResponseDTO;
    }
}