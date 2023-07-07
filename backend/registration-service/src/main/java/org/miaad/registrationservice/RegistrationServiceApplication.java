package org.miaad.registrationservice;

import org.miaad.registrationservice.entities.Owner;
import org.miaad.registrationservice.entities.Vehicle;
import org.miaad.registrationservice.repositories.OwnerRepository;
import org.miaad.registrationservice.repositories.VehicleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Random;

@SpringBootApplication
public class RegistrationServiceApplication {

    Random random = new Random();

    public static void main(String[] args) {
        SpringApplication.run(RegistrationServiceApplication.class, args);
    }
    char c;
    // Add data to H2 database in start of application
    @Bean
    CommandLineRunner start(VehicleRepository vehicleRepository, OwnerRepository ownerRepository) {
        return args -> {
            ownerRepository.save(new Owner(null,"Youssef",new Date(),"youssef@gmail.com",null));
            ownerRepository.save(new Owner(null,"Soukayna",new Date(),"soukayna@gmail.com",null));
            ownerRepository.save(new Owner(null,"Zaynab",new Date(),"zaynab@gmail.com",null));
            ownerRepository.save(new Owner(null,"Mohamed",new Date(),"mohamed@gmail.com",null));
            ownerRepository.findAll().forEach(o->{
                c=(char)(random.nextInt(26) + 'A');
                for (int i = 0; i < 3; i++) {
                    vehicleRepository.save(new Vehicle(null
                            ,random.nextInt(26)+""+c+""+random.nextInt(10000)
                            ,"brand"+random.nextInt(30)
                            ,Double.valueOf(Double.valueOf(6+random.nextInt(20)))
                            ,"A"+random.nextInt(30)
                            ,o));
                }
            });
        };
    }
}
