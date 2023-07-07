package org.miaad.registrationservice.repositories;

import org.miaad.registrationservice.entities.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    // get vehicle by regestration number
    Vehicle findVehicleByRegistrationNumber(String rn);

    // Search vehiclen by regestration number containing keyword
    Page<Vehicle> findByRegistrationNumberContaining(String keyword, Pageable pageable);
}
