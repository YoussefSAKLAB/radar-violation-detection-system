package org.miaad.radarroad.models;

import lombok.Data;

@Data
public class Vehicle {
    private Long id;
    private String registrationNumber;
    private String brand;
    private Double fiscalPower;
    private String model;

}
