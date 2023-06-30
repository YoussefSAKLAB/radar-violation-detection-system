package org.miaad.registrationservice.web.rest;


import org.miaad.registrationservice.dto.OwnerRequestDTO;
import org.miaad.registrationservice.dto.OwnerResponseDTO;
import org.miaad.registrationservice.entities.Owner;
import org.miaad.registrationservice.repositories.OwnerRepository;
import org.miaad.registrationservice.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restOwner/")
public class OwnerRestController {
    @Autowired
    private OwnerService ownerService;

    //Get All owners
    @GetMapping("/owners")
    public List<Owner> getOwners() {
        return ownerService.allOwners();
    }

    // Get owner by id
    @GetMapping("/owners/{id}")
    public Owner getOwnerById(@PathVariable Long id) {
        return ownerService.ownerById(id);
    }

    // Save owner
    @PostMapping("/owners")
    public OwnerResponseDTO saveOwner(@RequestBody OwnerRequestDTO ownerRequestDTO) {
        return ownerService.addOwner(ownerRequestDTO);
    }

    // Update owner
    @PutMapping("/owners/{id}")
    public Owner updateOwner(@PathVariable Long id, @RequestBody Owner owner) {
        return ownerService.updateOwner(id,owner);
    }

    // Delete owner
    @DeleteMapping("/owners/{id}")
    public void deleteOwner(@PathVariable(name = "id") Long id) {
        ownerService.deleteOwner(id);
    }
}
