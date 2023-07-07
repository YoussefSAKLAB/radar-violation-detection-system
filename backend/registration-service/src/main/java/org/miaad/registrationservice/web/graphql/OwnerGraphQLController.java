package org.miaad.registrationservice.web.graphql;

import org.miaad.registrationservice.dto.OwnerRequestDTO;
import org.miaad.registrationservice.dto.OwnerResponseDTO;
import org.miaad.registrationservice.entities.Owner;
import org.miaad.registrationservice.repositories.OwnerRepository;
import org.miaad.registrationservice.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OwnerGraphQLController {
    private OwnerRepository ownerRepository;
    @Autowired
    private OwnerService ownerService;

    // Dependencies Injection
    public OwnerGraphQLController(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }
    //Get all Owners
    @QueryMapping
    public List<Owner> getOwners(){
        return ownerService.allOwners();
    }
    //Get Owner By Id
    @QueryMapping
    public Owner getOwnerById(@Argument Long id){
        return ownerService.ownerById(id);
    }
    //Add Owner
    @MutationMapping
    public OwnerResponseDTO addOwner(@Argument(name = "owner") OwnerRequestDTO ownerRequestDTO){
        return ownerService.addOwner(ownerRequestDTO);
    }
    //UpdateOwner
    @MutationMapping
    public OwnerResponseDTO updateOwner(@Argument Long id,@Argument(name = "owner") OwnerRequestDTO ownerRequestDTO){
        return ownerService.updateOwner(id,ownerRequestDTO);
    }
    //Delete Owner By Id
    @MutationMapping
    public Boolean deleteOwner(@Argument Long id){
        return ownerService.deleteOwner(id);
    }
}
