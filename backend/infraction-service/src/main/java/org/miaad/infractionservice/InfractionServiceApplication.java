package org.miaad.infractionservice;

import org.miaad.infractionservice.entites.Infraction;
import org.miaad.infractionservice.repositories.InfractionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
@EnableFeignClients
public class InfractionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfractionServiceApplication.class, args);
    }


    Random random = new Random();

    @Bean
    CommandLineRunner start(InfractionRepository infractionRepository) {
        return args -> {
            Stream.of("inf1", "inf2", "inf3", "inf4").forEach(i -> {
                Infraction infraction = Infraction.builder()
                        .paid(false)
                        .date(new Date())
                        .radarId(2L)
                        .radarMaxSpeed(150L)
                        .vehicleRegistrationNumber("A2000")
                        .infractionAmount(3000L)
                        .vehicleSpeed(200L)
                        .build();
                infractionRepository.save(infraction);
            });
        };
    }
}
