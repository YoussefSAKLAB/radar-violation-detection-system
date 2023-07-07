package org.miaad.registrationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleRequestDTO {
    private String registrationNumber;
    private String brand;
    private Double fiscalPower;
    private String model;
}
