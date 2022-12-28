package com.tiendamotos.services.helmet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HelmetApplicaton {

    public static void main (String [] args){
        SpringApplication.run(HelmetApplicaton.class, args);
    }
}
