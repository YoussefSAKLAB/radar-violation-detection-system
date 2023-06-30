package org.miaad.registrationservice.web.soap;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import lombok.AllArgsConstructor;
import org.miaad.registrationservice.dto.OwnerRequestDTO;
import org.miaad.registrationservice.dto.OwnerResponseDTO;
import org.miaad.registrationservice.entities.Owner;
import org.miaad.registrationservice.repositories.OwnerRepository;
import org.miaad.registrationservice.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@WebService(name = "OwnerSoapService")
@AllArgsConstructor
public class OwnerSoapService {
    private OwnerRepository ownerRepository;
    @Autowired
    private OwnerService ownerService;

    //Get All owners
    @WebMethod
    public List<Owner> getOwners() {
        return ownerService.allOwners();
    }

    // Get owner by id
    @WebMethod
    public Owner getOwnerById(@WebParam(name = "id") Long id) {
        return ownerService.ownerById(id);
    }

    // Save owner
    @WebMethod
    public OwnerResponseDTO saveOwner(@WebParam(name = "owner") OwnerRequestDTO ownerRequestDTO) {
        return ownerService.addOwner(ownerRequestDTO);
    }

    // Update owner
    @WebMethod
    public Owner updateOwner(@WebParam(name = "id") Long id, @WebParam(name = "owner") Owner owner) {
        return ownerService.updateOwner(id,owner);
    }

    // Delete owner
    @WebMethod
    public void deleteOwner(@WebParam(name = "id") Long id) {
        ownerService.deleteOwner(id);
    }

}
